package com.github.utils;

public class UtilsGenerator {

    public static final String LETTRES = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static String padLeft(String input, int length) {
        while (input.length() < length) {
            input = "0" + input;
        }
        return input;
    }

    public static char getLetter(long number) {
        return LETTRES.charAt((int) (number % 23));
    }

    public static String calculaControlCIF(String r) {
        String t = r.substring(1);
        int a = 0, e = 0;

        // Sum of digits at odd positions (starting from 1)
        for (int n = 1; n < t.length(); n += 2) {
            a += Integer.parseInt(t.substring(n, n + 1));
        }

        // Sum of digits for even positions, with specific rules
        for (int n = 0; n < t.length(); n += 2) {
            int l = 2 * Integer.parseInt(t.substring(n, n + 1));
            if (String.valueOf(l).length() == 1) {
                e += l; // Single digit, add directly
            } else {
                // Double digit, add both digits
                e += Integer.parseInt(String.valueOf(l).substring(0, 1)) +
                        Integer.parseInt(String.valueOf(l).substring(1, 2));
            }
        }

        // Final calculation
        a += e;
        int o = 10 - (a % 10);
        String s = r.substring(0, 1).toUpperCase();

        // Determine control character based on initial letter
        if (s.matches("[PQRSNW]")) {
            return String.valueOf((char) (64 + o)).toUpperCase(); // Convert number to letter
        } else if (s.matches("[ABCDEFGHJUV]")) {
            if (o == 10) {
                o = 0;
            }
            return String.valueOf(o); // Return digit
        } else {
            return getLetter(Long.parseLong(r))+""; // Call external method for other cases
        }
    }
}
