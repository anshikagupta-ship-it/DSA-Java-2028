package Week2.Day5;

public class LongestPalindrome {

    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expand(s, i, i);

            int len2 = expand(s, i, i + 1);

            int currentMax = Math.max(len1, len2);

            if (currentMax > maxLength) {

                maxLength = currentMax;

                start = i - (currentMax - 1) / 2;
            }
        }

        return s.substring(start, start + maxLength);
    }

    private static int expand(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {

        String s = "babad";

        System.out.println(longestPalindrome(s));
    }
}