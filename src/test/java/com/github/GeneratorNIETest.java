package com.github;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GeneratorNIETest {

    Generator generator = new Generator();

    @Test
    void shouldGenerateNIE() {
        //act
        String nie = generator.nie();
        //assert
        assertThat(nie)
                .isNotBlank()
                .hasSize(9)
                .isAlphanumeric()
                .matches(value -> (value.startsWith("X") || value.startsWith("Y") || value.startsWith("Z")))
                .matches(value -> value.matches(".*[A-Z]$"));
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 15, 50})
    void shouldGenerateMultipleNIEValues(int randomValue) {

        List<String> nieList = new ArrayList<>();
        for (int i = 0; i < randomValue ; i++) {
           nieList.add(generator.nie());
        }

        assertThat(nieList)
                .isNotEmpty()
                .hasSize(randomValue)
                .allMatch(value -> ((String)value).matches(".*[A-Z]$"))
                ;
    }
}
