package com.cb.shop.coupbbang_shop.domain.service.product;

import com.cb.shop.coupbbang_shop.domain.dto.ProductDTO;
import com.cb.shop.coupbbang_shop.domain.entity.ProductEntity;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class ProductServiceTest {
    @Autowired
    ProductService productService;

    @BeforeEach
    void setUp() {
        ProductDTO productDTO = ProductDTO.builder().name("구찌").stock(1000).price(100).regWriter("admin").upWriter("admin").build();
        productService.registerProduct(productDTO);
    }

    @Test
    @DisplayName("상품 등록 테스트")
    void _01_registerProduct() {
        productService.getProducts().forEach(productEntity -> {
            System.out.println(productEntity.getName());
            Assertions.assertEquals(productEntity.getName(), "23123");
        });
    }

    @Test
    @DisplayName("상품 조회 테스트")
    void _02_getProduct() {
        ProductEntity product = productService.getProduct(1L);
        Assertions.assertEquals(product.getName(), "구찌");
    }

    @Test
    @DisplayName("상품 수정 테스트")
    void _03_updateProduct() {
        ProductDTO productDTO = ProductDTO.builder().id(1L).name("샤넬").stock(1000).price(100).regWriter("admin").upWriter("admin").build();
        productService.updateProduct(productDTO);
        ProductEntity product = productService.getProduct(1L);
        Assertions.assertEquals(product.getName(), "구찌");
    }
}