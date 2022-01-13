package com.vlad.flowerstore.repository;

import com.vlad.flowerstore.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IProductTypeRepository extends JpaRepository<ProductType, Long> {
    @Transactional(timeout = 10)
    ProductType findByProductTypeName(String productTypeName);
}
