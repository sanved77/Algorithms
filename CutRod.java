public class CutRod {

    public static void main(String ag[]){

        int[] prices = {1,5,8,9,10};

        int[] result = new int[prices.length + 1];

        result[0] = 0;
        
        for(int i = 1; i <= prices.length;i++){
            int max = -1;
            for(int j = 1 ; j <= i; j++){
                int temp = prices[j-1] + result[i - j];
                System.out.println("[i = " + i + ", j = " + j + "] : p[" + j + " - 1]" + " R[" + i + " - " + j + " ] = " + " p[" + (j-1) + "] + R[" + (i-j) + "] = "  + (prices[j-1] + result[i - j]) 
                + "; max = " + temp);
                if(temp > max) max = temp;
            }
            result[i] = max;
        }

        System.out.print("\nResults - [");
        for(int a : result){
            System.out.print(a + ",");
        }
        System.out.print("]");

    }

}