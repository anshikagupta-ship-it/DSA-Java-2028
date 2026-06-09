package Week2.Day2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AllAnagrams {


    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] countP = new int[26];
        int[] countS = new int[26];

        
        for (int i = 0; i < p.length(); i++) {
            countP[p.charAt(i) - 'a']++;
            countS[s.charAt(i) - 'a']++;
        }

        
        if (Arrays.equals(countP, countS)) {
            result.add(0);
        }

        
        for (int i = p.length(); i < s.length(); i++) {

            
            countS[s.charAt(i) - 'a']++;

            
            countS[s.charAt(i - p.length()) - 'a']--;

            
            if (Arrays.equals(countP, countS)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }
}
