import java.util.Arrays;

class Knapsack {

    public static void main(String[] args) {
        
        // int itemWeights[] = {2,5,8};
        int itemWeights[] = {1,3,4,5};

        // int itemBenefit[] = {10,12,21};
        int itemBenefit[] = {1,4,5,7};

        final int C = 7;

        int B[][] = new int[itemWeights.length+1][C+1];

        for(int i = 0 ; i <= C;i++){
            B[0][i] = 0;
        }

        for(int k = 1; k <= itemWeights.length; k++){

            B[k][0] = 0;
            for(int w = 1; w <= C; w++){
                if(itemWeights[k-1] <= w 
                    && ((B[k-1][w-itemWeights[k-1]] + itemBenefit[k-1]) > B[k-1][w])){
                    B[k][w] = B[k-1][w-itemWeights[k-1]] + itemBenefit[k-1];
                }else{
                    B[k][w] = B[k-1][w];
                }
            }

        }

        for(int i = 0; i <= itemWeights.length; i++){
            for(int j = 0 ; j <= C; j++){
                if(B[i][j] == 0) System.out.print(" ");
                System.out.print(B[i][j] + "|");
            }
            System.out.println("");
        }

        int result = B[itemWeights.length][C];
        for(int i = itemWeights.length; i > 0; i--){
            if(B[i-1][C] < result){
                System.out.println("Item - " + i);
                result -= itemBenefit[i];
            }
        }
    }

}