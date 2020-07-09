package com.luiz.actions.products;

import com.luiz.actions.client.cli.ProductRequest;
import com.luiz.command.AddProductCommand;
import com.luiz.domain.model.Product;
import com.luiz.domain.model.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AddProduct {

    @Autowired
    private final ProductService service;

    public AddProduct(ProductService service) {
        this.service = service;
    }

    public Product add(ProductRequest request) {
        return new ProductHandler(service)
                .add(new AddProductCommand(request.getTitle(),
                        new BigDecimal(request.getPrice())));
    }
}
