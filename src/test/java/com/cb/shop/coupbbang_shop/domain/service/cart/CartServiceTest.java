package com.cb.shop.coupbbang_shop.domain.service.cart;

import com.cb.shop.coupbbang_shop.domain.dto.CartDTO;
import com.cb.shop.coupbbang_shop.domain.dto.MemberDTO;
import com.cb.shop.coupbbang_shop.domain.dto.ProductDTO;
import com.cb.shop.coupbbang_shop.domain.entity.CartEntity;
import com.cb.shop.coupbbang_shop.domain.entity.MemberEntity;
import com.cb.shop.coupbbang_shop.domain.entity.ProductEntity;
import com.cb.shop.coupbbang_shop.repository.CartRepository;
import com.cb.shop.coupbbang_shop.repository.MemberRepository;
import com.cb.shop.coupbbang_shop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartServiceTest {

    @Autowired
    CartService cartService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;

    @BeforeEach
    void setUp() {
        MemberDTO m = MemberDTO.builder().userName("admin").userPw("admin").userId("admin").age(10).addr("서울").build();
        MemberEntity member = MemberEntity.createMember(m);
        memberRepository.save(member);
        ProductDTO p = ProductDTO.builder().name("구찌").stock(1000).price(100).regWriter("admin").upWriter("admin").build();
        ProductEntity product = ProductEntity.createProduct(p);
        productRepository.save(product);
    }

    @Test
    void registerCart() {
        MemberEntity memberEntity = memberRepository.findById(1L).orElseThrow();
        ProductEntity productEntity = productRepository.findById(1L).orElseThrow();
        CartDTO cartDTO = CartDTO.builder().memberEntity(memberEntity).productEntity(productEntity).stock(100).build();
        cartService.registerCart(cartDTO);

        CartEntity cartEntity = cartRepository.findById(1L).orElseThrow();
        assertEquals(cartEntity.getMemberEntity().getUserName(), "admin");

    }
}