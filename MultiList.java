import java.util.*;

public class MultiList {

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();

        list.add(new int[] { 1, 1, 4, 5, 6, 1, 3, 7 });
        list.add(new int[] { 3, 1, 4, 5, 1, 7 });
        list.add(new int[] { 1, 1, 7, 5 });

        int[] dis = findCommon(list);

        for (int i : dis) {
            System.out.println("" + i);
        }
    }

    public static int[] findCommon(List<int[]> list) {
        int[] result;

        result = findBetween(list.get(0), list.get(1));

        for (int i = 2; i < list.size(); i++) {
            result = findBetween(result, list.get(i));
        }

        return result;
    }

    public static int[] findBetween(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : a)
            map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> temp = new ArrayList<>();
        for (int num : b) {
            if (map.containsKey(num)) {
                temp.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
}
