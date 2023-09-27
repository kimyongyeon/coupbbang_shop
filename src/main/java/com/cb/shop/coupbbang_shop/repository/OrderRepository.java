package com.cb.shop.coupbbang_shop.repository;

import com.cb.shop.coupbbang_shop.domain.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
