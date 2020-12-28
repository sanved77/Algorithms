import java.util.Arrays;

public class CutRod {

    public static void main(String[] args) {
        test(new int[]{1,5,8,9});
        test(new int[]{1,5,8,9,10,17,17,20});
        test(new int[]{3,5,8,9,10,17,17,20});
    }

    public static int[] cutRod(int[] prices){
        int[] dp = new int[prices.length + 1];
        for(int i = 1; i < dp.length; i++) dp[i] = prices[i - 1];
        dp[0] = 0;

        for(int i = 1; i <= prices.length; i++){
            for(int j = i; j >= 0; j--){
                dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
            }
        }

        return dp;
    }

    public static void test(int prices[]){
        System.out.println(Arrays.toString(prices) + "\n" + Arrays.toString(cutRod(prices)) + "\n-------------------");
    }

}

// +1 510 676 8124