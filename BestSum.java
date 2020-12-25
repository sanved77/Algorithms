import java.util.*;

public class BestSum {
    
    public static void main(String[] args) {
        test(new int[]{5,3,4,7}, 7);
        test(new int[]{5,3,4,7}, 2);
        test(new int[]{2,3,5}, 8);
        test(new int[]{1,4,5}, 8);
        test(new int[]{2,25}, 100);
        test(new int[]{1,2,5,25}, 100);
        test(new int[]{7,14}, 300);
        test(new int[]{7,15}, 300);
        test(new int[]{3,27}, 300);
    }

    public static List<Integer> bestSum(int[] nums, int target, HashMap<Integer, List<Integer>> map){
        
        if(target == 0)
            return new ArrayList<>(); 
        if(target < 0)
            return null;
        
        if(map.containsKey(target)) 
            return (map.get(target) != null) ? new ArrayList<>(map.get(target)) : null;

        List<Integer> result = null;
        for(int i = 0; i < nums.length; i++){
            List<Integer> temp = bestSum(nums, target - nums[i], map);
            if(temp != null){
                temp.add(nums[i]);
                if(result == null || (temp.size() < result.size())) 
                    result = new ArrayList<>(temp);
            }
        }

        if(result != null) 
            map.put(target, new ArrayList<>(result));
        else
            map.put(target, null);
        return (result != null) ? new ArrayList<>(result) : null;
    }

    public static void test(int[] nums, int target){
        System.out.print(Arrays.toString(nums) + " : " + target + " - ");
        List<Integer> list = bestSum(nums, target, new HashMap<Integer, List<Integer>>());
        if(list == null) System.out.println("Cannot be formed");
        else System.out.println(list.toString());
    }
}
