package com.Ezenweb.domain.dto;

import lombok.*;

// 롬복 : 생성자, get/set , toString , 필더패턴(안전성)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardDto {
    private String btitle;
    private String bcontent;
}
