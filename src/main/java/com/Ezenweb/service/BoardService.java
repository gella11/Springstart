package com.Ezenweb.service;

import com.Ezenweb.domain.dto.BcategoryDto;
import com.Ezenweb.domain.dto.BoardDto;
import com.Ezenweb.domain.dto.PageDto;
import com.Ezenweb.domain.entity.Board.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

@Service // 컴포넌트 [ Stpring MVC ]
public class BoardService {
    // ------------1.전역변수---------------//
    @Autowired
    private HttpServletRequest request; // 요청 객체 선언
    @Autowired
    private HttpServletResponse response; // 응답 객체 선언
    @Autowired
    private MemberRepository memberRepository; // 회원 리포지토리 객체 선언
    @Autowired
    private MemberService memberService;
    @Autowired
    private BoardRepository boardRepository;// 게시물 리포지토리 객체 선언
    @Autowired
    private BcategoryRepository bcategoryRepository;

    String path = "C:\\upload\\";  // C드라이브-> upload 폴더 생성
    
    
    // @Transactional : 엔티티 DML 적용 할때 사용되는 어노테이션
    // 1. 메소드
            /*
                1. insert : boardRepository.save( 삽입할엔티티 )            BoardEntity entity
                2. select : boardRepository.findAll()                List<BoardEntity> elist
                3. select : boardRepository.findById( pk번호 )        Optional<BoardEntity> optional
                4. delete : boardRepository.delete( 삭제할엔티티 )
             */
    // ------------ 2. 서비스 ------------- //
    
    // 0. 첨부파일 다운로드
    public void filedownload( String filename) {
        // uuid 제거
        String realfile = filename.split("_")[1];
        // 1. 경로 찾기
        String filepath = path+filename;
        // 2. 헤더 구성
        try{
            response.setHeader(
                    "Content-Disposition",  // 다운로드 형식 [브라우저 마다 다름 ]
                    "attachment; filename=" + URLEncoder.encode(realfile, "UTF-8")); // 다운로드에 표시될 파일명

            File file = new File(filepath);

            // 3. 파일 다운로드 스트림[]
            // 1) 다운로드 할 파일 바이트 읽어오기
            BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
            // 2) 읽어온 바이트 저장
            byte[] bytes = new byte[ (int)file.length()];
            // 3) 파일의 길이만큼 읽어와서 배열에 저장
            fin.read(bytes);
            // 4) 출력 스트림 객체 선언
            BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
            // 5) 응답하기 [ 내보내기 ]
            fout.write(bytes);
            //♨ 6) 버퍼 초기화 |or| 스트림 닫기
            fout.flush(); fout.flush(); fin.close();
        }
        catch( Exception e ){System.out.println("다운로드 오류"+e);}


    }

    // 첨부파일 업로드
    public boolean fileupload( BoardDto boardDto , BoardEntity boardEntity) {
        //if (boardDto.getBfile() != null) { // ** 첨부파일 있을때
        if( !boardDto.getBfile().getOriginalFilename().equals("") ) { // ** 첨부파일 있을때
            // * 업로드 된 파일의 이름 [ 문제점 : 파일명 중복 ]
            String uuid = UUID.randomUUID().toString(); // 1. 난수생성
            String filename = uuid + "_" + boardDto.getBfile().getOriginalFilename(); // 2. 난수+파일명
            // * 첨부파일명 db 에 등록
            boardEntity.setBfile(filename); // 해당 파일명 엔티티에 저장 // 3. 난수+파일명 엔티티 에 저장

            // * 첨부파일 업로드 // 3. 저장할 경로 [ 전역변수 ]

            try {
                File uploadfile = new File(path + filename);  // 4. 경로+파일명 [ 객체화 ]
                boardDto.getBfile().transferTo(uploadfile);   // 5. 해당 객체 경로 로 업로드
            } catch (Exception e) {
                System.out.println("첨부파일 업로드 실패 ");
            }
        return true;
        }else{return false;}
    }

