package com.Ezenweb.controller.test;

import org.springframework.web.bind.annotation.*;

@RestController // @RestController는 @ResponseBody 생략가능
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    // 1. p.76
    @DeleteMapping("/{variable}")
    public String DeleteVariable(@PathVariable("variable") String variable) {
        return variable;
    }

    // 2. p.76
    @DeleteMapping("/request1")
    public String getRequestPraram1 (@RequestParam("variable") String variable) {
        return variable;
    }
}
