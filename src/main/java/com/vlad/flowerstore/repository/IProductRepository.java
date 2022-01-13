package com.vlad.flowerstore.repository;

import com.vlad.flowerstore.model.Product;
import com.vlad.flowerstore.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Transactional(timeout = 10)
    List<Product> findAll();

    @Transactional(timeout = 10)
    List<Product> findAllByProductType(ProductType productType);

    @Transactional(timeout = 10)
    Product getByIdAndProductType(Long id, ProductType productType);
}
