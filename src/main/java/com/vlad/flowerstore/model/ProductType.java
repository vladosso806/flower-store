package com.vlad.flowerstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "product_type")
public class ProductType {

    @Id
    @Column
    @GeneratedValue(strategy = IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(name = "product_type_name", unique = true)
    @Getter
    @Setter
    private String productTypeName;


    @Getter
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productType", cascade = CascadeType.ALL)
    private List<Product> productList;

}
