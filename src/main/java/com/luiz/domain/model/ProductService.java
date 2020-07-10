package com.luiz.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * The type Product service.
 */
@Service
public class ProductService {

    @Qualifier("nonRelationalDB")
    @Autowired
    private final ProductRepository repository;

    /**
     * Instantiates a new Product service.
     *
     * @param repository the repository
     */
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * Add product.
     *
     * @param title the title
     * @param price the price
     * @return the product
     */
    public Product add(String title, BigDecimal price) {
        repository.add(Product.ProductBuilder.aProduct()
                .withTitle(title)
                .withPrice(price)
                .build());
        final List<Product> products = repository.findAll();
        return products.get(products.size()-1);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Product> findAll() {
        return repository.findAll();
    }
}
