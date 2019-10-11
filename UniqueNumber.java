class UniqueNumber {

    /**
     * Unique Number problem
     * - Given a set of (n) numbers in which (n-1) numbers are inserted (k) times (k > 1). 1 number is inserted only once. 
     * - To find the unique number which is inserted only once.
     * 
     * Bitwise XORing works - 
     * 0  0 - 0
     * 0  1 - 1
     * 0  1 - 1
     * 1  1 - 0
     * 
     * Here if the number is same, the result of XORing will be 0. And XORing is commutative, meaning that a ^ b = a ^ b. 
     * Thus in a given sequence, the (n-1) numbers will together come up with the result 0. 
     * And the unique number has nothing to nullify itself with and hence it remains as it
     * 
     * Runs in O(n) hence.
     */

    public static void main(String[] args) {
        
        int arr[] = {2,1,5,2,7,1,9,8,7,8,9};
        int xorres = arr[0] ^ arr[1];

        for(int i = 2 ; i < arr.length; i++){
            xorres = xorres ^ arr[i];
        }

        System.out.println("Unique Number - " + xorres);

    }

}