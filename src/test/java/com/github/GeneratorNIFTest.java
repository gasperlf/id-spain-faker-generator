package com.github;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GeneratorNIFTest {

    Generator generator = new Generator();

    @Test
    void shouldGenerateNIF() {
        //act
        String nif = generator.nif();
        //assert
        assertThat(nif)
                .isNotBlank()
                .hasSize(9)
                .isAlphanumeric()
                .matches(value -> value.matches(".*[A-Z]$"));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 15, 50})
    void shouldGenerateMultipleNIEValues(int randomValue) {

        List<String> nifList = new ArrayList<>();
        for (int i = 0; i < randomValue ; i++) {
            nifList.add(generator.nif());
        }

        assertThat(nifList)
                .isNotEmpty()
                .hasSize(randomValue)
                .allMatch(value -> ((String)value).matches(".*[A-Z]$"))
                ;
    }
}
