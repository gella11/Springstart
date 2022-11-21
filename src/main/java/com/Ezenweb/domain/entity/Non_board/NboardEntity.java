package com.Ezenweb.domain.entity.Non_board;


import com.Ezenweb.domain.dto.Non_board.NBoardDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="nonboard")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class NboardEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int vno;
    @Column(nullable = false)
    private String vcontent;
    @Column(nullable = false)
    private String vname;
    @Column(nullable = false)
    private int vcno;

    @ManyToOne
    @JoinColumn(name="vcno",insertable = false,
            updatable = false)
    @ToString.Exclude
    private NBcategoryEntity nBcategoryEntity;

    public NBoardDto toDto(){
        return NBoardDto.builder()
                .vno(this.vno)
                .vcno(this.vcno)
                .vcontent(this.vcontent)
                .vname(this.vname)
                .build();
    }

}
