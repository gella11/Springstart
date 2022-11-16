package com.Ezenweb.domain.entity;
import com.Ezenweb.domain.dto.MemberDto;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // 해당 연결된 DB의 테이블과 매핑[연결]
@Table(name="member") // DB에서 사용될 테이블 이름

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberEntity {
    // 1. 필드
    @Id // 엔티티당 무조건 1개 이상[PK]
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동번호 부여 auto increment 기능
    @Column(name = "id", updatable = false, nullable = false)
    private int mno;
    @Column(nullable = false)   // not null
    private String meamil;      // 회원이메일 = 회원아이디 필드
    @Column(nullable = false)  // not null
    private String mpassword;  // 회원비밀번호 필드
    @Column(nullable = false)  // not null
    private String mphone;     // 회원 전화번호 필드

    //private LocalDateTime mcreate; // 가입일
    //private LocalDateTime mupdate; // 회원정보 수정일
    // 2. 생성자 [ 롬복으로 사용 ]
    // 3. 메소드 [ 롬복으로 사용 ]

    // 엔티티 ---> DTO
    public MemberDto toDto(){
        return MemberDto.builder()
                        .mno(this.mno)
                        .meamil(this.meamil)
                        .mpassword(this.mpassword)
                        .mphone(this.mphone)
                        .build();
    }
}
