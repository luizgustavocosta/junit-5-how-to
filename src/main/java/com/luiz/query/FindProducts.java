package com.luiz.query;

import com.luiz.domain.model.Product;
import com.luiz.domain.model.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Find products.
 */
@Component
public class FindProducts {

    @Autowired
    private final ProductService productService;

    /**
     * Instantiates a new Find products.
     *
     * @param productService the product service
     */
    public FindProducts(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Execute list.
     *
     * @return the list
     */
    public List<Product> execute() {
        return productService.findAll();
    }
}
