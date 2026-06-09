package Week2.Day2;
import java.util.Arrays;

public class Permutation {


    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        
        if (Arrays.equals(count1, count2)) {
            return true;
        }

        
        for (int i = s1.length(); i < s2.length(); i++) {

            
            count2[s2.charAt(i) - 'a']++;

           
            count2[s2.charAt(i - s1.length()) - 'a']--;

            
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }
}
