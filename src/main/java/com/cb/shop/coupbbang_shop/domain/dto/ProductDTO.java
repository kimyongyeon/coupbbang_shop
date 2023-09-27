package com.cb.shop.coupbbang_shop.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private int price;
    private int stock;
    private String regWriter;
    private String upWriter;
}
