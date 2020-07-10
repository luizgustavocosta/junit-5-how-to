package com.luiz.domain.model;

import com.luiz.actions.products.ClientCommand;

import java.math.BigDecimal;

/**
 * The type Add product command.
 */
public class AddProductCommand implements ClientCommand {

    private String title;
    private BigDecimal price;

    /**
     * Instantiates a new Add product command.
     *
     * @param title the title
     * @param price the price
     */
    public AddProductCommand(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

}
