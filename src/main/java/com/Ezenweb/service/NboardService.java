package com.Ezenweb.service;

import com.Ezenweb.domain.dto.Non_board.NBcategoryDto;
import com.Ezenweb.domain.dto.Non_board.NBoardDto;
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
    public boolean vadd(@RequestBody NBoardDto nBoardDto){
        NboardEntity entity = nBoardRepository.save( nBoardDto.toEntity() );
        if( entity.getVno() != 0 ){ return  true;}
        else{ return false; }
    }


}
