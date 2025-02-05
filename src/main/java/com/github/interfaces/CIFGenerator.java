package com.github.interfaces;

import com.github.vo.CustomCIFType;

public interface CIFGenerator {

    static final String LETTER="ABCDEFGHJNPQRSUVW";

    String cif();

    String cif(CustomCIFType customCIFType);
}
