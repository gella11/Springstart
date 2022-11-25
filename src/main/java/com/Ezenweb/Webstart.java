package com.Ezenweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
// 스프링 웹 위한 기본 설정 어노테이션

public class Webstart {
    public static void main(String[] args){
        SpringApplication.run(Webstart.class);

            // 스프링 어플리케잉션 실행[현재클래스명.class ]
    }
}
/*
* 1. extend : 상속 [설계도 물려받는다. 1개만 가능]
* 2. @어노테이션 [빌드[실행]할 때 자동 코드 실행 / 여러개 가능]
*   1) 내장 : @override : 상속 메소드 재정의 할 때
*   2) 메타 :
* */