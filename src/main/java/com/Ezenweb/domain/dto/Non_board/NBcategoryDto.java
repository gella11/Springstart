package com.Ezenweb.domain.dto.Non_board;

import com.Ezenweb.domain.entity.Non_board.NBcategoryEntity;
import lombok.*;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NBcategoryDto {

    private int vcno;       // 비회원 카테고리 번호
    private String vname;    // 비회원 카테고리 이름

    public NBcategoryEntity toEntity(){
        return NBcategoryEntity.builder()
                .vcno(this.vcno)
                .vname(this.vname)
                .build();

    }
}
