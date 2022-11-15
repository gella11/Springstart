package com.Ezenweb.domain.dto;

import com.Ezenweb.domain.entity.MemberEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto {
    private int mno;
    private String meamil;
    private String mpassword;

    // *dto ---> entity 변환
    public MemberEntity toEntity(){
        return MemberEntity.builder().mno(this.mno)
                                    .meamil(this.meamil)
                                    .mpassword(this.mpassword)
                                    .build();

    }

}
