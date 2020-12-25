import java.util.HashSet;

public class CanSum {
    public static void main(String[] args) {
        System.out.println("[5,3,4,7] : 2 - " + canSum(new int[]{5,3,4,7}, 2, new HashSet<Integer>()));
        System.out.println("[5,3,4,7] : 7 - " + canSum(new int[]{5,3,4,7}, 7, new HashSet<Integer>()));
        System.out.println("[5,3,4,7] : 27 - " + canSum(new int[]{5,3,4,7}, 27, new HashSet<Integer>()));
    }

    public static boolean canSum(int[] nums, int target, HashSet<Integer> map){
        if(target == 0) return true;
        if(map.contains(target)) return true;

        for(int i = 0; i < nums.length; i++){
            if(target < nums[i]) break;
            if(canSum(nums, target - nums[i], map)){
                map.add(target);
                return true;
            }
        }

        return false;
    }
}
