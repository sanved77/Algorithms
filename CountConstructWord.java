import java.util.*;

public class CountConstructWord {
    public static void main(String[] args) {
        test("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"});
        test("abcdefab", new String[]{"ab", "abc", "cd", "def", "abcd"});
        test("abcdefe", new String[]{"ab", "abc", "cd", "def", "abcd"});
        test("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"});
        test("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e","ee","eee","eeee","eeeee",});
        test("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee", new String[]{"e","ee","eee","eeee","eeeee",});
        test("banana", new String[]{"ba", "a", "n", "na", "an"});
        test("purple", new String[]{"purp", "p", "ur", "le", "purpl"});
    }

    public static int countConstruct(String word, String[] list, HashMap<String, Integer> map) {
        if(word.length() == 0)
            return 1;
        if(map.containsKey(word)) 
            return map.get(word);

        int result = 0;

        for(int i = 0; i < list.length; i++){
            if(word.startsWith(list[i])){
                result += countConstruct(word.substring(list[i].length()), list, map);
            }
        }

        map.put(word, result);
        return result;
    }

    public static void test(String word, String[] list){
        int res = countConstruct(word, list, new HashMap<String, Integer>());
        System.out.println(word + " - " + res);
    }
}
