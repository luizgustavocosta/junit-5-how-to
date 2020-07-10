package com.luiz.infrastructure.repositories;

import com.luiz.domain.model.Product;
import com.luiz.domain.model.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
@Qualifier("relationDB")
public class RelationalDB implements ProductRepository {

    @Override
    public void add(Product product) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Product> findAll() {
        throw new UnsupportedOperationException();
    }
}