    // 1. 게시물 쓰기
    @Transactional
    public boolean setboard( BoardDto boardDto ){
        // ---------- 로그인 회원 찾기 메소드 실행 --> 회원엔티티 검색 --------------  //
        MemberEntity memberEntity = memberService.getEntity(); // * 시큐리티 적용하기 전/후 확인
        if( memberEntity == null ){ return false; }
        // ---------------------------- //
        // ------------ 선택한 카테고리 번호 --> 카테고리 엔티티 검색 --------------  //
        Optional<BcategoryEntity> optional = bcategoryRepository.findById( boardDto.getBcno() );
        if ( !optional.isPresent()) { return false;}
        BcategoryEntity bcategoryEntity = optional.get();
        // --------------------------  //
        BoardEntity boardEntity  = boardRepository.save( boardDto.toEntity() );  // 1. dto --> entity [ INSERT ] 저장된 entity 반환
        System.out.println("♨♨♨♨♨♨"+boardEntity);
        if( boardEntity.getBno() != 0 ){   // 2. 생성된 entity의 게시물번호가 0 이 아니면  성공

            // 1. MultipartFile 인터페이스
            // .getOriginalFilename() : 해당 인터페이스에 연결(주소)된 파일의 이름 호출
            // .transferTo() : 파일이동[ 사용자pc ---> 개발자 pc ]
            // .transferTo( 파일객체 )
            // File : java 외 파일을 객체화 클래스
            // new File("경로") : 해당 경로의 파일을 객체화
            fileupload(boardDto,boardEntity);
            // 1. 회원 <---> 게시물 연관관계 대입
            boardEntity.setMemberEntity( memberEntity ); // ***!!!! 5. fk 대입
            memberEntity.getBoardEntityList().add( boardEntity); // *** 양방향 [ pk필드에 fk 연결 ]
            // 2. 카테고리 <---> 게시물 연관관계 대입
            boardEntity.setBcategoryEntity( bcategoryEntity );
            bcategoryEntity.getBoardEntityList().add( boardEntity );
            return true;
        }
        else{ return false; } // 2. 0 이면 entity 생성 실패
    }

