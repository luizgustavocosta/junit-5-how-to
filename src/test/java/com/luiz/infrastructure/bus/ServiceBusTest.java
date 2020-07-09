package com.luiz.infrastructure.bus;

import com.luiz.domain.model.Product;
import com.luiz.parser.CsvToProduct;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceBusTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/products.csv", numLinesToSkip = 1)
    void testBookSourceWithAnnotation(@CsvToProduct Product product) {
        LocalDate now = LocalDate.now();
        LocalDate twentyThirteen = LocalDate.of(2013, Month.JANUARY, 1);
        assertAll(
                () -> assertFalse(product.getId().isEmpty()),
                () -> assertNotNull(product.getTitle()));
    }

}
