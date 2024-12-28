package com.step.taski.service;

import com.step.taski.entity.ProductEntity;
import com.step.taski.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;



    @Transactional
    public ProductEntity updateProduct(UUID product_id, String product_brand, String description){
        Optional<ProductEntity> productOpt = productRepository.findById(product_id);

        ProductEntity product = productOpt.orElse(null);

        product.setProduct_brand(product_brand);
        product.setDescription(description);

        return productRepository.save(product);
    }


    @Transactional
    public ProductEntity addNewProduct(String product_brand, String description){
        ProductEntity product = new ProductEntity();
        product.setProduct_id(UUID.randomUUID());
        product.setProduct_brand(product_brand);
        product.setDescription(description);

        return productRepository.save(product);
    }

    @Transactional
    public void delProductById(UUID product_id){

        productRepository.deleteById(product_id);
    }

}