    // 2. 게시물 목록 조회
    @Transactional      // bcno : 카테고리번호 , page : 현재 페이지번호 , key : 검색필드명 , keyword : 검색 데이터
    public PageDto boardlist( PageDto pageDto){
        /*Page<BoardEntity> elist = null; // 1. 페이징처리된 엔티티 리스트 객체 선언
        Pageable pageable = PageRequest.of(  // 2.페이징 설정 [ 페이지시작 : 0 부터 ] , 게시물수 , 정렬
                pageDto.getPage()-1 , 3 , Sort.by( Sort.Direction.DESC , "bno")  );*/
        Pageable pageable = PageRequest.of(  pageDto.getPage()-1 , 3 , Sort.by( Sort.Direction.DESC , "bno") );
    /*    // 3. 검색여부 / 카테고리  판단
        if( pageDto.getKey().equals("btitle") ){ // 검색필드가 제목이면
            elist = boardRepository.findbybtitle( pageDto.getBcno() , pageDto.getKeyword() , pageable);
        }else if( pageDto.getKey().equals("bcotent") ){ // 검색필드가 제목이면
            elist = boardRepository.findbybcontent( pageDto.getBcno() , pageDto.getKeyword()  , pageable);
        }else{ // 검색이 없으면 // 카테고리 출력
            if( pageDto.getBcno() == 0  ) elist = boardRepository.findAll( pageable);
            else elist = boardRepository.findBybcno( pageDto.getBcno() , pageable);
        }*/

        /*elist = boardRepository.findbySearch( pageDto.getBcno() , pageDto.getKey() ,pageDto.getKeyword() , pageable);*/
       /* // 프론트엔드에 표시할 페이징번호버튼 수
        int btncount = 5;                               // 1.페이지에 표시할 총 페이지 버튼 개수
        int startbtn = (pageDto.getPage()/btncount) * btncount +1;   // 2. 시작번호 버튼
        int endbtn = startbtn + btncount-1;             // 3. 마지막번호 버튼
        if( endbtn > elist.getTotalPages() ) endbtn =elist.getTotalPages();*/
        Page<BoardEntity>  elist = boardRepository.findbySearch( pageDto.getBcno() , pageDto.getKey() , pageDto.getKeyword() , pageable ); // 3. 검색여부 / 카테고리  판단 [ 통합 ]
        List<BoardDto> dlist = new ArrayList<>(); // 2. 컨트롤에게 전달할때 형변환[ entity->dto ] : 역할이 달라서
        for( BoardEntity entity : elist ){ // 3. 변환
            dlist.add( entity.toDto() );
        }
        pageDto.setList( dlist  );  // 결과 리스트 담기
      /*  pageDto.setStartbtn( startbtn );
        pageDto.setEndbtn( endbtn );*/
        pageDto.setTotalBoards( elist.getTotalElements() );

        return pageDto;
    }
/*
    // 2. 게시물 목록 조회
    @Transactional
    public List<BoardDto> boardlist( int bcno , int page ,String key, String keyword){
        Page<BoardEntity> elist = null; // ♨  자료형  Page

        // pageable import 시 ♨domain 꺼 쓰기
        // PageRequest.of( 현재페이지번호 , 표시할 레코드 수  , 정렬 )
        // [ 정렬 ], Sort.by(Sort.Direction.DESC, "bno")
        // page는 0부터 시작이라 -1 해줌
        Pageable pageable =  PageRequest.of( page-1 , 10 ,Sort.by(Sort.Direction.DESC, "bno") );

        // 3. 검색여부 판단ㄷ
        if(key.equals("btitle")){ // 검색필드가 제목이면
            elist = boardRepository.findbybtitle( bcno , keyword, pageable);
        }else if(key.equals("bcontent")){ // 검색필드가 내용이면
            elist = boardRepository.findbybcontent( bcno , keyword, pageable);
        }else{ // 검색이 없으면
            if(bcno == 0){elist = boardRepository.findAll( pageable ); }
            else         {elist = boardRepository.findBybcno(bcno , pageable);}

        }

        // 1_ 프론트엔드에 표시할 페이징번호 버튼 수
        int btncount = 5; // 페이지에 표시할 총 페이지 버튼 개수
        // 2_ [시작] [끝] 번호 버튼
        int startbtn = (page/btncount) * btncount +1;
        int endbtn = startbtn + btncount -1;
        if(endbtn > elist.getTotalPages()) {endbtn = elist.getTotalPages();}



        *//*if( bcno == 0 ){   elist = boardRepository.findAll( pageable );   } // 카테고리번호가 0 이면 전체보기
        else{  // 카테고리번호가 0이 아니면 선택된 카테고리별 보기
            //[ after 페이징처리 ]
            elist = boardRepository.findBybcno( bcno , pageable );
            //[ before 페이징처리 ]
            //BcategoryEntity bcEntity =  bcategoryRepository.findById( bcno ).get();
            //elist  = bcEntity.getBoardEntityList(); // 해당 엔티티의 게시물목록
        }*//*


        List<BoardDto> dlist = new ArrayList<>(); // 2. 컨트롤에게 전달할때 형변환[ entity->dto ] : 역할이 달라서
        for( BoardEntity entity : elist ){ // 3. 변환
            dlist.add( entity.toDto() );
        }

        dlist.get(0).setStartbtn( startbtn );
        dlist.get(0).setEndbtn( endbtn );


        return dlist;  // 4. 변환된 리스트 dist 반환
    }*/




