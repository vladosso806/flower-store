package com.vlad.flowerstore.controller;

import com.vlad.flowerstore.model.Product;
import com.vlad.flowerstore.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

    @Autowired
    private IProductRepository flowerRepository;

    @GetMapping(value = "/obema")
    @ResponseBody
    public String main() {
        List<Product> flowerList = flowerRepository.findAll();
        return "sasatb";
    }
}
