package com.luiz.domain.model;

import java.util.List;

/**
 * The interface Product repository.
 */
public interface ProductRepository {

    /**
     * Add.
     *
     * @param product the product
     */
    void add(Product product);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Product> findAll();
}
