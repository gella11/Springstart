package com.Ezenweb.controller.Non_Controller;

import com.Ezenweb.domain.dto.Non_board.NBcategoryDto;
import com.Ezenweb.domain.dto.Non_board.NBoardDto;
import com.Ezenweb.service.NboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nonboard")
public class NonBoardController {

    // ▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶ 페이지 전환

    @GetMapping("/index")
    public Resource getindex(){
        return new ClassPathResource("templates/Nonboard/Non_index.html");
    }


    // ▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶ 전역

    @Autowired
    private NboardService nboardService;


    // ▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶ 서비스

    // 카테고리 등록
    @PostMapping("/cadd")
    public boolean cadd(@RequestBody NBcategoryDto nBcategoryDto){
        return nboardService.cadd(nBcategoryDto);
    }
    
    // 카테고리 출력
    @GetMapping("/clist")
    public List<NBcategoryDto> clist(){
        return nboardService.clist();
    }

    // 1) index
    // 2) 카테고리 등록
    // 3) 방문록 전체출력
    // 4) 삭제 / 수정


    // 방명록 등록
    @PostMapping("/vadd")
    public boolean vadd(@RequestBody NBoardDto nBoardDto){
        return nboardService.vadd(nBoardDto);
    }

}
