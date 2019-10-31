class RadixSort {

    /**
     * Radix sort with Counting Sort
     * 
     */
    
    static int arr[] = {14, 5, 87, 12, 306, 7, 2, 26, 505, 9, 3}; 
    public static void main(String[] args) {

        int max = -1;
        for(int a : arr){
            if(max < a) max = a;
        }
        int numberOfDigits = 0;
        for(int temp = max; temp != 0;temp/=10, numberOfDigits++);

        int placePtr = 1;
        while(numberOfDigits > 0){

            int frequency[] = new int[10];
            for(int ele : arr){
                int posi = (ele/placePtr) % 10;
                frequency[posi]++;
            }
            
            for(int i = 1; i < 10; i++){
                frequency[i] += frequency[i-1];
            }
            
            int sortedArr[] = new int[arr.length];
            for(int i = arr.length - 1; i >=0; i--){
                int posi = (arr[i]/placePtr) % 10;
                sortedArr[frequency[posi] - 1] = arr[i];
                frequency[posi]--;
            }

            arr = sortedArr;

            numberOfDigits--;
            placePtr *= 10;
        }

        printArr();

    }

    public static void printArr(){
        for(int a : arr){
            System.out.print(" - " + a);
        }
    }

}