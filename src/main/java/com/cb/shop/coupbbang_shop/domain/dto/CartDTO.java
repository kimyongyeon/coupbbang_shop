package com.cb.shop.coupbbang_shop.domain.dto;

import com.cb.shop.coupbbang_shop.domain.entity.MemberEntity;
import com.cb.shop.coupbbang_shop.domain.entity.ProductEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class CartDTO {
    private Long id;
    private ProductEntity productEntity;
    private MemberEntity memberEntity;
    private int stock;
}
