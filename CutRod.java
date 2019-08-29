public class CutRod {

    public static void main(String ag[]){

        int[] prices = {1,5,8,9,10};

        int[] result = new int[prices.length + 1];

        result[0] = 0;
        
        for(int i = 1; i <= 5;i++){
            int max = -1;
            for(int j = 1 ; j <= i; j++){
                int temp = prices[j-1] + result[i - j];
                if(temp > max) max = temp;
            }
            result[i] = max;
        }

        for(int a : result){
            System.out.println(" - " + a);
        }

    }

}