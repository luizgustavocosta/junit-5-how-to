package com.luiz.command;

import java.math.BigDecimal;

/**
 * The type Add product command.
 */
public class AddProductCommand {

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
