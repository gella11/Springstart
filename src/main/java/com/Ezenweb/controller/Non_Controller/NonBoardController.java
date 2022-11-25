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

    // 방명록 등록
    /*@PostMapping("/vadd")
    public boolean vadd(@RequestBody NBoardDto nBoardDto){
        return nboardService.vadd(nBoardDto);
    }*/

    // 방명록 등록 [ 첨부파일
    @PostMapping("/vadd")
    public boolean vadd( NBoardDto nBoardDto){
        return nboardService.vadd(nBoardDto);
    }

    // 첨부파일 다운로드
     @GetMapping("/filedownload")
     public boolean filedownload(@RequestParam("vfilename") String vfilename){
        System.out.println("오긴오냐??");
         System.out.println("오긴오냐??"+vfilename);
         boolean result = nboardService.filedownload(vfilename);
         return result;
     }

    // 방명록 출력
    @GetMapping("/vlist")
    public List<NBoardDto> vlist(@RequestParam int vcno){
        return nboardService.vlist(vcno);
    }

    // 내용 수정
    @PutMapping("/vupdate")
    public boolean vupdate(@RequestBody NBoardDto nBoardDto){
        return nboardService.vupdate(nBoardDto);
    }

    // 방명록 삭제
    @DeleteMapping("/vdelete")
    public boolean vdelete( @RequestParam int vno ){
        return nboardService.vdelete( vno );
    }




}
