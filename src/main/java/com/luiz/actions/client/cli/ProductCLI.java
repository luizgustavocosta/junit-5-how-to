package com.luiz.actions.client.cli;

import com.luiz.actions.products.AddProduct;
import com.luiz.domain.model.Product;
import com.luiz.query.FindProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The type Product controller cli.
 */
@Component
public class ProductCLI implements CommandLineInterface {

    @Autowired
    private final AddProduct addProduct;

    @Autowired
    private final FindProducts findProducts;

    /**
     * Instantiates a new Product controller cli.
     *
     * @param addProduct   the add product
     * @param findProducts the find products
     */
    public ProductCLI(AddProduct addProduct, FindProducts findProducts) {
        this.addProduct = addProduct;
        this.findProducts = findProducts;
    }

    /**
     * Add.
     *
     * @param title the title
     * @param price the price
     */
    public void add(String title, String price) {
        final ProductRequest request = new ProductRequest();
        request.setTitle(title);
        request.setPrice(price);
        addProduct.add(request);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Product> findAll() {
        return findProducts.execute();
    }
}
