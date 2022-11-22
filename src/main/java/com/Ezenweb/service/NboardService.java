package com.Ezenweb.service;

import com.Ezenweb.domain.dto.BoardDto;
import com.Ezenweb.domain.dto.Non_board.NBcategoryDto;
import com.Ezenweb.domain.dto.Non_board.NBoardDto;
import com.Ezenweb.domain.entity.Board.BoardEntity;
import com.Ezenweb.domain.entity.Non_board.NBcategoryEntity;
import com.Ezenweb.domain.entity.Non_board.NBcategoryRepository;
import com.Ezenweb.domain.entity.Non_board.NBoardRepository;
import com.Ezenweb.domain.entity.Non_board.NboardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NboardService {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private NBcategoryRepository nBcategoryRepository;
    @Autowired
    private NBoardRepository nBoardRepository;


    // 1. 카테고리 등록
    @Transactional
    public boolean cadd(NBcategoryDto nBcategoryDto){
        NBcategoryEntity entity = nBcategoryRepository.save( nBcategoryDto.toEntity() );
        if( entity.getVcno() != 0 ){ return  true;}
        else{ return false; }
    }

    // 2. 카테고리 출력
    public List<NBcategoryDto> clist(){
        List<NBcategoryEntity> entityList = nBcategoryRepository.findAll();
        List<NBcategoryDto> dtolist = new ArrayList<>();
        entityList.forEach( e -> dtolist.add( e. toDto()  ) );
        return dtolist;
    }

    // 3. 방명록 등록
    @Transactional
    public boolean vadd( NBoardDto nBoardDto){
        Optional<NBcategoryEntity> optional = nBcategoryRepository.findById( nBoardDto.getVcno() );
            System.out.println("getVcno():::"+nBoardDto.getVcno());
            System.out.println("optional:::"+optional);
        if ( !optional.isPresent()) { return false;}
        NBcategoryEntity nBcategoryEntity = optional.get();
            System.out.println("nBcategoryEntity:::"+nBcategoryEntity);

        NboardEntity nboardEntity = nBoardRepository.save( nBoardDto.toEntity());
            System.out.println("nboardEntity:::"+nboardEntity);
            System.out.println("nboardEntity.getVno():::"+nboardEntity.getVno() );
        if( nboardEntity.getVno() != 0){
            nboardEntity.setNBcategoryEntity( nBcategoryEntity);
            nBcategoryEntity.getNboardEntityList().add( nboardEntity);
            return true;
        }

        else{ return false;}
    }


    // 4. 방명록 출력
    public List<NBoardDto> vlist( int vcno){
        List<NboardEntity> elist = null;
        if( vcno == 0){ elist = nBoardRepository.findAll(); }
        else{
            NBcategoryEntity cEntity = nBcategoryRepository.findById(vcno).get();
            elist = cEntity.getNboardEntityList();
        }
        List<NBoardDto> dlist = new ArrayList<>();
        for( NboardEntity entity : elist){
            dlist.add(entity.toDto());
        }
        return dlist;
    }

    // 5. 게시글 수정
    @Transactional
    public boolean vupdate( NBoardDto nBoardDto){
        // 1. DTO에서 수정할 PK번호 이용해서 엔티티 찾기
        Optional<NboardEntity> optional = nBoardRepository.findById( nBoardDto.getVno() );
        if( optional.isPresent() ){  // 2.
            NboardEntity entity = optional.get();
            // * 수정처리 [ 메소드 별도 존재x /  엔티티 객체 <--매핑--> 레코드 / 엔티티 객체 필드를 수정 : @Transactional ]
            entity.setVcontent(nBoardDto.getVcontent());
            entity.setVname( nBoardDto.getVname()); ;
            return true;
        }else{  return false;  }
    }

    // 4. 게시물 삭제
    @Transactional
    public boolean vdelete( int vno ){
        Optional<NboardEntity> optional = nBoardRepository.findById( vno);
        if( optional.isPresent() ){
            NboardEntity entity =  optional.get();
            nBoardRepository.delete( entity ); // 찾은 엔티티를 삭제한다.
            return true;
        }else{ return false; }
    }

}
