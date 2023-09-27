package com.cb.shop.coupbbang_shop.domain.entity;

import com.cb.shop.coupbbang_shop.domain.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String userId;

    private String password;

    private String addr;

    private String userName;

    private int age;

    @OneToMany(mappedBy = "memberEntity")
    @ToString.Exclude
    private List<MemberRoleEntity> memberRoles = new ArrayList<>();

    protected MemberEntity() {}

    public static MemberEntity createMember(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.userId = memberDTO.getUserId();
        memberEntity.password = memberDTO.getUserPw();
        memberEntity.addr = memberDTO.getAddr();
        memberEntity.userName = memberDTO.getUserName();
        memberEntity.age = memberDTO.getAge();
        return memberEntity;
    }
}
