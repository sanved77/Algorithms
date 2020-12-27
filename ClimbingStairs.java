public class ClimbingStairs {
    
    public static void main(String[] args) {
        test(2);
        test(3);
        test(5);
        test(15);
    }

    public static int climb(int stairs){
        int[] dp = new int[stairs + 1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= stairs; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[stairs];
    }

    public static void test(int stairs){
        System.out.println(stairs + " - " + climb(stairs));
    }
}