    // 3. 게시물 개별 조회
    @Transactional
    public BoardDto getboard( int bno ){
        Optional< BoardEntity > optional = boardRepository.findById(bno); // 1. 입력받은 게시물번호로 엔티티 검색 [ Optional]
        if( optional.isPresent() ){// 2. Optional 안에 있는 내용물 확인 .isPresent()
            BoardEntity boardEntity = optional.get(); // 3. 엔티티 꺼내기 .get();
            return boardEntity.toDto(); // 4.형변환 반환
        }else{
            return null; // 4. 없으면 null
        }
    }
    // 4. 게시물 삭제
    @Transactional
    public boolean delboard( int bno ){
        Optional<BoardEntity> optional = boardRepository.findById( bno);
        if( optional.isPresent() ){
            BoardEntity entity =  optional.get();
            boardRepository.delete( entity ); // 찾은 엔티티를 삭제한다.
            return true;
        }else{ return false; }
    }
    // 5. 게시물 수정 [ 첨부파일 ]
    @Transactional
    public boolean upboard( BoardDto boardDto){
        // 1. DTO에서 수정할 PK번호 이용해서 엔티티 찾기
        Optional<BoardEntity> optional = boardRepository.findById( boardDto.getBno() );
        if( optional.isPresent() ){  // 2.
            BoardEntity entity = optional.get();


            // 1) 수정할 첨부파일이 있을 때, --->>> 새로운 첨부파일 업로드, db수정한다.
            //if(boardDto.getBfile() != null){
            if( !boardDto.getBfile().getOriginalFilename().equals("") ){      // boardDto : 수정할정보   boardEntity : 원본[db테이블]
                if(entity.getBfile() != null){  // 기존 첨부파일 있을 때
                    File file = new File( path + entity.getBfile()); // 기존 첨부파일 객체화
                    if(file.exists()){
                        file.delete();
                    }
                    entity.setBfile(null);      // db 처리 // 기존 첨부파일 db 삭제 처리
                }
                fileupload( boardDto, entity);
            }


            // * 수정처리 [ 메소드 별도 존재x /  엔티티 객체 <--매핑--> 레코드 / 엔티티 객체 필드를 수정 : @Transactional ]
            entity.setBtitle( boardDto.getBtitle() );
            entity.setBcontent( boardDto.getBcontent()) ;
            //entity.setBfile( boardDto.getBfile() );
            return true;
        }else{  return false;  }
    }
    // 6. 카테고리 등록
    public boolean setbcategory(  BcategoryDto bcategoryDto ){
        BcategoryEntity entity =  bcategoryRepository.save(  bcategoryDto.toEntity() );
        if( entity.getBcno() != 0 ){ return  true;}
        else{ return false; }
    }
    // 7. 모든 카테고리 출력
    public List<BcategoryDto> bcategorylist(){
        List<BcategoryEntity> entityList =  bcategoryRepository.findAll();
        List<BcategoryDto> dtolist = new ArrayList<>();
        entityList.forEach( e -> dtolist.add( e.toDto() ) );
        return dtolist;
    }
}
/*
        // 1. 리스트를 순회하는 방법 3가지 [
        // 화살표함수[람다식표현] js : ( 인수 )  => { 실행코드 }    java : 인수 -> { 실행코드 }
        for( int i = 0 ; i < entityList.size(); i++ ){
            BcategoryEntity e =  entityList.get(i);
            System.out.println( e.toString() );
        }
        for ( BcategoryEntity e : entityList ){
            System.out.println( e.toString() );
        }
        entityList.forEach( e -> e.toString()  );
 */

/*
        // 1. 리스트를 순회하는 방법 3가지 [
        // 화살표함수[람다식표현] js : ( 인수 )  => { 실행코드 }    java : 인수 -> { 실행코드 }
        for( int i = 0 ; i < entityList.size(); i++ ){
            BcategoryEntity e =  entityList.get(i);
            System.out.println( e.toString() );
        }
        for ( BcategoryEntity e : entityList ){
            System.out.println( e.toString() );
        }
        entityList.forEach( e -> e.toString()  );
 */


// 데이터[파일명]가 중복일때 식별자 만들기
// 1. pk+데이터
// 2. uuid + 데이터 [ UUID (범용 고유 식별자 클래스 : UUID.randomUUID().toString() ]
// 3. 업로드 날짜/시간 + 데이터
// 4. 중복된파일명 중 최근파일명뒤에 데이터 + (중복수+1)



/*
            // 1. MultipartFile 인터페이스
                // .getOriginalFilename() : 해당 인터페이스에 연결(주소)된 파일의 이름 호출
                // .transferTo() : 파일이동[ 사용자pc ---> 개발자 pc ]
                    // .transferTo( 파일객체 )
                    // File : java 외 파일을 객체화 클래스
                        // new File("경로") : 해당 경로의 파일을 객체화
 */




/*
            // 1. Pageable 인터페이스  [ import 사용시 domain 패키지 ]
            // 2. PageRequest 구현클래스
                // 1.PageRequest.of( 현재페이지번호 , 표시할레코드수 )
 */


// *. 검색페이징된
//        System.out.println(" 엔티티들 : " + elist );
//        System.out.println(" 총엔티티수 : " + elist.getTotalElements() );
//        System.out.println(" 총페이지수 : " + elist.getTotalPages() );
//        System.out.println(" 현재페이지수 : " + elist.getNumber() );
//        System.out.println(" 현재엔티티들 객체정보 : " + elist.getContent());
//        System.out.println(" 현재 페이지의 게시물수 : " + elist.getNumberOfElements() );
//        System.out.println(" 현재 페이지가 첫페이지 여부확인 : "+elist.isFirst() );
//        System.out.println(" 현재 페이지가 마지막페이지 여부확인 : "+elist.isLast() );











