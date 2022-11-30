package com.Ezenweb.domain.entity.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // 해당 인터페이스가 리포지토리임을 명시
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
                                //extends JpaRepository<매핑할 클래스명, @ID필드의 자료형>

    // * finrBy필드명() 필드검색
    // 1. 이메일 이용한 엔티티 검색 메소드

    Optional<MemberEntity> findByMemail(String email);


}
