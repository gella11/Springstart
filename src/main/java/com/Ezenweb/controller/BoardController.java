package com.Ezenweb.controller;

import com.Ezenweb.domain.dto.BcategoryDto;
import com.Ezenweb.domain.dto.BoardDto;
import com.Ezenweb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // 스프링이 MVC를 관리해줌 | 해당 클래스가 컨트롤 목적으로 사용
@RequestMapping("/board") // 해등 클래스 안에 있는 Mapping 들의 공통 url
public class BoardController {



    // ▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶ 1. 전역변수 ------------------
    // ↓ 개발자가 new 연산자 사용해서 JVM에 메모리 할당해서 객체 생성        ■ 메모리관리를 내가 하냐
    // private BoardService boardService = new BoardService();

    // 컨트롤 역할 : HTTP 요청 / ModelAndView 응답

    // ------------1.전역변수---------------//
    // 1. 서비스 메소드 호출 위한 객체 생성
    // 1. 개발자가 new 연산자 사용해서 JVM 힙 메모리 할당해서 객체 생성
    // private BoardService boardService = new BoardService();
    // 2. @Autowired 어노테이션 이용해서 Spring 컨테이너에 빈[메모리] 생성
    @Autowired
    private BoardService boardService= new BoardService();

    // ------------2.페이지[html] 요청 로드 [view]---------------//
    // 1. 게시물목록 페이지 열기
    @GetMapping("/list") // URL  : localhost:8080/board/list 요청시 해당 html 반환
    public Resource getlist(){ return new ClassPathResource("templates/board/list.html"); }
    // 2. 게시물쓰기 페이지 열기
    @GetMapping("/write")// URL  : localhost:8080/board/write 요청시 해당 html 반환
    public Resource getwrite(){ return new ClassPathResource("templates/board/write.html"); }
    // 3. 게시물조회 페이지 열기
    @GetMapping("/view")// URL  : localhost:8080/board/view 요청시 html 해당 html 반환
    public Resource getview(){ return new ClassPathResource("templates/board/view.html"); }
    // 4. 게시물수정 페이지 열기
    @GetMapping("/update")// URL  : localhost:8080/board/update 요청시 해당 html 반환
    public Resource getupdate(){ return new ClassPathResource("templates/board/update.html"); }

    // ----------- 3.요청과응답 처리 [model] --------------//
    // 1. HTTP 요청 메소드 매핑 : @PostMapping @GetMapping @DeleteMapping @PutMapping
    // 2. HTTP 데이터 요청 메소드 매핑 : @RequestBody @RequestParam @PathVariable
    // 1. 게시물 쓰기 [ 첨부파일 ♨]
    @PostMapping("/setboard")
    public boolean setboard(  BoardDto boardDto ){
        System.out.println("확인 ♨" + boardDto.toString() );
        return boardService.setboard( boardDto);
    }
    //  1. 게시물 쓰기 [ 첨부파일  x ]
    // @PostMapping("/setboard")
    // public boolean setboard( @RequestBody BoardDto boardDto ){
    //    System.out.println("확인" + boardDto.toString() );
    //    return boardService.setboard( boardDto);
    // }

    // 2. 게시물 목록 조회 [ 페이징,검색 ]
    @GetMapping("/boardlist")
    public List<BoardDto> boardlist( @RequestParam("bcno") int bcno ){
        return boardService.boardlist( bcno );
    }
    // 3. 게시물 개별 조회
    @GetMapping("/getboard")
    public BoardDto getboard( @RequestParam("bno") int bno ){
        return boardService.getboard( bno );
    }
    // 4. 게시물 삭제
    @DeleteMapping("/delboard")
    public boolean delboard( @RequestParam("bno") int bno ){
        return boardService.delboard( bno );
    }
    // 5. 게시물 수정 [ 첨부파일 ]
    @PutMapping("/upboard")
    public boolean upboard( @RequestBody BoardDto boardDto){
        return boardService.upboard( boardDto );
    }

    // 6. 카테고리 등록
    @PostMapping("/setbcategory")
    public boolean setbcategory( @RequestBody BcategoryDto bcategoryDto ){
        return boardService.setbcategory(bcategoryDto);
    }
    // 7. 모든 카테고리 출력
    @GetMapping("/bcategorylist")
    public List<BcategoryDto> bcategorylist(){
        return boardService.bcategorylist();
    }

    // 8. 첨부파일 다운로드
    @GetMapping("/filedownload")
    public void filedownload(@RequestParam("filename") String filename){
        boardService.filedownload(filename);
    }

















    /*// ----------------html load url --------------------------
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
    }*/
    // 3. 게시물 개별 조회 처리
    // @GetMapping("/getboard")
    // 4. 게시물 수정 처리
    //@PutMapping("/updateboard")
    // 5. 게시물 삭제 처리
    //DeleteMapping("/deleteboard")

}
