import java.util.Arrays;
import java.util.Collections;

class CountSort {
    
    static int arr[] = {14, 14, 5, 87, 5, 12, 7, 12, 2, 26, 14, 9, 3};
    public static void main(String[] args) {
        int max = -1;

        for(int a : arr){
            if(max < a) max = a;
        }
        
        int[] buckets = new int[max+1];

        for(int a : arr){
            buckets[a]++;
        }
        
        int[] sortedArr = new int[arr.length];
        int arrPtr = 0;

        for(int i = 0; i < max+1; i++){
            if(buckets[i] != 0){
                while(buckets[i] != 0){
                    sortedArr[arrPtr++] = i; 
                    buckets[i]--;
                }
            }
        }

        for(int a : sortedArr){
            System.out.print(" - " + a);
        }

        System.out.println();

    }
}
