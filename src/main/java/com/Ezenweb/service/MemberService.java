package com.Ezenweb.service;

import com.Ezenweb.domain.dto.MemberDto;
import com.Ezenweb.domain.entity.MemberEntity;
import com.Ezenweb.domain.entity.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service // 해당 클래스가 Service 임을 명시
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Transactional // 트랜잭션 ||
    public boolean setmember(MemberDto memberDto){
       memberRepository.save(memberDto.toEntity());
       // memberRepository.save(엔티티): 해당 엔티티 insert find[select]
        return true;
    }

}
