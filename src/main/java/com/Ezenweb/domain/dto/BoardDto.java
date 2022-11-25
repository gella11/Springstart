package com.Ezenweb.domain.dto;

import com.Ezenweb.domain.entity.Board.BoardEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

// 롬복 : 생성자, get/set , toString , 필더패턴(안전성)
@NoArgsConstructor  // 깡통 생성자
@AllArgsConstructor // 풀 생성자
@Getter
@Setter
@ToString
@Builder
public class BoardDto {
    private int bno;            // 게시물번호
    private String btitle;      // 게시물제목
    private String bcontent;    // 게시물 내용
    private int bview;          // 조회수
    private MultipartFile bfile;       // 첨부파일 [쓰기용]
    private String bfilename;           // 첨부파일 [호출용]


    private int mno;            // 작성자[회원번호-fk]
    private int bcno;           // 카테고리[ 카테고리-fk ]
    private String memail;      //  회원아이디

    //1. 형변환
    public BoardEntity toEntity(){
        // * 생성자를 이용한 객체 생성 [ *빌더패턴 비교 ]
        return BoardEntity.builder()
                .bno( this.bno )
                .btitle( this.btitle )
                .bcontent( this.bcontent )
                .bview( this.bview )
               // .bfile( this.bfile )
                .build();
    }

}
