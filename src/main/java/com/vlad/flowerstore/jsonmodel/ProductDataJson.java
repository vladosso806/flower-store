package com.vlad.flowerstore.jsonmodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vlad.flowerstore.model.Product;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDataJson {

    private Long id;
    private String title;
    private String description;
    private String imageSrc;
    private BigDecimal price;
    private Boolean stockAvailability;
    private String productType;

    public ProductDataJson(Product product, boolean fullVersion) {
        id = product.getId();
        title = product.getTitle();
        imageSrc = product.getImageSrc();
        price = product.getPrice();
        stockAvailability = product.getStockAvailability();
        productType = product.getProductType();
        if (fullVersion) {
            description = product.getDescription();
        }
    }
}
