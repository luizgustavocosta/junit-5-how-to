package com.luiz.domain.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import static java.util.Objects.isNull;

// Entity
public class Product {

    private final String id;
    private final String title;
    private final BigDecimal price;

    public Product(String id, String title, BigDecimal price) {
        Objects.requireNonNull(title);
        Objects.requireNonNull(price);
        if (isNull(id)) {
            this.id = UUID.randomUUID().toString();
        } else {
            this.id = id;
        }
        this.title = title;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    public static final class ProductBuilder {
        private String id;
        private String title;
        private BigDecimal price;

        private ProductBuilder() {
        }

        public static ProductBuilder aProduct() {
            return new ProductBuilder();
        }

        public ProductBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public ProductBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ProductBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(this.id, this.title, this.price);
        }
    }
}
