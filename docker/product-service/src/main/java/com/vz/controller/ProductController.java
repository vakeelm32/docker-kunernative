package com.vz.controller;


import com.vz.model.Product;
import com.vz.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@RestController
public class ProductController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String home() {
        logger.info("******************Welcome message ***************************");
        return "Welcome : " + (new Date());
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        logger.info("******************query for all products ***************************");
        return productService.getAllProduct();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable long id) {
        logger.info("**************************product id : {} **************************", id);
        Product productById = productService.getProductById(id);
        if (productById == null) {
            throw new RuntimeException(("id-" + id));
        }
        return productById;
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        logger.info("*********************adding product list {} **********************", products);
        return productService.addProducts(products);
    }


    @RequestMapping("/clearCache")
    public String clearCache() {
        logger.info("clearing Cache ");
        return "Cleared cache";
    }
}
