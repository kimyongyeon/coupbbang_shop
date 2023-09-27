package com.cb.shop.coupbbang_shop.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;

    private String roleName;

    @OneToMany(mappedBy = "roleEntity")
    @ToString.Exclude
    @Builder.Default
    private List<MemberRoleEntity> memberRoles = new ArrayList<>();

    public static RoleEntity createRoleEntity(String roleName) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.roleName = roleName;
        return roleEntity;
    }
}