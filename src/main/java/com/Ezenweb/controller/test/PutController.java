package com.Ezenweb.controller.test;


import com.Ezenweb.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// p.70
@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    // 1. p70
    @PutMapping("member")
    public String putMember(@RequestBody Map<String , String> putData){
        return putData.toString();
    }

    // 2-1. p71     반환타입 : 문자열 [String]
    @PutMapping("/member1")
    public String postMemberDto (@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

    // 2-2. p72     반환타입 : DTO [ MemberDto ]
    @PutMapping("/member2")
    public MemberDto postMemberDto2 (@RequestBody MemberDto memberDto){
        return memberDto;
    }
}
