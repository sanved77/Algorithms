public class CanConstructTab {
    public static void main(String[] args) {
        test("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"});
        test("abcdefab", new String[]{"ab", "abc", "cd", "def", "abcd"});
        test("abcdefe", new String[]{"ab", "abc", "cd", "def", "abcd"});
        test("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"});
        test("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e","ee","eee","eeee","eeeee",});
    }

    public static boolean canConstruct(String word, String[] list){

        boolean[] dp = new boolean[word.length() + 1];

        dp[0] = true;

        for(int i = 0; i < word.length(); i++){
            if(dp[i]){
                String temp = word.substring(i);
                for(String w : list){
                    if(temp.startsWith(w)){
                        dp[w.length() + i] = true;
                    }
                }
            }
        }

        return dp[word.length()];
    }

    public static void test(String word, String[] list){
        System.out.println(word + "  - " + canConstruct(word, list));
    }
}
