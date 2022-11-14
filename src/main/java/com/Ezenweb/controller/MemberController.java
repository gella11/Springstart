package com.Ezenweb.controller;

import com.Ezenweb.domain.dto.MemberDto;
import com.Ezenweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 클래스가 controller 임을 명시 [스프링이 알아야함]
public class MemberController {
    @Autowired // 제어역전 [DI] 스프링 컨테이너 위임 || 스프링 컨테이너 빈생성[외부에 메모리 위임]
    private MemberService memberService;

    @GetMapping("/setmember")
    public boolean setmember(){
        // 1. 테스트 dto
        MemberDto memberDto = MemberDto.builder().memail("qwe@qwe.com")
                                                .mpassword("qweqwe")
                                                .build();
        memberService.setmember(memberDto);
        return true;
    }
}
