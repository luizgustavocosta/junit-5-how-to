package com.luiz.actions.products;

import com.luiz.domain.model.FindAllProductsQuery;
import com.luiz.domain.model.Product;
import com.luiz.domain.model.ProductService;
import com.luiz.support.assertion.ProductListAssert;
import com.luiz.support.builder.ProductTestBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.condition.JRE.JAVA_10;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;
import static org.mockito.Mockito.when;

/**
 * The type Find all products query adapter test.
 */
@DisplayName("FindAllProductsQueryAdapterTest - Another way to inject mock")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FindAllProductsQueryAdapterTest {

    /**
     * The Service.
     */
    @Mock
    ProductService service;

    /**
     * The Adapter.
     */
    FindAllProductsQueryAdapter adapter;

    /**
     * Sets up.
     */
    @BeforeAll
    void setUp() {
        MockitoAnnotations.initMocks(this);
        adapter = new FindAllProductsQueryAdapter(service);
    }

    /**
     * Execute.
     */
    @Test
    @DisplayName("Product Query Adapter communicates with Service")
    void execute() {
        when(service.findAll()).thenReturn(ProductTestBuilder.anListOfProduct());
        final List<Product> products = adapter.execute(new FindAllProductsQuery());

        ProductListAssert.assertThat(products).allAttributes();

        when(service.findAll()).thenReturn(Collections.singletonList(ProductTestBuilder.anExpensiveProduct()));
        final List<Product> newProducts = adapter.execute(new FindAllProductsQuery());
        ProductListAssert.assertThat(newProducts).hasPriceLowerThan(BigDecimal.TEN);
    }


    /**
     * What is your jre.
     */
    @Test
    @EnabledOnJre({ JAVA_9, JAVA_10 })
    void onlyForJava9And10() {
        System.out.println("Running in a version 9 or 10");
    }
}