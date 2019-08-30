public class CutRod {

    public static void main(String ag[]){

        // int[] prices = {50, 2, 40, 3, 4, 1, 6, 7};
        // int[] prices = {2,3,7,8,10};
        // int[] prices = {1,5,8,9,10};
        int[] prices = {1,5,8,9,10, 17, 17, 20};

        int[] result = new int[prices.length + 1];

        int[] table = new int[prices.length + 1];

        result[0] = 0;
        
        for(int i = 1; i <= prices.length;i++){
            int max = -1; int sTemp;
            for(int j = 1 ; j <= i; j++){
                int temp = prices[j-1] + result[i - j];
                System.out.println("[i = " + i + ", j = " + j + "] : p[" + j + " - 1]" + " R[" + i + " - " + j + "] = " + " p[" + (j-1) + "] + R[" + (i-j) + "] = "  + (prices[j-1] + result[i - j]) 
                + "; priceNow = " + temp);
                if(temp > max) {
                    max = temp;
                    table[i] = j;
                }
            }
            System.out.println("");
            result[i] = max;
        }
        int n = prices.length;
        while(n != 0){
            System.out.println(" - " + table[n]);
            n -= table[n];
        }

        System.out.print("\nResults - [");
        for(int a : result){
            System.out.print(a + ",");
        }
        System.out.print("]");

    }

}