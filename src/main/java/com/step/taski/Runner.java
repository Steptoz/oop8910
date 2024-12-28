package com.step.taski;

import com.step.taski.entity.ProductEntity;
import com.step.taski.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final ProductService productService;


    @Override
    public void run(String[] args) {
        ProductEntity newProduct = productService.addNewProduct("Простоквашино", "Молоко");
        System.out.println("Добавлена новый продукт с ID: " + newProduct.getProduct_id());

        productService.updateProduct(UUID.fromString("24605f52-7b20-4470-b286-7023a473dc2c"), "Домик в деревне", "Молоко");
        System.out.println("обновили продукт");

        productService.delProductById(UUID.fromString("60b924ee-03a5-4aa3-86df-b3197ce68e32"));
        System.out.println("Удалили продукт");
    }
}