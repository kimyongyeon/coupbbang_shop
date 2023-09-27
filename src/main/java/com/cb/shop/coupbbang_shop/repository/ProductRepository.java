package com.cb.shop.coupbbang_shop.repository;

import com.cb.shop.coupbbang_shop.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
