package com.luiz.actions.client;

import com.luiz.infrastructure.command.CommandHandler;
import com.luiz.infrastructure.query.QueryHandler;
import com.luiz.support.builder.ProductTestBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * The type Product controller should.
 */
@DisplayName("Product Controller")
@WebMvcTest(ProductController.class)
class ProductControllerShould {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommandHandler commandHandler;

    @MockBean
    private QueryHandler queryHandler;

    /**
     * Say hello.
     *
     * @throws Exception the exception
     */
    @Test
    @DisplayName("Default")
    public void sayHello() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Add new product.
     *
     * @throws Exception the exception
     */
    @Test
    @DisplayName("Add new product")
    void addNewProduct() throws Exception {
        when(commandHandler.execute(any())).thenReturn(ProductTestBuilder.anProduct());
        this.mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Lipitor\", \"price\":\"10.99\"}"))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    /**
     * Find all.
     *
     * @throws Exception the exception
     */
    @Test
    @DisplayName("Fill all products")
    void findAll() throws Exception {
        this.mockMvc.perform(get("/products"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}