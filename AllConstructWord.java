import java.util.*;

public class AllConstructWord {
    public static void main(String[] args) {
        test("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"});
        test("abcdefab", new String[]{"ab", "abc", "cd", "def", "abcd"});
        test("abcdefe", new String[]{"ab", "abc", "cd", "def", "abcd"});
        test("enterapotentpot", new String[]{"a", "p", "ent", "enter", "ot", "o", "t"});
        test("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e","ee","eee","eeee","eeeee",});
        test("eeeee", new String[]{"e","ee","eee","eeee","eeeee"});
        test("banana", new String[]{"ba", "a", "n", "na", "an"});
        test("purple", new String[]{"purp", "p", "ur", "le", "purpl"});
    }

    public static List<List<String>> allConstruct(String word, String[] list, HashMap<String, List<List<String>>> map) {
        if(word.length() == 0){ 
            List<List<String>> res = new ArrayList<>();
            res.add(new java.util.LinkedList<>());
            return res;
        }

        if(map.containsKey(word)) return map.get(word);

        List<List<String>> result = null;

        for(int i = 0; i < list.length; i++){
            if(word.startsWith(list[i])){
                List<List<String>> temp = allConstruct(word.substring(list[i].length()), list, map);
                if(temp != null){
                    if(result == null) result = new ArrayList<>();
                    for(List<String> li : temp){
                        List<String> ways = new java.util.LinkedList<>(li);
                        ways.add(0, list[i]);
                        result.add(ways);
                    }
                } 
            }
        }

        map.put(word, result);
        return result;
    }

    public static void test(String word, String[] list){
        List<List<String>> res = allConstruct(word, list, new HashMap<String, List<List<String>>>());
        for(int i = 0; i < 15; i++) System.out.print("-");
        System.out.println("\n" + word + " - ");
        if(res == null) 
            System.out.println("None");
        else {
            for(List<String> li : res){
                System.out.println(li.toString());
            }
        }
    }
}
