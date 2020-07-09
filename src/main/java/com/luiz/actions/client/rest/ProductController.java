package com.luiz.actions.client.rest;

import com.luiz.actions.client.cli.ProductRequest;
import com.luiz.actions.products.AddProduct;
import com.luiz.domain.model.Product;
import com.luiz.query.FindProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * The type Product controller.
 */
@RestController
public class ProductController {

    @Autowired
    private final AddProduct addProduct;

    @Autowired
    private final FindProducts findProducts;

    public ProductController(AddProduct addProduct, FindProducts findProducts) {
        this.addProduct = addProduct;
        this.findProducts = findProducts;
    }

    /**
     * Hello string.
     *
     * @return the string
     */
    @RequestMapping("/")
    String hello() {
        return "Hello there!";
    }

    @PostMapping("/products")
    ResponseEntity<Product> add(@RequestBody ProductRequest request) throws URISyntaxException {
        Product product = addProduct.add(request);
        return ResponseEntity
                .created(new URI(product.getId()))
                .body(product);
    }

    @GetMapping("/products")
    List<Product> findAll() {
        return findProducts.execute();
    }
}
