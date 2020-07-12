package com.luiz.support.assertion;

import com.luiz.domain.model.Product;
import org.assertj.core.api.AbstractAssert;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The type Product list assert.
 */
public class ProductListAssert extends AbstractAssert<ProductListAssert, List<Product>> {

    private final List<Product> products;

    /**
     * Instantiates a new Product list assert.
     *
     * @param products the products
     */
    public ProductListAssert(List<Product> products) {
        super(products, ProductListAssert.class);
        this.products = products;
    }

    /**
     * Assert that product list assert.
     *
     * @param products the products
     * @return the product list assert
     */
    public static ProductListAssert assertThat(List<Product> products) {
        return new ProductListAssert(products);
    }

    /**
     * Has price lower than product list assert.
     *
     * @param price the price
     */
    public void hasPriceLowerThan(BigDecimal price) {
        products.forEach(product -> {
            if (product.getPrice().compareTo(price) < 0) {
                failWithMessage("The price should be lower than " + price);
            }
        });
    }

    /**
     * Has price bigger than product list assert.
     *
     * @param price the price
     */
    public void hasPriceBiggerThan(BigDecimal price) {
        products.forEach(product -> {
            if (product.getPrice().compareTo(price) > 0) {
                failWithMessage("The price should be bigger than " + price);
            }
        });
    }

    public void allAttributes() {
        assertAll(() -> {
            for (Product product : products) {
                assertNotNull(product.getTitle(), "The title should be something written");
            }
        });
    }
}
