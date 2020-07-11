package com.luiz.actions.client;

import com.luiz.actions.client.dto.ProductResponse;
import com.luiz.domain.model.Product;
import com.luiz.infrastructure.command.CommandHandler;
import com.luiz.infrastructure.query.QueryHandler;
import com.luiz.support.builder.ProductTestBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * The type Product cli test.
 */
@DisplayName("Client by Command Line Interface")
@ExtendWith(SpringExtension.class)
class ProductCLITest {

    @Mock
    private CommandHandler commandHandler;

    @Mock
    private QueryHandler queryHandler;

    /**
     * The Product cli.
     */
    ProductCLI productCLI;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        productCLI = new ProductCLI(commandHandler, queryHandler);
    }

    /**
     * Add.
     */
    @Test
    @DisplayName("Add new product by CLI")
    void add() {
        final Product product = ProductTestBuilder.anProduct();
        when(commandHandler.execute(any())).thenReturn(product);
        final ProductResponse productResponse = productCLI.add(product.getTitle(), product.getPrice().toString());
        verify(commandHandler, atLeastOnce()).execute(any());
        assertNotNull(productResponse);
    }

    /**
     * Find all.
     */
    @Test
    @DisplayName("Find all products")
    void findAll() {
        when(queryHandler.execute(any())).thenReturn(ProductTestBuilder.anListOfProduct());

        final List<ProductResponse> response = productCLI.findAll();

        assertFalse(response.isEmpty());

        final ProductResponse productResponse = response.stream().findFirst().orElseThrow(IllegalStateException::new);

        assertAll(() -> {
            assertNotNull(productResponse.getId());
            assertNotNull(productResponse.getTitle());
            assertNotNull(productResponse.getPrice());
            assertNotNull(productResponse.getTimestampAt());
        });
    }
}