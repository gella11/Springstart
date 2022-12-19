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
                // 권한[role] 에 따른 http 접근 제한 두기
                .authorizeHttpRequests() // 1. 인증 http 요청들 [ 인증-로그인된 ] http 조건들
                    .antMatchers("/board/write")
                         .hasRole("MEMBER") // 게시물쓰기는 회원[MEMBER]만 가능
                    .antMatchers("/board/update/**")
                         .hasRole("MEMBER")
                    .antMatchers("/admin/**")
                        .hasRole("ADMIN") // admin 시작하는 경로들은 ADMIN 권한 접근 가능
                    .antMatchers("/**")
                         .permitAll() // 접근 제한 없음 [ 모든 유저가 사용가능 ]

                .and()
                    .exceptionHandling() // 오류페이지에 대한 페이지 매핑
                    .accessDeniedPage("/error") // 해당  URL 이동
                .and()
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
                        .ignoringAntMatchers("/board/setboard") // 게시물 작성
                        .ignoringAntMatchers("/board/boardlist") // 게시물 출력
                        .ignoringAntMatchers("/board/upboard") // 게시물수정 put 사용
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

    권한에 따른 http 제한두기
        http
            .authorizeRequests()        // 인증요청URL들
                .antMatchers("URL").hasRole("권한이름")         // 1. 해당 URL 에 해당 권한명을 가진 인증만 접근 가능
                .antMatchers("URL").authentication()            // 2. 인증된 모든 사용자 접근 가능
                .antMatchers("URL").permitAll()                 // 3. 인증 상관없이 무조건 허용
                .antMatchers("URL").denyAll()                   // 4. 인증 상관없이 무조건 차단
                .antMatchers("URL").hasIpAddress("ip주소")       // 5. 해당 ip만 접근 가능


 */