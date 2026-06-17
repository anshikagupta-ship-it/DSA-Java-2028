package Week2.Day5;
import java.util.Arrays;

public class StringCompression {


    public static int compress(char[] chars) {

        int write = 0;
        int read = 0;

        while (read < chars.length) {

            char currentChar = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            chars[write] = currentChar;
            write++;

            if (count > 1) {

                String countStr = String.valueOf(count);

                for (char c : countStr.toCharArray()) {
                    chars[write] = c;
                    write++;
                }
            }
        }

        return write;
    }

    public static void main(String[] args) {

        char[] chars = {'a','a','b','b','c','c','c'};

        int length = compress(chars);

        System.out.println(length);

        for (int i = 0; i < length; i++) {
            System.out.print(chars[i] + " ");
        }
    }
}