package com.github;

import com.github.vo.CustomCIFType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GeneratorCIFTest {

    Generator generator = new Generator();

    @Test
    void shouldGenerateCIF() {
        //act
        String cif = generator.cif();
        //assert
        assertThat(cif)
                .isNotBlank()
                .hasSize(9)
                .isAlphanumeric();
    }

    @Test
    void shouldGenerateCustomCIF() {
        //act
        String cif = generator.cif(CustomCIFType.SOCIEDAD_ANONIMA);
        //assert
        assertThat(cif)
                .isNotBlank()
                .hasSize(9)
                .isAlphanumeric();
    }

    @Test
    void shouldGenerateCustomCIFAllTypes() {
        //act
      for (CustomCIFType customCIFType:CustomCIFType.values()) {
          String cif = generator.cif(customCIFType);
          //assert
          assertThat(cif)
                  .isNotBlank()
                  .hasSize(9)
                  .isAlphanumeric()
                  ;
      }


    }

    @ParameterizedTest
    @ValueSource(ints = {10, 15, 50})
    void shouldGenerateMultipleCIEValues(int randomValue) {

        List<String> cifList = new ArrayList<>();
        for (int i = 0; i < randomValue ; i++) {
            cifList.add(generator.cif());
        }

        assertThat(cifList)
                .isNotEmpty()
                .hasSize(randomValue)
                .allMatch(value -> ((String)value).length() == 9);
    }
}
