package com.luiz.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Category Enum")
class CategoryTest {

    @EnumSource(Category.class)
    @ParameterizedTest
    void getDescription(Category category) {
        assertNotNull(category.getDescription());
    }
}