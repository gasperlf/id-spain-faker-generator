package com.github.utils;

public class UtilsGenerator {

    public static final String LETTRES = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static String padLeft(String input, int length) {
        StringBuilder inputBuilder = new StringBuilder(input);
        while (inputBuilder.length() < length) {
            inputBuilder.insert(0, "0");
        }
        return inputBuilder.toString();
    }

    public static char getLetter(long number) {
        return LETTRES.charAt((int) (number % 23));
    }

    public static String getControlDigitCIF(String value) {
        String t = value.substring(1);
        int a = 0;
        int e = 0;

        for (int n = 1; n < t.length(); n += 2) {
            a += Integer.parseInt(t.substring(n, n + 1));
        }

        for (int n = 0; n < t.length(); n += 2) {
            int l = 2 * Integer.parseInt(t.substring(n, n + 1));
            if (String.valueOf(l).length() == 1) {
                e += l;
            } else {
                e += Integer.parseInt(String.valueOf(l).substring(0, 1)) +
                        Integer.parseInt(String.valueOf(l).substring(1, 2));
            }
        }

        a += e;
        int o = 10 - (a % 10);
        String s = value.substring(0, 1).toUpperCase();

        if (s.matches("[PQRSNW]")) {
            return String.valueOf((char) (64 + o)).toUpperCase();
        } else if (s.matches("[ABCDEFGHJUV]")) {
            if (o == 10) {
                o = 0;
            }
            return String.valueOf(o);
        } else {
            return getLetter( value.matches(".*\\D.*")? 0L: Long.parseLong(value))+""; // Call external method for other cases
        }
    }
}
