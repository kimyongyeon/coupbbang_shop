package com.cb.shop.coupbbang_shop.domain.service.cart;

import com.cb.shop.coupbbang_shop.domain.dto.CartDTO;
import com.cb.shop.coupbbang_shop.domain.entity.CartEntity;
import com.cb.shop.coupbbang_shop.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface CartService {
    void registerCart(CartDTO cartDTO);
    @Service
    @RequiredArgsConstructor
    class CartServiceImpl implements CartService {

        final private CartRepository cartRepository;

        @Override
        public void registerCart(CartDTO cartDTO) {
            CartEntity cartEntity = CartEntity.createCartEntity(cartDTO);
            cartRepository.save(cartEntity);
        }
    }
}
