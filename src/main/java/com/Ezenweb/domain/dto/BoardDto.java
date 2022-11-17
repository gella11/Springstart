package com.Ezenweb.domain.dto;

import com.Ezenweb.domain.entity.BoardEntity;
import lombok.*;

// 롬복 : 생성자, get/set , toString , 필더패턴(안전성)
@NoArgsConstructor  // 깡통 생성자
@AllArgsConstructor // 풀 생성자
@Getter
@Setter
@ToString
@Builder
public class BoardDto {
    private int bno;
    private String btitle;
    private String bcontent;
    private int mno;            // fk
    private int cno;            // fk 카테고리 번호
    private int bview;
    private String bfile;       // 첨부파일

    // 1. 형변환
    public BoardEntity toEntity() {
        // 생성자를 이용한 객체 생성
        // 순서 있음.
        return new BoardEntity(
                this.bno,
                this.btitle,
                this.bcontent,
                this.mno,
                this.cno,
                this.bview,
                this.bfile
        );
    }

}
