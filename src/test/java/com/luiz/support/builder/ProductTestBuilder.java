package com.luiz.support.builder;

import com.luiz.domain.model.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * The type Product test builder.
 */
public class ProductTestBuilder {

    /**
     * An product product.
     *
     * @return the product
     */
    public static Product anProduct() {
        return Product.ProductBuilder.aProduct()
                .withId("1")
                .withTitle("New kids on the block")
                .withPrice(BigDecimal.ZERO)
                .build();
    }

    /**
     * An expensive product product.
     *
     * @return the product
     */
    public static Product anExpensiveProduct() {
        return Product.ProductBuilder.aProduct()
                .withId("1")
                .withTitle("Sneakers")
                .withPrice(new BigDecimal(2020))
                .build();
    }

    /**
     * An list of product list.
     *
     * @return the list
     */
    public static List<Product> anListOfProduct() {
        return Arrays.asList(anProduct(), anProduct());
    }
}
