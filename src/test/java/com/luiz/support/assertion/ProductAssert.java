package com.luiz.support.assertion;

import com.luiz.domain.model.Product;
import org.assertj.core.api.AbstractAssert;

import java.math.BigDecimal;

/**
 * The type Product assert.
 */
public class ProductAssert extends AbstractAssert<ProductAssert, Product> {

    /**
     * Instantiates a new Product assert.
     *
     * @param product the product
     */
    public ProductAssert(Product product) {
        super(product, ProductAssert.class);
    }

    /**
     * Assert that product assert.
     *
     * @param actual the actual
     * @return the product assert
     */
    public static ProductAssert assertThat(Product actual) {
        return new ProductAssert(actual);
    }

    /**
     * Has price lower than 10 product assert.
     *
     * @param price the price
     * @return the product assert
     */
    public ProductAssert hasPriceLowerThan10(BigDecimal price) {
        if (price.compareTo(BigDecimal.TEN) > 0) {
            failWithMessage("The price should be lower than 10.00");
        }
        return this;
    }

    /**
     * Has price bigger than 10 product assert.
     *
     * @param price the price
     * @return the product assert
     */
    public ProductAssert hasPriceBiggerThan10(BigDecimal price) {
        if (price.compareTo(BigDecimal.TEN) < 0) {
            failWithMessage("The price should be bigger than 10.00");
        }
        return this;
    }
}
