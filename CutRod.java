public class CutRod {

    public static void main(String ag[]){

        /*

        Cutting Rod problem
        - Given - A rod; Info about how much is a rod worth based on it's length
        - To find the maximum profit for a given rod by breaking and selling it based on whatever the maximum value will provide

        - Example - 

        For every iteration it checks to see what is the maximum. Selling a length of (i) or a selling a length of 1 and length of (i-2) 
        and then selling a length of 2 and length of (i-2).

        So at length of 4 it basically checks if selling rod with length 4 is better than selling rod of length 1 and rod of length 3 
        and then it checks if selling rod of length 2 twice is better and so on

        [i = 1, j = 1] : p[1 - 1] R[1 - 1] =  p[0] + R[0] = 1; priceNow = 1

        [i = 2, j = 1] : p[1 - 1] R[2 - 1] =  p[0] + R[1] = 2; priceNow = 2
        [i = 2, j = 2] : p[2 - 1] R[2 - 2] =  p[1] + R[0] = 5; priceNow = 5

        [i = 3, j = 1] : p[1 - 1] R[3 - 1] =  p[0] + R[2] = 6; priceNow = 6
        [i = 3, j = 2] : p[2 - 1] R[3 - 2] =  p[1] + R[1] = 6; priceNow = 6
        [i = 3, j = 3] : p[3 - 1] R[3 - 3] =  p[2] + R[0] = 8; priceNow = 8

        [i = 4, j = 1] : p[1 - 1] R[4 - 1] =  p[0] + R[3] = 9; priceNow = 9
        [i = 4, j = 2] : p[2 - 1] R[4 - 2] =  p[1] + R[2] = 10; priceNow = 10
        [i = 4, j = 3] : p[3 - 1] R[4 - 3] =  p[2] + R[1] = 9; priceNow = 9
        [i = 4, j = 4] : p[4 - 1] R[4 - 4] =  p[3] + R[0] = 9; priceNow = 9

        [i = 5, j = 1] : p[1 - 1] R[5 - 1] =  p[0] + R[4] = 11; priceNow = 11
        [i = 5, j = 2] : p[2 - 1] R[5 - 2] =  p[1] + R[3] = 13; priceNow = 13
        [i = 5, j = 3] : p[3 - 1] R[5 - 3] =  p[2] + R[2] = 13; priceNow = 13
        [i = 5, j = 4] : p[4 - 1] R[5 - 4] =  p[3] + R[1] = 10; priceNow = 10
        [i = 5, j = 5] : p[5 - 1] R[5 - 5] =  p[4] + R[0] = 10; priceNow = 10

        [i = 6, j = 1] : p[1 - 1] R[6 - 1] =  p[0] + R[5] = 14; priceNow = 14
        [i = 6, j = 2] : p[2 - 1] R[6 - 2] =  p[1] + R[4] = 15; priceNow = 15
        [i = 6, j = 3] : p[3 - 1] R[6 - 3] =  p[2] + R[3] = 16; priceNow = 16
        [i = 6, j = 4] : p[4 - 1] R[6 - 4] =  p[3] + R[2] = 14; priceNow = 14
        [i = 6, j = 5] : p[5 - 1] R[6 - 5] =  p[4] + R[1] = 11; priceNow = 11
        [i = 6, j = 6] : p[6 - 1] R[6 - 6] =  p[5] + R[0] = 17; priceNow = 17

        [i = 7, j = 1] : p[1 - 1] R[7 - 1] =  p[0] + R[6] = 18; priceNow = 18
        [i = 7, j = 2] : p[2 - 1] R[7 - 2] =  p[1] + R[5] = 18; priceNow = 18
        [i = 7, j = 3] : p[3 - 1] R[7 - 3] =  p[2] + R[4] = 18; priceNow = 18
        [i = 7, j = 4] : p[4 - 1] R[7 - 4] =  p[3] + R[3] = 17; priceNow = 17
        [i = 7, j = 5] : p[5 - 1] R[7 - 5] =  p[4] + R[2] = 15; priceNow = 15
        [i = 7, j = 6] : p[6 - 1] R[7 - 6] =  p[5] + R[1] = 18; priceNow = 18
        [i = 7, j = 7] : p[7 - 1] R[7 - 7] =  p[6] + R[0] = 17; priceNow = 17

        [i = 8, j = 1] : p[1 - 1] R[8 - 1] =  p[0] + R[7] = 19; priceNow = 19
        [i = 8, j = 2] : p[2 - 1] R[8 - 2] =  p[1] + R[6] = 22; priceNow = 22
        [i = 8, j = 3] : p[3 - 1] R[8 - 3] =  p[2] + R[5] = 21; priceNow = 21
        [i = 8, j = 4] : p[4 - 1] R[8 - 4] =  p[3] + R[4] = 19; priceNow = 19
        [i = 8, j = 5] : p[5 - 1] R[8 - 5] =  p[4] + R[3] = 18; priceNow = 18
        [i = 8, j = 6] : p[6 - 1] R[8 - 6] =  p[5] + R[2] = 22; priceNow = 22
        [i = 8, j = 7] : p[7 - 1] R[8 - 7] =  p[6] + R[1] = 18; priceNow = 18
        [i = 8, j = 8] : p[8 - 1] R[8 - 8] =  p[7] + R[0] = 20; priceNow = 20

 - 2
 - 6

Results - [0,1,5,8,10,13,17,18,22,]

        Ref - cutrod.pdf | (https://web.stanford.edu/class/archive/cs/cs161/cs161.1168/lecture12.pdf)
        */

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