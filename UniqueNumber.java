import java.util.HashMap;

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
     * 
     * The other implemention uses a Hashtable with Counting Sort. 
     * The number is the key for the hast table and every time a number is found, the hash table entry is incremented.
     * The entire array is traversed and the hash table is filled in a manner of a set. 
     * Once that is done, the hashtable is looked up using all the elements from the array and the one with the value is chosen.
     */

    static int arr[] = {2,1,5,2,7,1,9,8,7,8,9};

    public static void main(String[] args) {

        System.out.println("Unique Number - " + findUniqueXOR());
        System.out.println("Unique Number - " + findUniqueHash());

    }

    public static int findUniqueXOR(){
        int xorres = arr[0] ^ arr[1];

        for(int i = 2 ; i < arr.length; i++){
            xorres = xorres ^ arr[i];
        }

        return xorres;
    } 

    public static int findUniqueHash(){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int a : arr){
            if(map.get(a) == null){
                map.put(a, 1);
            }else{
                map.put(a, map.get(a) + 1);
            }
        }

        for(int a : arr){
            if(map.get(a) == 1){
                return a;
            }
        }

        return 999;
    }

}