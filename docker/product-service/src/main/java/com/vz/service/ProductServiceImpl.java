package com.vz.service;


import com.vz.exception.ResourceNotFoundException;
import com.vz.model.Product;
import com.vz.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    //@Autowired
    //RabbitTemplate rabbitTemplate;


    @Override
    public List<Product> addProducts(List<Product> products) {
        //sendInventoryDataToQueue(products);
        return productRepository.saveAll(products);
    }

    /*private void sendInventoryDataToQueue(List<Product> products) {
        CompletableFuture.completedFuture(products).thenAcceptAsync(productList -> {
            productList.forEach(prd -> {
                rabbitTemplate.convertAndSend("PRODUCT-INVENTORY", prd);
            });
        });
    }
*/

    @Override
    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(long productId) {

        Optional<Product> productDb = this.productRepository.findById(productId);
        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + productId);
        }
    }


}
