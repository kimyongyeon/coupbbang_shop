package com.cb.shop.coupbbang_shop.domain.service.member;

import com.cb.shop.coupbbang_shop.domain.dto.MemberDTO;
import com.cb.shop.coupbbang_shop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        memberRepository.deleteAll();

        for (int i = 0; i < 100; i++) {
            MemberDTO member = MemberDTO.builder()
                    .userId("kkkk" + i)
                    .age(13)
                    .addr("노량진").userPw("1234").userName("김민수").build();
            memberService.registerMember(member);
        }
    }

    @Test
    @DisplayName("회원가입 테스트")
    void registerMember() {
        MemberDTO member = MemberDTO.builder()
                .userId("kkkk")
                .age(13)
                .addr("노량진").userPw("1234").userName("김민수").build();
        memberService.registerMember(member);

        memberRepository.findAll().forEach(memberEntity -> {
            System.out.println(memberEntity.getUserId());
        });
    }

    @Test
    @DisplayName("로그인 테스트")
    void isLogin() {
        MemberDTO member = MemberDTO.builder()
                .userId("kkkk")
                .age(13)
                .addr("노량진").userPw("1234").userName("김민수").build();
        memberService.registerMember(member);

//        member.setUserPw("111");
        String login = memberService.isLogin(member);

        // login 값이 공백이면 실패
        Assertions.assertNotEquals("", login);
    }

    @Test
    @DisplayName("페이징 테스트")
    void pagingMember() {
        memberService.pagingMember(1, 10).forEach(memberDTO -> {
            System.out.println(memberDTO.getUserId());
        });
        System.out.println("====================================");
        memberService.pagingMember(2, 10).forEach(memberDTO -> {
            System.out.println(memberDTO.getUserId());
        });
        System.out.println("====================================");
        memberService.pagingMember(3, 10).forEach(memberDTO -> {
            System.out.println(memberDTO.getUserId());
        });
    }
}