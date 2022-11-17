package com.Ezenweb.domain.entity;




import com.Ezenweb.domain.dto.BoardDto;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name="board")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardEntity {
    // 1. 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    @Column(nullable = false)
    private String btitle;

    @Column(nullable = false , columnDefinition = "TEXT")
    private String bcontent;

    @Column(nullable = false)
    private int mno;            // fk

    @Column(nullable = false)
    private int cno;            // fk 카테고리 번호

    // 작성일 수정일 --> 상속 (여러 엔티티해서 사용되는 필드라서 )

    @Column(nullable = false)
    @ColumnDefault("0")
    private int bview;

    @Column(nullable = false)
    private String bfile;       // 첨부파일

    // 1. 형변환
    public BoardDto toDto(){
        // 빌더 패턴을 이용한 객체생성
        return BoardDto.builder()
                            .bno(this.bno)
                            .btitle(this.btitle)
                            .bcontent(this.bcontent)
                            .bview(this.bview)
                            .bfile(this.bfile)
                            .mno(this.mno)
                            .cno(this.cno)
                        .build();
    }
    
}


