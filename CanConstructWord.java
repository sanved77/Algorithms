import java.util.*;

public class CanConstructWord {
    public static void main(String[] args) {
        test("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"});
        test("abcdefab", new String[]{"ab", "abc", "cd", "def", "abcd"});
        test("abcdefe", new String[]{"ab", "abc", "cd", "def", "abcd"});
        test("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"});
        test("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e","ee","eee","eeee","eeeee",});
    }

    public static boolean canConstruct(String word, String[] list, HashMap<String, Boolean> map) {
        if(word.length() == 0){
            return true;
        }

        if(map.containsKey(word)) return map.get(word);
        boolean result = false;

        for(int i = 0; i < list.length; i++){
            if(word.startsWith(list[i])){
                result = result || canConstruct(word.substring(list[i].length()), list, map);
            }
        }

        map.put(word, result);
        return result;
    }

    public static void test(String word, String[] list){
        if(canConstruct(word, list, new HashMap<String, Boolean>()))
            System.out.println(word + " - YES");
        else    
            System.out.println(word + " - NO");
    }
}
