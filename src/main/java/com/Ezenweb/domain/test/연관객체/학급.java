package com.Ezenweb.domain.test.연관객체;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class 학급 {
    String 학급명;
    List<학생> 학생리스트 = new ArrayList<>();
}
