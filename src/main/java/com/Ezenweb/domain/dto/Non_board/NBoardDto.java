package com.Ezenweb.domain.dto.Non_board;

import com.Ezenweb.domain.entity.Non_board.NboardEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;

@NoArgsConstructor  // 깡통 생성자
@AllArgsConstructor // 풀 생성자
@Getter
@Setter
@ToString
@Builder
public class NBoardDto {

    private int vno;            // 방명록 번호
    private String vcontent;    // 방명록 내용
    private String vname;       // 방명록 작성자
    private int vcno;           // 카테고리[ 카테고리-fk ]
    private MultipartFile vfile;
    private String vfilename;

    // 1. 형변환
    public NboardEntity toEntity() {
        return NboardEntity.builder()
                .vno(this.vno)
                .vcontent(this.vcontent)
                .vname(this.vname)
                .build();
    }

}
