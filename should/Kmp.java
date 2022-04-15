package should;

import java.util.concurrent.Flow.Subscriber;

public class Kmp {
    public static int kmp(String s1, String subStr) {
        int[] next = kmpNext(subStr);
        for (int i = 0, j = 0; i < s1.length(); i++) {
            while (j > 0 && s1.charAt(i) != subStr.charAt(j)) {
                j = next[j - 1];

            }
            if (s1.charAt(i) == subStr.charAt(j)) {
                j++;
            }
            if (j == subStr.length()) {
                return i - j + 1;
            }

        }
        return -1;

    }

    public static int[] kmpNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;

        }
        return next;
    }

}
