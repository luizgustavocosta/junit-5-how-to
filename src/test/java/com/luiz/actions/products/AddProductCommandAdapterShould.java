package com.luiz.actions.products;

import com.luiz.domain.model.AddProductCommand;
import com.luiz.domain.model.Product;
import com.luiz.domain.model.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * The type Add product command adapter should.
 */
@ExtendWith(MockitoExtension.class)
class AddProductCommandAdapterShould {

    /**
     * The Adapter.
     */
    AddProductCommandAdapter adapter;

    /**
     * Sets up.
     *
     * @param service the service
     */
    @BeforeEach
    void setUp(@Mock ProductService service) {
        adapter = new AddProductCommandAdapter(service);
    }

    /**
     * Execute.
     */
    @Test
    @DisplayName("Product Adapter communicates with Service")
    void execute() {
        final Product product = adapter.execute(new AddProductCommand("Lorem ipsum", BigDecimal.TEN));
        assertNull(product, "Is expected a null product since you're using mock here");
    }
}