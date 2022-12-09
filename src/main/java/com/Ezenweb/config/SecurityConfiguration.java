package com.Ezenweb.config;

import com.Ezenweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private MemberService memberService;
    @Override // 인증(로그인) 관련 메소드 재정의
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder( new BCryptPasswordEncoder() );
        //
    }

    @Override // 재정의 [ 상속받은 클래스로부터 메소드 재구현 ]
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()                                // 로그인 페이지 보안 설정
                    .loginPage("/member/login")                 // 아이디와 비밀번호를 입력받을 url
                    .loginProcessingUrl("/member/getmember")    // 로그인 처리할 url [ 컨트롤 안가고 서비스로 감 ]
                    .defaultSuccessUrl("/")                     // 로그인 성공시 페이지 전환
                    .failureUrl("/member/login") // 로그인 실패시 페이지 전환
                    .usernameParameter("memail")                    // 이름 DTO
                    .passwordParameter("mpassword")                 // 비밀번호 DTO
                .and()
                    .logout()
                        .logoutRequestMatcher( new AntPathRequestMatcher("/member/logout") )
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)    // 세션초기화 [ principal초기화 ]
                .and()                                              // 기능 구분
                    .csrf()                                         // 요청 위조
                        .ignoringAntMatchers("/member/getmember") // 해당 url은 csrf무시  [ post 가능해짐] [ 오류 403]
                        .ignoringAntMatchers("/member/setmember") // 회원가입 페이지 기능 가능
                        .ignoringAntMatchers("/board/setbcategory")
                        .ignoringAntMatchers("/board/setboard")
                .and()
                        .oauth2Login()              // 소셜 로그인 보안 설정
                        .defaultSuccessUrl("/")     // 소셜 로그인 성공시 이동하는 URL
                        .userInfoEndpoint()         // 종착점 [ 소셜 회원정보를 받는 곳]
                        .userService(memberService); // 해덩 서비스에서 Endpoint를 memberService로 잡는다. // loadUser 메소드 구현해야함
    }
}

/*
시큐리티 기본값
    1. 해당 프로젝트의 모든 url 잠긴다.
    2. login html 제공
    3. login controller 제공
    4. login service 제공

    -> 커스텀 작업
    SecurityConfiguration :        시큐리티 설정 클래스 [이름 아무거나 가능. 상속이 중요함]
    WebSecurityConfigurerAdapter : 웹시큐리티 설정 클래스

    설정 종류
        1) url 권한 [마우스 오른쪽 클릭, generate , http override]
        @Override // 재정의 [ 상속받은 클래스로부터 메소드 재구현 ]
        protected void configure(HttpSecurity http) throws Exception {}



 */