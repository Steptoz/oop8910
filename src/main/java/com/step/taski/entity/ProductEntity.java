package com.step.taski.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "task1")
@Accessors(chain = true)
public class ProductEntity {

    @Id
    @Column(nullable = false, unique = true, name = "product_id")
    private UUID product_id;

    @Column(nullable = true, name = "product_brand")
    private String product_brand;

    @Column(nullable = true, name = "description")
    private String description;
}