package com.Ezenweb.domain.test.연관객체;

import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
@ToString
public class 제품 {
    @Id
    String 제품명;

    @OneToMany()
    @ToString.Exclude
    ArrayList<제품> 이미지리스트 = new ArrayList<>();

}
