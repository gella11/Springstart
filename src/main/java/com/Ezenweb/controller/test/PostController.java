package com.Ezenweb.controller.test;

import com.Ezenweb.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    // 1. p.68
    @RequestMapping(value = "/domain" , method = RequestMethod.POST)
    public String postExample(){return "Hello Post API";}

    // 2. p.69
    @PostMapping("/member")
    public String postMember(@RequestBody Map<String , String> postData){
        return postData.toString();
    }

    // 3. p.69
    @PostMapping("/member2")
    public String postMember2(@RequestBody MemberDto memberDto){
        return memberDto.toString();
}
}
