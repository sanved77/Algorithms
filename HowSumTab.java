import java.util.*;

public class HowSumTab {
    public static void main(String[] args) {
        test(new int[]{5,3,4}, 7);
        test(new int[]{5,3}, 7);
        test(new int[]{5,2,3}, 8);
        test(new int[]{7,14}, 300);
        test(new int[]{7,15}, 300);
        test(new int[]{1}, 5);
    }

    public static List<Integer> howSum(int[] nums, int target){
        ArrayList<Integer>[] dp = new ArrayList[target + 1];

        dp[0] = new ArrayList<Integer>();

        for(int i = 1; i <= target; i++){
            for(int num : nums){
               if((i - num) >= 0 && dp[i-num] != null){
                   dp[i] = new ArrayList<>(dp[i-num]);
                   dp[i].add(num);
                   break;
               }
            }
        }

        return dp[target];
    }

    public static void test(int[] nums, int target){
        System.out.print(target + ",  " + Arrays.toString(nums) + " : ");
        List<Integer> res = howSum(nums, target);
        if(res == null) 
            System.out.println("Cannot be formed");
        else
            System.out.println(res.toString());
    }

}

/**
 * target = n ; nums.length = m
 * Time complexity - O(nm)
 * Space complexity - O(n^2)
 */