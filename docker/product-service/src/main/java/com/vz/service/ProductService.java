package com.vz.service;


import com.vz.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> addProducts(List<Product> product);

    List<Product> getAllProduct();

    Product getProductById(long productId);

}
