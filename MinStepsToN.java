import java.util.HashMap;

class MinStepsToN {

    public static void main(String[] args) {
        test(10);
        test(4);
        test(7);
    }

    public static int minStepsToN(int n, HashMap<Integer, Integer> map){
        if(n == 1) return 0;

        // if(map.containsKey(n)) return map.get(n);

        int result = 1 + minStepsToN(n - 1, map);

        if(n%2 == 0) result = Math.min(result, 1 + minStepsToN(n/2, map));
        if(n%3 == 0) result = Math.min(result, 1 + minStepsToN(n/3, map));

        map.put(n, result);
        return result;
    }

    public static void test(int n){
        System.out.println(n + " - " + minStepsToN(n, new HashMap<Integer, Integer>()));
    }
}