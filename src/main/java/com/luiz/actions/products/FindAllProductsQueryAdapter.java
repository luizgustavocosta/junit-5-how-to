package com.luiz.actions.products;

import com.luiz.domain.model.FindAllProductsQuery;
import com.luiz.domain.model.Product;
import com.luiz.domain.model.ProductService;
import com.luiz.infrastructure.query.Query;
import com.luiz.infrastructure.query.QueryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Find all products query a provider a.
 */
@Component
@Query
public class FindAllProductsQueryAdapter implements QueryAdapter<List<Product>, FindAllProductsQuery> {

    @Autowired
    private final ProductService service;

    /**
     * Instantiates a new Find all products query a provider a.
     *
     * @param service the service
     */
    public FindAllProductsQueryAdapter(ProductService service) {
        this.service = service;
    }

    @Override
    public List<Product> execute(FindAllProductsQuery command) {
        return service.findAll();
    }
}
