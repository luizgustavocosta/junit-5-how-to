package com.luiz.actions.products;

import com.luiz.command.AddProductCommand;
import com.luiz.domain.model.Product;
import com.luiz.domain.model.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The type Product handler.
 */
@Component
public class ProductHandler {

    @Autowired
    private ProductService service;

    /**
     * Instantiates a new Product handler.
     *
     * @param service the service
     */
    public ProductHandler(ProductService service) {
        this.service = service;
    }

    /**
     * Add.
     *
     * @param command the command
     */
    public Product add(AddProductCommand command) {
        return service.add(command.getTitle(), command.getPrice());
    }
}
