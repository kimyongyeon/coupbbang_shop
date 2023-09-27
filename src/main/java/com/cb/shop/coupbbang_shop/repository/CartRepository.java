package com.cb.shop.coupbbang_shop.repository;

import com.cb.shop.coupbbang_shop.domain.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
}
