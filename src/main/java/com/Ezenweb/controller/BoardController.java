package com.Ezenweb.controller;

import com.Ezenweb.domain.dto.BoardDto;
import com.Ezenweb.service.BoardService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // 스프링이 MVC를 관리해줌 | 해당 클래스가 컨트롤 목적으로 사용
@RequestMapping("/board") // 해등 클래스 안에 있는 Mapping 들의 공통 url
public class BoardController {

    // ----------------html load url --------------------------
    // 1. 게시물 목록 페이지[HTML] 열기
    @GetMapping("/list") // URL 만들기(정의)
    public Resource list(){
        return new ClassPathResource("templates/board/list.html");
    }
    // 2. 게시물 쓰기 페이지 열기
    @GetMapping("/write")
    public Resource write(){
        // Resource : 자료[ html css js 파일 등 ]
        return new ClassPathResource("templates/board/write.html");
    }
    // -----------------------------------------------------------
    // -----------------------기능 처리 ----------------------------
    // 1. 게시물 쓰기 처리 [ 첨부파일 ]
    @PostMapping("/setboard")
    @ResponseBody // 생략가능
    public boolean setboard(@RequestBody BoardDto boardDto){
        // 1) DTO 내용 확인
        System.out.println(boardDto.toString());
        // 2) >>> 서비스[ 비지니스 로직 ]로 이동
        boolean result = new BoardService().setboard(boardDto);
        // 3) 반환
        return true;
    }
    // 2. 게시물 목록 보기 처리 [ 페이지 || 검색 ]
    @GetMapping("/getboards")
    @ResponseBody // 생략가능
    public ArrayList<BoardDto> getboards(){
        // 1) >>> 서비스[ 비지니스 로직 ]로 이동
        ArrayList<BoardDto> list = new BoardService().getboards();
        // 2) 반환
        return list;
    }
    // 3. 게시물 개별 조회 처리
    // @GetMapping("/getboard")
    // 4. 게시물 수정 처리
    //@PutMapping("/updateboard")
    // 5. 게시물 삭제 처리
    //DeleteMapping("/deleteboard")

}
