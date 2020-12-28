import java.util.Arrays;

class HouseRob {

    public static void main(String[] args) {
        test(new int[]{1,2,3,1});
        test(new int[]{2,7,9,3,1});
    }

    public static int robber(int[] houses){

        int[] dp = new int[houses.length];

        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);

        for(int i = 2; i < houses.length; i++){
            dp[i] = Math.max(houses[i] + dp[i-2], dp[i-1]);
        }

        return dp[houses.length - 1];
    }

    public static void test(int[] houses){
        System.out.println(Arrays.toString(houses) + " - " + robber(houses));
    }

}