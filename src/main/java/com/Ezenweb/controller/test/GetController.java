package com.Ezenweb.controller.test;

import com.Ezenweb.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    // 요청시 해당 클래스 접근[호출/요청] : http://localhost:8080/api/v1/get-api
    // 해당 클래스내 메소드 호출 :         http://localhost:8080/api/v1/get-api/hello
    // p.57
    @RequestMapping(value = "/hello" , method = RequestMethod.GET)
    public String getHello(){ // 함수명[ 아무거나 하되 중복은 피하기 ]
        return "hello World"; // response 응답
    }

    // p.58
    @GetMapping("/name") // http://localhost:8080/api/v1/get-api/name
    public String getName(){
        return "Flaure";
    }

    // p.59
    // 주의 : @GetMapping 경로상의 변수명[{variable} 과
    //       @PathVariable 매개변수[ variable ]
    @GetMapping("/variable1/{variable}") // http://localhost:8080/api/v1/get-api/variable1
    public String getVariable(@PathVariable String variable){
        return variable;
    }

    // 4. p.60
    @GetMapping("/variable2/{variable}") //http://localhost:8080/api/v1/get-api/variable2
    public String getVariable2(@PathVariable(value = "variable") String test ){
        return test;
    }

    // @PathVariable vs @RequestParam
    // @PathVariable vs @RequestParam
    // @PathVariable vs @RequestParam
    // 변수 1개이면        여러개면
    // 4.-2 p.60
    @GetMapping("/variable3") // http://localhost:8080/api/v1/get-api/variable3?variable=하하하
    public String getVariable3(@RequestParam String variable ){
        return variable;
    }



    // 5. p.61
    @GetMapping("/request1")    // http://localhost:8080/api/v1/get-api/request1?name=qwe&email=qwe@qwe&organization=qweqweqwe
    public String getRequestPraram1(
            @RequestParam String name, @RequestParam String email, @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    // 6. p.62
    @GetMapping("/request2")    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    public String getRequestPraram2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map->{
            sb.append(map.getKey() + " : " + map.getValue() +"\n");
        });
        return sb.toString();
    }

    // 7 .p66
    @GetMapping("/request3")    // http://localhost:8080/api/v1/get-api/request3?name=qwe&email=qwe@qwe&organization=qweqweqwe
    public String getRequestPraram3(MemberDto memberDto){
        return memberDto.toString();
    }



}
