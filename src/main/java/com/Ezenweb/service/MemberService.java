package com.Ezenweb.service;

import com.Ezenweb.domain.dto.MemberDto;
import com.Ezenweb.domain.entity.MemberEntity;
import com.Ezenweb.domain.entity.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service // 해당 클래스가 Service 임을 명시
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired // 스프링 컨테이너[ 메모리 ]
    private HttpServletRequest request; // 요청 객체

    // 메일전송 객체 (전역객체)
    @Autowired
    private JavaMailSender javaMailSender; //

    int mno = 0;

    // 1. 회원가입
    @Transactional
    public int setmember(MemberDto memberDto ){
        // 1. DAO 처리 [ dto --> entity
        MemberEntity entity = memberRepository.save( memberDto.toEntity() );
        // memberRepository.save( 엔티티 객체 ) : 해당 엔티티 객체가 insert 생성된 엔티티객체 반환
        // 2. 결과 반환 [ 생성된 엔티티의 pk값 반환 ]
        return entity.getMno();
    }

    // 2. 로그인
    @Transactional
    public int getmember(MemberDto memberDto ){
        // 1. Dao 처리 [ select ]
        // 1. 모든 엔티티=레코드 호출 [ select * from member ]
        List<MemberEntity> entityList = memberRepository.findAll();
        // 2. 입력받은 데이터와 일치값 찾기
        for( MemberEntity entity : entityList ){ // 리스트 반복
            if( entity.getMeamil().equals(memberDto.getMeamil())){ // 엔티티=레코드 의 이메일 과 입력받은 이메일
                if( entity.getMpassword().equals(memberDto.getMpassword())){ // 엔티티=레코드 의 패스워드 와 입력받은 패스워드
                    // 세션 부여 [ 로그인 성공시 'loginMno'이름으로 회원번호 세션 저장  ]
                    request.getSession().setAttribute("loginMno" , entity.getMno() );
                    mno = entity.getMno();
                    return 1;// 로그인 성공했다.
                }else{
                    return 2; // 패스워드 틀림
                }
            }
        }
        return 0; // 아이디가 틀림
    }

    // 3. 비밀번호 찾기
    @Transactional
    public String getpassword(String meamil){
        // 1. 모든 레코드/엔티티 꺼내온다
        List<MemberEntity> entityList =  memberRepository.findAll();
        // 리스트에 찾기
        for(MemberEntity entity : entityList){
            if(entity.getMeamil().equals(meamil)){
                return entity.getMpassword();
            }
        }
        return null;
    }

    // 4. 회원탈퇴
    @Transactional
    public int setdelete( String mpassword ){
        // 1. 로그인된 회원의 엔티티 필요!!
        // 1. 세션 호출
        Object object =  request.getSession().getAttribute("loginMno");
        // 2. 세션 확인
        if( object != null ){ // 만약에 세션이 null 이 아니면 로그인 됨
            int mno = (Integer) object; // 형변환 [ object --> int ]
            // 3. 세션에 있는 회원번호[PK] 로 리포지토리 찾기 [ findById : select * from member where mno = ? ]
            Optional< MemberEntity > optional =  memberRepository.findById(mno);
            if( optional.isPresent() ){ // optional객체내 엔티티 존재 여부 판단
                // Optional 클래스 : null 관련 메소드 제공
                // 4.Optional객체에서 데이터[엔티티] 빼오기
                MemberEntity entity = optional.get();
                // 5. 탈퇴 [ delete : delete from member where mno = ? ]
                memberRepository.delete( entity );
                // 6. 세션 [ 세션삭제 = 로그아웃 ]
                request.getSession().setAttribute("loginMno" , null);
                return 1;
            }
        }
        return 0; // [ 만약에 세션이 null 이면 반환 o 혹은 select 실패시   ]
    }



    // 5. 회원 비밀번호 수정 [ 로그인 가정하에 ]
    @Transactional // 수정시 꼭 사용해야함 // 지금은 비밀번호만 바꾸지만 // 나중에 많은 것을 수정할 때, 일괄처리 // 한 번[commit] 으로 수정을 적용하겠다
    public int setupdate(String mpassword){
        // 1. 세션 호출
        Object object = request.getSession().getAttribute("loginMno");
        // 2. 세션 존재 여부 판단
        if(object != null){
            int mno = (Integer)object;
            // 3. pk값을 가지고 엔티티[레코드 검색]
            Optional<MemberEntity> optional = memberRepository.findById(mno);
            // 4. 검색된 결과 여부 판단
            if(optional.isPresent()){ // 엔티티가 존재하면
                MemberEntity entity = optional.get();
                // 5. 찾은 엔티티의 필드값 변경 [ uddate member set 필드명 = 값 where = 값]
                entity.setMpassword(mpassword);
                return 1;
            }
        }
        return 0;
    }

    public int setindex(){
        if(mno != 0){ return mno;}
        else{return 0;}
    }

    public boolean logout(){
        if(mno != 0){
            request.getSession().setAttribute("loginMno" , null);
            mno = 0;
            return true;
        }else{
            return false;
        }
    }

    // 8. 회원정보 호출
    public List<MemberDto> list(){
        // 1. JPA를 이용한 모든 엔티티 호출
        List<MemberEntity> list =  memberRepository.findAll();
        // 2. 엔티티 --> DTO
        List<MemberDto> dtoList = new ArrayList<>();
        for(MemberEntity entity : list) {
            dtoList.add(entity.toDto());
        }
        return dtoList;
    }

    // 9. 인증코드 발송
    public String getauth(String toemail){
        String auth = ""; // 인증코드
        String html = "<html><body><h1> EZENWEB 회원가입 인증코드여 </h1>";

        Random random = new Random(); // 난수 객체 6번 회줜
        for(int i = 0; i < 6; i++){
            char randchar = (char)(random.nextInt(26)+97);   //97~122 영어 소문자
            // char randchar2 = (char)random.nextInt(10)+48;      //48~57 숫자0~9
            auth += randchar;
        }
        html +="<div>인증코드 : "+auth+"</div>";
        html +="</body></html>";
        meailsend(toemail, "EzenWeb 인증코드", html); // 메일전송
        return auth;
    }
    // 9-2. 메일 전송 서비스
    public void meailsend(String toemail, String title, String content){
        // 외부 통신은 예외처리가 필요
        try {
            // 1. Mine프로토콜 객체 생성
            MimeMessage message = javaMailSender.createMimeMessage();
            // 2. Mime 설정                                             mime객체명   첨부파일 여부     인코딩타입
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true, "UTF-8");
            // 3. 보내는사람 정보
            mimeMessageHelper.setFrom("ajdksgd@naver.com" , "Ezenweb");
            // 4. 받는사람 정보
            mimeMessageHelper.setTo(toemail);
            // 5. 메일 제목
            mimeMessageHelper.setSubject(title);
            // 6. 메일 내용 // HTML 형식
            mimeMessageHelper.setText(content.toString(), true);
            // 7. 메일 전송
            javaMailSender.send(message);
        }catch (Exception e){ System.out.println("메일전송 실패 :" + e); }
    }


    /*
     메일전송
     1) implementation 'org.springframework.boot:spring-boot-starter-mail' 라이브러리 필요
     2) 보내는 사람 이메일 정보[ ]
        네이버 기준 :
            네이버로그인 -> 메일 -> 환경설정
            POP3/IMAP 설정 -> 사용함
            host port 정보 가져오기
    */











}
