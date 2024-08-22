package com.example.springstudy.controller;

import com.example.springstudy.annotation.LogExecutionTime;
import com.example.springstudy.entity.Member;
import com.example.springstudy.service.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @LogExecutionTime  // Log Aspect로 사용할 함수에 적용하기 위해 생성해준 애노테이션
    @GetMapping("/all")
    public String getMemberList() {
        List<Member> member = memberService.findAllMember();
        return "ok";
    }

    @LogExecutionTime
    @GetMapping("/{id}")
    public Member getMemberList(@PathVariable("id") Long id) {
        Member member = memberService.findMember(id);
        return member;
    }
}
