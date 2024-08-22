package com.example.springstudy.service;

import com.example.springstudy.annotation.LogExecutionTime;
import com.example.springstudy.entity.Member;
import com.example.springstudy.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @LogExecutionTime
    public List<Member> findAllMember() {
        List<Member> memberList = memberRepository.findAll();

        return memberList;
    }

    @LogExecutionTime
    public Member findMember(Long id) {
        Optional<Member> optional = memberRepository.findById(id);

        return optional.get();
    }
}
