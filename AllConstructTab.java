import java.util.ArrayList;
import java.util.List;

public class AllConstructTab {
    public static void main(String[] args) {
        test("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"});
        test("abcdefab", new String[]{"ab", "abc", "cd", "def", "abcd"});
        test("abcdefe", new String[]{"ab", "abc", "cd", "def", "abcd"});
        test("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"});
        test("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e","ee","eee","eeee","eeeee"});
        test("eeeee", new String[]{"e","ee","eee","eeee","eeeee"});
        test("banana", new String[]{"ba", "a", "n", "na", "an"});
        test("purple", new String[]{"purp", "p", "ur", "le", "purpl"});
    }

    public static ArrayList<ArrayList<String>> allConstruct(String word, String[] list){

        ArrayList<ArrayList<String>>[] dp = new ArrayList[word.length() + 1];

        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>());

        for(int i = 0; i < word.length(); i++){
            if(dp[i] != null){
                String temp = word.substring(i);
                for(String w : list){
                    if(temp.startsWith(w)){
                        ArrayList<ArrayList<String>> newList = new ArrayList<>();
                        for(List<String> li : dp[i])
                            newList.add(new ArrayList<>(li));
                        if(dp[w.length() + i] == null) 
                            dp[w.length() + i] = new ArrayList<>();
                        for(List<String> li : newList){
                            li.add(w);
                            dp[w.length() + i].add(new ArrayList<>(li));
                        }
                    }
                }
            }
        }

        return dp[word.length()];
    }

    public static void test(String word, String[] list){
        System.out.println("------------\n" + word + " - ");
        ArrayList<ArrayList<String>> res = allConstruct(word, list);
        if(res == null)
            System.out.println("Cannot be formed");
        else{
            for(List<String> li : res)
                System.out.println(li.toString());
        }
    }
}
