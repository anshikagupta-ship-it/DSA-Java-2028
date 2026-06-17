package Week2.Day4;
import java.util.Stack;

public class DecodeString {
    

    public static String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int currentNumber = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {

                currentNumber = currentNumber * 10 + (ch - '0');

            } else if (ch == '[') {

                countStack.push(currentNumber);
                stringStack.push(currentString);

                currentNumber = 0;
                currentString = new StringBuilder();

            } else if (ch == ']') {

                int repeat = countStack.pop();
                StringBuilder previous = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    previous.append(currentString);
                }

                currentString = previous;

            } else {

                currentString.append(ch);
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {

        String s = "3[a]2[bc]";

        System.out.println(decodeString(s));
    }
}
