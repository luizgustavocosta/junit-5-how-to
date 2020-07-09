package com.luiz.parser;

import com.luiz.domain.model.Product;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

import java.math.BigDecimal;

/**
 * The type Product aggregator.
 */
public class ProductAggregator implements ArgumentsAggregator {
    @Override
    public Object aggregateArguments(ArgumentsAccessor accessor,
                                     ParameterContext context) throws ArgumentsAggregationException {
        return Product.ProductBuilder.aProduct()
                .withId(accessor.getString(0))
                .withTitle(accessor.getString(1))
                .withPrice(new BigDecimal(accessor.getString(2)))
                .build();


    }
}
