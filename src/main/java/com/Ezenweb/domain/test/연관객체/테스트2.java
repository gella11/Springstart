package com.Ezenweb.domain.test.연관객체;

public class 테스트2 {
    public static void main(String[] args){
        // 1. 제품 객체[pk] 생성
        제품 제품1 = new 제품();
        제품1.제품명 = "모자";

        // 2. 이미지 객체[fk] 생성
        이미지 이미지1 = new 이미지();
        이미지1.이미지명 ="모자쓴패트.jpg";
            // 사진이 두개
        이미지 이미지2 = new 이미지();
        이미지2.이미지명 ="모자쓴패트2.jpg";

        // 3. 단방향
        이미지1.제품 = 제품1;
        이미지2.제품 = 제품1;

        // 4. 양방향
        제품1.이미지리스트.add(이미지1.제품);
        제품1.이미지리스트.add(이미지2.제품);

        System.out.println(제품1.이미지리스트);

    }
}
