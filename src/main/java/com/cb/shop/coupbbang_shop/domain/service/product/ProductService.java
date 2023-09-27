package com.cb.shop.coupbbang_shop.domain.service.product;

import com.cb.shop.coupbbang_shop.domain.dto.ProductDTO;
import com.cb.shop.coupbbang_shop.domain.entity.ProductEntity;
import com.cb.shop.coupbbang_shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    void registerProduct(ProductDTO productDTO);
    ProductEntity getProduct(Long id);

    List<ProductEntity> getProducts();

    void updateProduct(ProductDTO productDTO);

    @Service
    @RequiredArgsConstructor
    class ProductServiceImpl implements ProductService {

        final private ProductRepository productRepository;

        @Override
        public void registerProduct(ProductDTO productDTO) {
            ProductEntity product = ProductEntity.createProduct(productDTO);
            productRepository.save(product);
        }

        @Override
        public ProductEntity getProduct(Long id) {
            return productRepository.findById(id).orElseThrow();
        }

        @Override
        public List<ProductEntity> getProducts() {
            return productRepository.findAll();
        }

        @Override
        public void updateProduct(ProductDTO productDTO) {
            ProductEntity product = productRepository.findById(productDTO.getId()).orElseThrow();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setStock(productDTO.getStock());
            product.setUpWriter(productDTO.getUpWriter());
            productRepository.save(product);
        }
    }
}
