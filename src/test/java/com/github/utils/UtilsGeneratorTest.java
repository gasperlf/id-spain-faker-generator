package com.github.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsGeneratorTest {

    @ParameterizedTest
    @CsvSource({"12494830,B","Y7277072,T","A1234569,0", "P1536982,J"})
    void shouldGetControlDigitCIF(String cif, String digit) {

        //arrange
        //act
        var result = UtilsGenerator.getControlDigitCIF(cif);
        //assert
        assertThat(result).isEqualTo(digit);
    }
}
