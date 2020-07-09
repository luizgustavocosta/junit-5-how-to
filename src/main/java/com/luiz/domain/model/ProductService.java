package com.luiz.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    @Qualifier("nonRelationalDB")
    @Autowired
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product add(String title, BigDecimal price) {
        repository.add(Product.ProductBuilder.aProduct()
                .withTitle(title)
                .withPrice(price)
                .build());
        final List<Product> all = repository.findAll();
        return all.get(all.size()-1);
    }

    public List<Product> findAll() {
        return repository.findAll();
//                Product.ProductBuilder.aProduct()
//                        .withTitle("Test")
//                        .withPrice(BigDecimal.ONE)
//                        .build(),
//                Product.ProductBuilder.aProduct()
//                        .withTitle("XPTO")
//                        .withPrice(BigDecimal.TEN)
//                        .build());
    }
}
