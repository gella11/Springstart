package com.Ezenweb.service;

import com.Ezenweb.domain.dto.BoardDto;
import com.Ezenweb.domain.entity.BoardEntity;
import com.Ezenweb.domain.entity.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service // 컴포넌트 [ Stpring MVC ]
public class BoardService {
    // ▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶ 1. 전역변수 ------------------

    @Autowired
    private BoardRepository boardRepository;

    // ▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶ 2. 서 비 스  --------
    @Transactional
    public boolean setboard(BoardDto boardDto){
        BoardEntity entity = boardRepository.save( boardDto.toEntity() );
        if(entity.getMno() !=0){return true;}
        else                   {return false;}
    }
    @Transactional
    public List<BoardDto> boardlist(){
      // 모든 엔티티 호출
      List<BoardEntity> elist = boardRepository.findAll();
      // 컨트롤에게 전달할 때 형변환 entity >>> dto
        List<BoardDto> dlist = new ArrayList<>();
        for(BoardEntity entity : elist){
            dlist.add(entity.toDto());
        }
        return dlist;
    }
    // 3. 게시물 개별 조회 서비스
    @Transactional
    public BoardDto getboard(  int bno ){
        // 1. 입력받은 bno 로 검색.
        // optional 로 한 번 감쌈.                   ♨ null 값 피하려고. optional.isPresent()로 null 거를 수 있으므로. 가져온 게 null인지 아님을 알 수 있는 유일 함수
        Optional<BoardEntity> optional = boardRepository.findById(bno);
        // optional 안에 있는 내용물 확인
        if(optional.isPresent()) {
            BoardEntity board = optional.get(); // ♨ optional로 한 번 감쌌으니 한 번 뜯어야 함.
            return board.toDto();               // ♨ 형변환. optional.get().toDto() 쌉가능
        }else{
            return null;
        }
    }
    // 4. 게시물 삭제 서비스
    @Transactional
    public boolean delboard(  int bno ){
        Optional<BoardEntity> optional = boardRepository.findById(bno);
        if( optional.isPresent() ) {
            BoardEntity entity = optional.get();
            boardRepository.delete(entity);
            return true;
        }else{ return false; }
    }

    // 5. 게시물 수정 [ 첨부파일 ]
    @Transactional
    public boolean upboard(  BoardDto boardDto ){
        // 1. DTO에서 수정할 PK번호 이용해서 엔티티 찾기
        Optional<BoardEntity> optional = boardRepository.findById(boardDto.getBno());
        if( optional.isPresent() ){
            BoardEntity entity = optional.get();
            // 수정처리 [ 메소드 별도 존재 x 엔티티 객체 <-- 매핑 --> 리코드/ 엔티티 객체 필드를 수정
            entity.setBtitle(boardDto.getBtitle() );
            entity.setBcontent(boardDto.getBcontent() );
            entity.setBfile(boardDto.getBfile() );
            return true;
        }else{
            return  false;
        }
    }










    /* //@Autowired
    // BoardDao boarddao = new BoardDao(); 이런 거 자동 선언

    // 1. 게시물 등록 서비스
    public boolean setboard(BoardDto boardDto){
        return new BoardDao().setboard(boardDto);
    }
    // 2. 게시물 목록 서비스
    public ArrayList<BoardDto> getboards(){
        return new BoardDao().getboards();
    }*/
}












