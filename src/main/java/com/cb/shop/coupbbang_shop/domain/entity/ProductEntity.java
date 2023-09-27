package com.cb.shop.coupbbang_shop.domain.entity;

import com.cb.shop.coupbbang_shop.domain.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    private String name;

    private int price;

    private int stock;

    private LocalDateTime regDate;

    private LocalDateTime upDate;

    @PrePersist
    protected void onCreate() {
        regDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        upDate = LocalDateTime.now();
    }

    private String regWriter;

    private String upWriter;

    protected ProductEntity() {}

    public static ProductEntity createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.name = productDTO.getName();
        productEntity.price = productDTO.getPrice();
        productEntity.stock = productDTO.getStock();
        productEntity.regWriter = productDTO.getRegWriter();
        productEntity.upWriter = productDTO.getUpWriter();
        return productEntity;
    }

}
