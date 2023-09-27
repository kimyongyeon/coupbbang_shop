package com.cb.shop.coupbbang_shop.domain.entity;

import com.cb.shop.coupbbang_shop.domain.dto.CartDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class CartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stock;

    @OneToOne
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

    protected CartEntity() {}

    public static CartEntity createCartEntity(CartDTO cartDTO) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.stock = cartDTO.getStock();
        cartEntity.memberEntity = cartDTO.getMemberEntity();
        cartEntity.productEntity = cartDTO.getProductEntity();
        return cartEntity;
    }




}
