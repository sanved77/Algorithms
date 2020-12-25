import java.util.*;

public class HowSum {
    public static void main(String[] args) {
        test(new int[]{5,3,4,7}, 7);
        test(new int[]{5,3,4,7}, 2);
        test(new int[]{5,3,4,7}, 27);
        test(new int[]{2,3,5}, 8);
        test(new int[]{7,14}, 300);
        test(new int[]{7,15}, 300);
        test(new int[]{3,27}, 300);
    }

    public static List<Integer> howSum(int[] nums, int target, HashMap<Integer, List<Integer>> map){
        if(target == 0) 
            return new ArrayList<>();
        if(target < 0) 
            return null;

        if(map.containsKey(target)) return map.get(target);

        for(int i = 0; i < nums.length; i++){
            List<Integer> temp = howSum(nums, target - nums[i], map);
            if(temp != null){
                temp.add(nums[i]);
                map.put(target, temp);
                return temp;
            }
        }
        map.put(target, null);
        return null;
    }

    public static void test(int[] nums, int target){
        System.out.print(Arrays.toString(nums) + " : " + target + " - ");
        List<Integer> list = howSum(nums, target, new HashMap<Integer, List<Integer>>());
        if(list == null) System.out.println("Cannot be formed");
        else System.out.println(list.toString());
    }
}
