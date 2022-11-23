package com.Ezenweb.service;

import com.Ezenweb.domain.dto.BoardDto;
import com.Ezenweb.domain.dto.Non_board.NBcategoryDto;
import com.Ezenweb.domain.dto.Non_board.NBoardDto;
import com.Ezenweb.domain.entity.Board.BoardEntity;
import com.Ezenweb.domain.entity.Non_board.NBcategoryEntity;
import com.Ezenweb.domain.entity.Non_board.NBcategoryRepository;
import com.Ezenweb.domain.entity.Non_board.NBoardRepository;
import com.Ezenweb.domain.entity.Non_board.NboardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NboardService {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private NBcategoryRepository nBcategoryRepository;
    @Autowired
    private NBoardRepository nBoardRepository;
    @Autowired
    private NboardEntity nBoardEntity;

    String path = "C:\\Users\\504\\Desktop\\spring\\Springstart\\src\\main\\resources\\static\\nbupload";


    // 1. 카테고리 등록
    @Transactional
    public boolean cadd(NBcategoryDto nBcategoryDto){
        NBcategoryEntity entity = nBcategoryRepository.save( nBcategoryDto.toEntity() );
        if( entity.getVcno() != 0 ){ return  true;}
        else{ return false; }
    }

    // 2. 카테고리 출력
    public List<NBcategoryDto> clist(){
        List<NBcategoryEntity> entityList = nBcategoryRepository.findAll();
        List<NBcategoryDto> dtolist = new ArrayList<>();
        entityList.forEach( e -> dtolist.add( e. toDto()  ) );
        return dtolist;
    }

    // 3. 방명록 등록
    /*@Transactional
    public boolean vadd( NBoardDto nBoardDto){
        Optional<NBcategoryEntity> optional = nBcategoryRepository.findById( nBoardDto.getVcno() );
            System.out.println("getVcno():::"+nBoardDto.getVcno());
            System.out.println("optional:::"+optional);
        if ( !optional.isPresent()) { return false;}
        NBcategoryEntity nBcategoryEntity = optional.get();
            System.out.println("nBcategoryEntity:::"+nBcategoryEntity);

        NboardEntity nboardEntity = nBoardRepository.save( nBoardDto.toEntity());
            System.out.println("nboardEntity:::"+nboardEntity);
            System.out.println("nboardEntity.getVno():::"+nboardEntity.getVno() );
        if( nboardEntity.getVno() != 0){
            nboardEntity.setNBcategoryEntity( nBcategoryEntity);
            nBcategoryEntity.getNboardEntityList().add( nboardEntity);
            return true;
        }
        else{ return false;}
    }*/

    // 3. 방명록 등록 [ 첨부파일 등록]
    @Transactional
    public boolean vadd( NBoardDto nBoardDto){
        Optional<NBcategoryEntity> optional = nBcategoryRepository.findById( nBoardDto.getVcno() );
        System.out.println("getVcno():::"+nBoardDto.getVcno());
        System.out.println("optional:::"+optional);
        if ( !optional.isPresent()) { return false;}
        NBcategoryEntity nBcategoryEntity = optional.get();
        System.out.println("nBcategoryEntity:::"+nBcategoryEntity);

        NboardEntity nboardEntity = nBoardRepository.save( nBoardDto.toEntity());
        if( nboardEntity.getVno() != 0){

            String filename = nBoardDto.getVfile().getOriginalFilename();
            String uuid = UUID.randomUUID().toString();                       // 난수 생성
            filename += uuid+"-"+ nBoardDto.getVfile().getOriginalFilename(); // 난수 + 파일명
            nboardEntity.setVfile(filename);

            try{
                nBoardDto.getVfile().transferTo(new File(path + filename));
            }
            catch( Exception e){System.out.println("비회원 게시판 첨부파일 포함 글쓰기 오류 :" + e);}

            nboardEntity.setNBcategoryEntity( nBcategoryEntity);
            nBcategoryEntity.getNboardEntityList().add( nboardEntity);
            return true;
        }
        else{ return false;}
    }

    // 첨부파일 다운로드
    public void filedownload(int vno){
        NboardEntity entity = nBoardRepository.findById(vno).get();
        String vfile = entity.getVfile();

        String realfile = vfile.split("_")[1];
        String filepath = path+vfile;
        try{
            response.setHeader(
                    "Content-Disposition",
                    "attachment; filename="+ URLEncoder.encode(realfile, "UTF-8")
            );

            File file  = new File(filepath);

            BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = new byte[(int)file.length()];
            fin.read(bytes);
            BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
            fout.write(bytes);
            fout.flush(); fout.flush(); fin.close();
        }
        catch ( Exception e){System.out.println("다운로드 오류"+e);}
    }


    // 4. 방명록 출력
    public List<NBoardDto> vlist( int vcno){
        List<NboardEntity> elist = null;
        if( vcno == 0){ elist = nBoardRepository.findAll(); }
        else{
            NBcategoryEntity cEntity = nBcategoryRepository.findById(vcno).get();
            elist = cEntity.getNboardEntityList();
        }
        List<NBoardDto> dlist = new ArrayList<>();
        for( NboardEntity entity : elist){
            dlist.add(entity.toDto());
        }
        return dlist;
    }

    // 5. 게시글 수정
    @Transactional
    public boolean vupdate( NBoardDto nBoardDto){
        // 1. DTO에서 수정할 PK번호 이용해서 엔티티 찾기
        Optional<NboardEntity> optional = nBoardRepository.findById( nBoardDto.getVno() );
        if( optional.isPresent() ){  // 2.
            NboardEntity entity = optional.get();
            // * 수정처리 [ 메소드 별도 존재x /  엔티티 객체 <--매핑--> 레코드 / 엔티티 객체 필드를 수정 : @Transactional ]
            entity.setVcontent(nBoardDto.getVcontent());
            entity.setVname( nBoardDto.getVname()); ;
            return true;
        }else{  return false;  }
    }

    // 4. 게시물 삭제
    @Transactional
    public boolean vdelete( int vno ){
        Optional<NboardEntity> optional = nBoardRepository.findById( vno);
        if( optional.isPresent() ){
            NboardEntity entity =  optional.get();
            nBoardRepository.delete( entity ); // 찾은 엔티티를 삭제한다.
            return true;
        }else{ return false; }
    }

}
