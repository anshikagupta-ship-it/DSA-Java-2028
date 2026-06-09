package Week2.Day1;

public class RansomNote {
    

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] count = new int[26];

        
        for (char ch : magazine.toCharArray()) {
            count[ch - 'a']++;
        }

       
        for (char ch : ransomNote.toCharArray()) {

            if (count[ch - 'a'] == 0) {
                return false;
            }

            count[ch - 'a']--;
        }

        return true;
    }

    public static void main(String[] args) {

        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(canConstruct(ransomNote, magazine));
    }
}
