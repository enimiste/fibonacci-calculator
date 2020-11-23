package com.nouni.fibonacci.utils;

import static java.lang.Character.toUpperCase;

public class Utils {
    /**
     * Make the first character of each word in the input string in Uppercase
     * @param str
     * @return
     */
    public static String ucWords(String str) {
        if (str == null) return null;
        char[] xs = str.toCharArray();
        int cur = 0, prev = -1, n = xs.length;

        while (cur < n) {
            char curChar = xs[cur];
            if (prev != -1) {
                if (xs[prev] == ' ' && curChar != ' ') {
                    xs[cur] = toUpperCase(curChar);
                }
            } else if (curChar != ' ') {
                xs[cur] = toUpperCase(curChar);
            }
            prev = cur;
            cur++;
        }
        return new String(xs);
    }
}
