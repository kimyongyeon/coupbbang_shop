package com.cb.shop.coupbbang_shop.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberDTO {
    private String userId;
    private String userPw;
    private String userName;
    private int age;
    private String addr;
    private String role;
}
