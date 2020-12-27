public class ClimbingStairsK {
    
    public static void main(String[] args) {
        test(2,2);
        test(3,2);
        test(5,2);
        test(15,2);
        test(3,3);
        test(5,5);
        test(15,5);
    }

    public static int climb(int stairs, int k){
        int[] dp = new int[stairs + 1];

        for(int i = 1; i <= k; i++){
            dp[i] = (int) Math.pow((double) 2, (double)i-1);
        }

        for(int i = k+1; i <= stairs; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[stairs];
    }

    public static void test(int stairs, int k){
        System.out.println("[n:" + stairs + ",k:" + k + "] - " + climb(stairs, k));
    }
}
