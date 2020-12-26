import java.util.*;

public class CanSumTab {
    public static void main(String[] args) {
        test(new int[]{5,3,4}, 7);
        test(new int[]{5,3}, 7);
        test(new int[]{7,14}, 300);
        test(new int[]{7,15}, 300);
    }

    public static boolean canSum(int[] nums, int target){
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;

        for(int i = 1; i <= target; i++){
            for(int num : nums){
               if((i - num) >= 0 && dp[i-num]) dp[i] = true;
            }
        }

        return dp[target];
    }

    public static void test(int[] nums, int target){
        System.out.println(target + ",  " + Arrays.toString(nums) + " : " + canSum(nums, target));
    }

}

