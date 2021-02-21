package com.luiz.actions.client;

import com.luiz.actions.client.dto.ProductRequest;
import com.luiz.domain.model.AddProductCommand;
import com.luiz.domain.model.FindAllProductsQuery;
import com.luiz.domain.model.Product;
import com.luiz.infrastructure.command.CommandHandler;
import com.luiz.infrastructure.query.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * The type Product controller.
 */
@RestController
public class ProductController implements ProductClient {

    @Autowired
    private final CommandHandler commandHandler;

    @Autowired
    private final QueryHandler queryHandler;

    public ProductController(CommandHandler commandHandler, QueryHandler queryHandler) {
        this.commandHandler = commandHandler;
        this.queryHandler = queryHandler;
    }

    /**
     * Hello string.
     *
     * @return the string
     */
    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Hello there!";
    }

    @PostMapping("/products")
    ResponseEntity<Product> add(@RequestBody ProductRequest request) throws URISyntaxException {
        Product product = (Product) commandHandler.execute(
                new AddProductCommand(request.getTitle(), new BigDecimal(request.getPrice())));
        return ResponseEntity
                .created(new URI(product.getId()))
                .body(product);
    }

    @GetMapping("/products")
    List<Product> findAll() {
        return (List<Product>) queryHandler.execute(new FindAllProductsQuery());
    }
}
