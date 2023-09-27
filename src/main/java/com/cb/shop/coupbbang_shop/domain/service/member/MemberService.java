package com.cb.shop.coupbbang_shop.domain.service.member;

import com.cb.shop.coupbbang_shop.domain.dto.MemberDTO;
import com.cb.shop.coupbbang_shop.domain.entity.MemberEntity;
import com.cb.shop.coupbbang_shop.domain.entity.MemberRoleEntity;
import com.cb.shop.coupbbang_shop.domain.entity.RoleEntity;
import com.cb.shop.coupbbang_shop.repository.MemberRepository;
import com.cb.shop.coupbbang_shop.repository.MemberRoleRepository;
import com.cb.shop.coupbbang_shop.repository.RoleRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface MemberService {

    void registerMember(MemberDTO memberDTO);

    String isLogin(MemberDTO memberDTO);

    List<MemberDTO> pagingMember(int page, int size);

    @Service
    @RequiredArgsConstructor
    class MemberServiceImpl implements MemberService {

        private final MemberRepository memberRepository;

        private final RoleRepository roleRepository;

        private final MemberRoleRepository memberRoleRepository;

        @PostConstruct
        void init() {
            RoleEntity roleUser = RoleEntity.createRoleEntity("ROLE_USER");
            roleRepository.save(roleUser);
            RoleEntity roleAdmin = RoleEntity.createRoleEntity("ROLE_ADMIN");
            roleRepository.save(roleAdmin);
            RoleEntity roleGuest = RoleEntity.createRoleEntity("ROLE_GUEST");
            roleRepository.save(roleGuest);
            RoleEntity roleManager = RoleEntity.createRoleEntity("ROLE_MANAGER");
            roleRepository.save(roleManager);
        }


        @Override
        public void registerMember(MemberDTO memberDTO) {
            MemberEntity member = MemberEntity.createMember(memberDTO);
            memberRepository.save(member);

            RoleEntity role = roleRepository.findByRoleName("ROLE_USER").orElseThrow();

            MemberRoleEntity memberRole = MemberRoleEntity.builder()
                    .memberEntity(member)
                    .roleEntity(role)
                    .build();

            memberRoleRepository.save(memberRole);

        }

        private String generateToken(String username) {
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + 3600000)) // 1 hour
                    .signWith(SignatureAlgorithm.HS256, "secret")
                    .compact();
        }

        @Override
        public String isLogin(MemberDTO memberDTO) {
            if (memberRepository.findByUserIdAndPassword(memberDTO.getUserId(), memberDTO.getUserPw()).isPresent()) {
                return generateToken(memberDTO.getUserId());
            }
            return "";
        }

        @Override
        public List<MemberDTO> pagingMember(int page, int size) {
            List<MemberDTO> memberDTOList = new ArrayList<>();
            for (MemberEntity memberEntity : memberRepository.findAll(PageRequest.of(page, size))) {
                MemberDTO m = MemberDTO.builder()
                        .userId(memberEntity.getUserId())
                        .userPw(memberEntity.getPassword())
                        .userName(memberEntity.getUserName())
                        .age(memberEntity.getAge())
                        .addr(memberEntity.getAddr()).build();
                memberDTOList.add(m);
            }
            return memberDTOList;
        }
    }
}
