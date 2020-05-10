
public class ThreeStrings {

    public static void main(String[] args) {
        String word1 = "parmesan";
        String word2 = "dashing";
        String word3 = "sandas";

        // Verbose test
        // String word1 = "sparmessan";
        // String word2 = "das";
        // String word3 = "sandas";

        if(isInterleaving(word1, word2, word3))
            System.out.println("The word interleaves");
        else
            System.out.println("The word does not interleave");

    }

    public static boolean isInterleaving(String word1, String word2, String word3){
        
        int len = word1.length() + word2.length();
        int j = 0;

        for(int i = 0; i < len; i++){
            if(j == word3.length()) return true;
            if(i < word1.length()){
                if(word3.charAt(j) == word1.charAt(i)) j++;
                else if(j > 0){
                    j = 0;
                    i--;
                }
            }else{
                if(j == 0) return false;
                if(word3.charAt(j) == word2.charAt(i - word1.length())) j++;
                else j = 0;
            }
        }

        if(j == word3.length()) return true;
        return false;

    }

}
