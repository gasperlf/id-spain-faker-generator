package com.github;

import com.github.interfaces.CIFGenerator;
import com.github.interfaces.NIEGenerator;
import com.github.interfaces.NIFGenerator;
import com.github.vo.CustomCIFType;

import java.util.Random;

import static com.github.utils.UtilsGenerator.calculaControlCIF;
import static com.github.utils.UtilsGenerator.getLetter;
import static com.github.utils.UtilsGenerator.padLeft;

public class Generator implements NIEGenerator, NIFGenerator, CIFGenerator {

    Random random = new Random();

    @Override
    public String nif() {
        int value = random.nextInt((int)(100000000 * random.nextFloat()));
        char a = getLetter(value);
        return padLeft(String.valueOf(value), 8) + a;
    }

    @Override
    public String nie() {
        int index = random.nextInt(NIEGenerator.LETTER.length());
        int value = random.nextInt((int)(10000000 * random.nextFloat()));
        String rTString = padLeft(String.valueOf(Long.parseLong(index + padLeft(String.valueOf(value), 7))), 8);
        char a = getLetter(Long.parseLong(rTString));
        return NIEGenerator.LETTER.charAt(index) + padLeft(String.valueOf(value), 7) + a;
    }

    @Override
    public String cif() {
        int maxLengthRange = CIFGenerator.LETTER.length();
        String initialLetter = String.valueOf(CIFGenerator.LETTER.charAt((int)(maxLengthRange * random.nextFloat())));
        int minValue = (int)(100 * random.nextFloat());
        int maxValue = (int)(100000 * random.nextFloat());
        String x = initialLetter + padLeft(String.valueOf(minValue), 2) + padLeft(String.valueOf(maxValue), 5);
        return x + calculaControlCIF(x);
    }

    @Override
    public String cif(CustomCIFType customCIFType) {
        String initialLetter = customCIFType.getLetter();
        int minValue = (int)(100 * random.nextFloat());
        int maxValue = (int)(100000 * random.nextFloat());
        String x = initialLetter + padLeft(String.valueOf(minValue), 2) + padLeft(String.valueOf(maxValue), 5);
        return x + calculaControlCIF(x);

    }

}
