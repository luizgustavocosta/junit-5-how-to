package com.luiz.infrastructure.repositories;

import com.luiz.domain.model.Product;
import com.luiz.domain.model.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("nonRelationalDB")
public class NonRelationalDB implements ProductRepository {

    private List<Product> products = new ArrayList<>();

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}
