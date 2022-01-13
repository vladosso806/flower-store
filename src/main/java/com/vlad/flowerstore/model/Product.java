package com.vlad.flowerstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @Column
    @GeneratedValue(strategy = IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String title;

    @Column(length = 10000)
    @Getter
    @Setter
    @Lob
    private String description;

    @Column(name = "stock_availability")
    @Getter
    @Setter
    private Boolean stockAvailability;

    @Column
    @Getter
    @Setter
    private BigDecimal price;

    @Column(name = "image_src")
    @Getter
    @Setter
    private String imageSrc;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    @Setter
    private ProductType productType;

    public String getProductType() {
        return productType.getProductTypeName();
    }
}
