package com.Ezenweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override // 재정의 [ 상속받은 클래스로부터 메소드 재구현 ]
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http); //모든 http url 보안 설정 ( 주소창 보안이 풀림 )
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