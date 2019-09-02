class SellStock {

    public static void main(String ag[]){

        // int[] prices = {7,6,5,1,3,10,4};
        int[] prices = {7,1,5,3,6,4};
        int R[] = new int[prices.length];

        int minVal = prices[0];
        int buyAt = -1, sellAt = -1;
        R[0] = 0;

        for(int i = 1 ; i < prices.length; i++){
            minVal = Math.min(prices[i], minVal);
            R[i] = Math.max(R[i-1], prices[i] - minVal);
        }

        for(int a : R){
            System.out.println(" - " + a);
        }

        for(int i = prices.length - 1; i >= 0; i--){
            if(prices[i] > R[prices.length-1]){
                sellAt = prices[i];
                buyAt = prices[i] - R[prices.length - 1];
                break;
            }
        }

        System.out.println("Buy At - " + buyAt);
        System.out.println("Sell At - " + sellAt);

    }

}