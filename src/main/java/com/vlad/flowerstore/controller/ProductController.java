package com.vlad.flowerstore.controller;

import com.vlad.flowerstore.jsonmodel.ProductDataJson;
import com.vlad.flowerstore.model.Product;
import com.vlad.flowerstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @Transactional
    @GetMapping(value = {"bouquets/{bouquetId}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ProductDataJson bouquetById(@PathVariable Long bouquetId) {
        Product bouquet = productService.getBouquetById(bouquetId);
        return new ProductDataJson(bouquet, true);
    }

    @Transactional
    @GetMapping(value = {"bouquets"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<ProductDataJson> bouquets() {
        return productService.getAllBouquets()
                .stream()
                .map(product -> new ProductDataJson(product, false))
                .collect(Collectors.toList());
    }

    @Transactional
    @GetMapping(value = {"flower-arrangements/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ProductDataJson flowerArrangementById(@PathVariable Long id) {
        Product product = productService.getFlowerArrangementById(id);
        return new ProductDataJson(product, true);
    }

    @Transactional
    @GetMapping(value = {"flower-arrangements"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<ProductDataJson> flowerArrangements() {
        return productService.getAllFlowerArrangements()
                .stream()
                .map(product -> new ProductDataJson(product, false))
                .collect(Collectors.toList());
    }

    @Transactional
    @GetMapping(value = {"houseplants/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ProductDataJson housePlantById(@PathVariable Long id) {
        Product product = productService.getHouseplantById(id);
        return new ProductDataJson(product, true);
    }

    @Transactional
    @GetMapping(value = {"houseplants"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<ProductDataJson> houseplants() {
        return productService.getAllHouseplants()
                .stream()
                .map(product -> new ProductDataJson(product, false))
                .collect(Collectors.toList());
    }

    @Transactional
    @GetMapping(value = {"bonsai/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ProductDataJson bonsaiById(@PathVariable Long id) {
        Product product = productService.getBonsaiById(id);
        return new ProductDataJson(product, true);
    }

    @Transactional
    @GetMapping(value = {"bonsai"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<ProductDataJson> bonsai() {
        return productService.getAllBonsai()
                .stream()
                .map(product -> new ProductDataJson(product, false))
                .collect(Collectors.toList());
    }

    @Transactional
    @GetMapping(value = {"pots/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ProductDataJson potById(@PathVariable Long id) {
        Product product = productService.getPotById(id);
        return new ProductDataJson(product, true);
    }

    @Transactional
    @GetMapping(value = {"pots"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<ProductDataJson> pots() {
        return productService.getAllPots()
                .stream()
                .map(product -> new ProductDataJson(product, false))
                .collect(Collectors.toList());
    }

    @Transactional
    @GetMapping(value = {"florariums/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ProductDataJson florariumById(@PathVariable Long id) {
        Product product = productService.getFlorariumById(id);
        return new ProductDataJson(product, true);
    }

    @Transactional
    @GetMapping(value = {"florariums"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<ProductDataJson> florariums() {
        return productService.getAllFlorariums()
                .stream()
                .map(product -> new ProductDataJson(product, false))
                .collect(Collectors.toList());
    }

    @Transactional
    @GetMapping(value = {"gift-baskets/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ProductDataJson giftBasketById(@PathVariable Long id) {
        Product product = productService.getGiftBasketById(id);
        return new ProductDataJson(product, true);
    }

    @Transactional
    @GetMapping(value = {"gift-baskets"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    List<ProductDataJson> giftBaskets() {
        return productService.getAllGiftBaskets()
                .stream()
                .map(product -> new ProductDataJson(product, false))
                .collect(Collectors.toList());
    }

    @Transactional
    @GetMapping(value = {"products/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ProductDataJson productById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return new ProductDataJson(product, true);
    }

    @Transactional
    @PostMapping(value = {"search"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ProductDataJson> searchByPartialTitleOrDetails(@RequestBody Map<String, String> searchCriteria) {
        List<Product> products = productService.getByPartialTitleOrDescription(searchCriteria.get("data"));
        return products.stream().map(product -> new ProductDataJson(product, false)).collect(Collectors.toList());
    }
}
