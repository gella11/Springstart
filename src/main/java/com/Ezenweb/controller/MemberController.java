package com.Ezenweb.controller;

import com.Ezenweb.domain.dto.MemberDto;
import com.Ezenweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController // 해당 클래스가 controller 임을 명시 [스프링이 알아야함]
@RequestMapping("/member") // 클래스 위에 넣으면 공통URL
public class MemberController {

    // 주의 : 1. 매핑주소 중복불가능 // 2. 함수명 중복 불가능
    
    
    //----------------------------------------------------------------
    // 전역 객체
    @Autowired // 제어역전 [DI] 스프링 컨테이너 위임 || 스프링 컨테이너 빈생성[외부에 메모리 위임]
    private MemberService memberService;

    
    //----------------------------------------------------------------
    // html 반환 매핑
    // 회원가입
    @GetMapping("/signup")
    public Resource getsignup(){
        return new ClassPathResource("templates/member/signup.html"); // 프로젝트내 resource > template>member>signup.html 반환
    }

    @PostMapping("/setmember") // restful api
    public int setmember( @RequestBody MemberDto memberDto  ){
        int result = memberService.setmember( memberDto ); // 1. 서비스[ 비지니스 로직 ] 호출
        return result;  // 2. 반환
    }

    //----------------------------------------------------------------
    
    // html 반환 매핑
    // 로그인
    @GetMapping("/login")
    public Resource getlogin(){
        return new ClassPathResource("templates/member/login.html"); // 프로젝트내 resource > template>member>signup.html 반환
    }
    @PostMapping("/getmember") // restful api
    public int getmember(@RequestBody MemberDto memberDto ){
        int result = memberService.getmember(memberDto);
        return result;
    }






    //----------------------------------------------------------------
    // html 반환 매핑
    // 비밀번호 찾기 (이메일 입력시 비밀번호 보내줌)
    @GetMapping("/findpassword")
    public Resource findpassword() {
        return new ClassPathResource("templates/member/findpassword.html");
    }
    @GetMapping("/getpassword")
    public String getpassword(@RequestParam("meamil") String meamil){
        String result = memberService.getpassword(meamil);
        return result;

    }

    //----------------------------------------------------------------

    // 회원삭제
    @GetMapping("/delete")
    public Resource getdelete(){
        return new ClassPathResource("templates/member/delete.html");
    }
    @DeleteMapping("/setdelete")
    public int setdelete(@RequestParam("mpassword") String mpassword){
        // 1. 서비스 처리
        int result = memberService.setdelete(mpassword);
        // 2. 서비스 결과 반환
        return result;
    }
    //----------------------------------------------------------------


    // 비밀번호 수정
    @GetMapping("/update")
    public Resource getupdate(){
        return new ClassPathResource("templates/member/update.html");
    }

    @PutMapping ("/setupdate")
    public int setupdate(@RequestParam("mpassword") String mpassword){
        int result = memberService.setupdate(mpassword);
        return result;
    }
    //----------------------------------------------------------------
    @GetMapping("/index")
    public Resource getindex(){
        return new ClassPathResource("templates/index.html");
    }
    @GetMapping ("/setindex")
    public int setindex(){
        int result = memberService.setindex();
        return result;
    }
    @GetMapping ("/logout")
    public boolean logout(){
        boolean result = memberService.logout();
        return result;

    }


}
