package com.luiz.actions.client;

import com.luiz.actions.client.dto.ProductResponse;
import com.luiz.domain.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The interface Product client.
 */
public interface ProductClient {

    /**
     * Transform product response.
     *
     * @param product the product
     * @return the product response
     */
    default ProductResponse transform(Product product) {
        return new ProductResponse(product.getId(), product.getTitle(), product.getPrice());
    }

    /**
     * Transform list.
     *
     * @param product the product
     * @return the list
     */
    default List<ProductResponse> transform(List<Product> product) {
         return product.stream().map(this::transform).collect(Collectors.toList());
    }

    /**
     * Transform product response.
     *
     * @param object the object
     * @return the product response
     */
    default ProductResponse transform(Object object) {
        if (!(object instanceof Product)) {
            return null;
        } else {
            Product product = (Product) object;
            return new ProductResponse(product.getId(), product.getTitle(), product.getPrice());
        }
    }

    default List<ProductResponse> transformList(Object object) {
        if (!(object instanceof List)) {
            return Collections.emptyList();
        } else {
            return transform((List<Product>) object);
        }
    }
}
