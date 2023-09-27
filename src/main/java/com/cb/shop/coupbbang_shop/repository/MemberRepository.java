package com.cb.shop.coupbbang_shop.repository;

import com.cb.shop.coupbbang_shop.domain.entity.MemberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByUserIdAndPassword(String userId, String password);

    Page<MemberEntity> findAll(Pageable pageable);
}
