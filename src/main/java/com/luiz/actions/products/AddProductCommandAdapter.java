package com.luiz.actions.products;

import com.luiz.domain.model.AddProductCommand;
import com.luiz.domain.model.Product;
import com.luiz.domain.model.ProductService;
import com.luiz.infrastructure.command.CommandAdapter;
import com.luiz.infrastructure.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The type Add product command adapter.
 */
@Component
@Command
public class AddProductCommandAdapter implements CommandAdapter<Product, AddProductCommand> {

    @Autowired
    private final ProductService service;

    /**
     * Instantiates a new Add product command adapter.
     *
     * @param service the service
     */
    public AddProductCommandAdapter(ProductService service) {
        this.service = service;
    }


    @Override
    public Product execute(AddProductCommand command) {
        return service.add(command.getTitle(), command.getPrice());
    }
}
