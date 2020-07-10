package com.luiz.actions.client;


import com.luiz.actions.client.dto.ProductResponse;
import com.luiz.domain.model.AddProductCommand;
import com.luiz.domain.model.FindAllProductsQuery;
import com.luiz.infrastructure.command.CommandHandler;
import com.luiz.infrastructure.query.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * The type Product controller cli.
 */
@Component
public class ProductCLI implements ProductClient {

    @Autowired
    private final CommandHandler commandHandler;

    @Autowired
    private final QueryHandler queryHandler;

    /**
     * Instantiates a new Product cli.
     *
     * @param commandHandler the command handler
     * @param queryHandler   the query handler
     */
    public ProductCLI(CommandHandler commandHandler, QueryHandler queryHandler) {
        this.commandHandler = commandHandler;
        this.queryHandler = queryHandler;
    }

    /**
     * Add.
     *
     * @param title the title
     * @param price the price
     * @return the product response
     */
    public ProductResponse add(String title, String price) {
        return transform(commandHandler.execute(new AddProductCommand(title, new BigDecimal(price))));
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<ProductResponse> findAll() {
        return transformList(queryHandler.execute(new FindAllProductsQuery()));
    }
}
