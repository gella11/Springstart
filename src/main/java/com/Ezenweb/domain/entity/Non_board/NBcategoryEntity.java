package com.Ezenweb.domain.entity.Non_board;

import com.Ezenweb.domain.dto.Non_board.NBcategoryDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="noncategory")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NBcategoryEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int vcno;       // 비회원 카테고리 번호
    private String vname;   // 비회원 카테고리 이름

    @OneToMany( mappedBy = "nBcategoryEntity")
    @Builder.Default
    private List<NboardEntity> nboardEntityList = new ArrayList<>();

    public NBcategoryDto toDto(){
        return NBcategoryDto.builder()
                .vcno(this.vcno)
                .vname(this.vname)
                .build();
    }



}
