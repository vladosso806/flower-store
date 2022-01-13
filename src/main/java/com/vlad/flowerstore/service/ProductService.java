package com.vlad.flowerstore.service;

import com.vlad.flowerstore.constants.ProductTypeConstants;
import com.vlad.flowerstore.model.Product;
import com.vlad.flowerstore.repository.IProductRepository;
import com.vlad.flowerstore.repository.IProductTypeRepository;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private IProductTypeRepository productTypeRepository;
    @Autowired
    private EntityManager entityManager;

    private final String searchTemplate = "select `id` as id, `description` as description, `price` as price," +
            " `stock_availability` as stockAvailability, `title` as title, `product_type_id` as productTypeId," +
            " `image_src` as imageSrc from `flower-store`.`product` " +
            "where lower(description) like '%%%1$s%%' " +
            "or lower(title) like '%%%1$s%%'";

    @Transactional
    public List<Product> getAllBouquets() {
        return productTypeRepository.findByProductTypeName(ProductTypeConstants.BOUQUETS_PRODUCT_TYPE).getProductList();
    }

    @Transactional
    public Product getBouquetById(Long id) {
        return productRepository.getByIdAndProductType(id, productTypeRepository
                .findByProductTypeName(ProductTypeConstants.BOUQUETS_PRODUCT_TYPE));
    }

    @Transactional
    public List<Product> getAllFlowerArrangements() {
        return productTypeRepository.findByProductTypeName(ProductTypeConstants.FLOWER_ARRANGEMENTS_PRODUCT_TYPE).getProductList();
    }

    @Transactional
    public Product getFlowerArrangementById(Long id) {
        return productRepository.getByIdAndProductType(id, productTypeRepository
                .findByProductTypeName(ProductTypeConstants.FLOWER_ARRANGEMENTS_PRODUCT_TYPE));
    }

    @Transactional
    public List<Product> getAllHouseplants() {
        return productTypeRepository.findByProductTypeName(ProductTypeConstants.HOUSEPLANTS_PRODUCT_TYPE).getProductList();
    }

    @Transactional
    public Product getHouseplantById(Long id) {
        return productRepository.getByIdAndProductType(id, productTypeRepository
                .findByProductTypeName(ProductTypeConstants.HOUSEPLANTS_PRODUCT_TYPE));
    }

    @Transactional
    public List<Product> getAllBonsai() {
        return productTypeRepository.findByProductTypeName(ProductTypeConstants.BONSAI_PRODUCT_TYPE).getProductList();
    }

    @Transactional
    public Product getBonsaiById(Long id) {
        return productRepository.getByIdAndProductType(id, productTypeRepository
                .findByProductTypeName(ProductTypeConstants.BONSAI_PRODUCT_TYPE));
    }

    @Transactional
    public List<Product> getAllPots() {
        return productTypeRepository.findByProductTypeName(ProductTypeConstants.POTS_PRODUCT_TYPE).getProductList();
    }

    @Transactional
    public Product getPotById(Long id) {
        return productRepository.getByIdAndProductType(id, productTypeRepository
                .findByProductTypeName(ProductTypeConstants.POTS_PRODUCT_TYPE));
    }

    @Transactional
    public List<Product> getAllFlorariums() {
        return productTypeRepository.findByProductTypeName(ProductTypeConstants.FLORARIUMS_PRODUCT_TYPE).getProductList();
    }

    @Transactional
    public Product getFlorariumById(Long id) {
        return productRepository.getByIdAndProductType(id, productTypeRepository
                .findByProductTypeName(ProductTypeConstants.FLORARIUMS_PRODUCT_TYPE));
    }

    @Transactional
    public List<Product> getAllGiftBaskets() {
        return productTypeRepository.findByProductTypeName(ProductTypeConstants.GIFT_BASKETS_PRODUCT_TYPE).getProductList();
    }

    @Transactional
    public Product getGiftBasketById(Long id) {
        return productRepository.getByIdAndProductType(id, productTypeRepository
                .findByProductTypeName(ProductTypeConstants.GIFT_BASKETS_PRODUCT_TYPE));
    }

    @Transactional
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Product> getByPartialTitleOrDescription(String searchCriteria) {
        Query query = entityManager.createNativeQuery(String.format(searchTemplate, searchCriteria.toLowerCase(Locale.ROOT)));
        return ((List<Object[]>)query.getResultList()).stream().map((Object[] object) -> {
            Product product = new Product();
            product.setId(Long.parseLong(object[0] + ""));
            product.setDescription(object[1] + "");
            product.setPrice((BigDecimal) object[2]);
            product.setStockAvailability(Boolean.parseBoolean(object[3] + ""));
            product.setTitle(object[4] + "");
            product.setProductType(productTypeRepository.getOne(Long.parseLong(object[5] + "")));
            product.setImageSrc(object[6] + "");
            return product;
        }).collect(Collectors.toList());
    }
}
