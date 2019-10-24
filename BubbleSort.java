class BubbleSort{

    /**
     * Classic Bubble sort 
     * 14, 5, 87, 12, 7, 2, 26, 9, 3
     * 14 is compared with 5, 5 is compared with 87, 87 with 12 and so on
     * 
     * An optimization is added to make sure that the extra iterations aren't taken. 
     * It is done using the swap variable
     */

    static int arr[] = {14, 5, 87, 12, 7, 2, 26, 9, 3};
    // static int arr[] = {6,5,5,3,2,1,1};
    
    public static void main(String[] args) {

        int count = 0;
        
        for(int i = 0 ; i < arr.length - 1; i++){
            boolean swapped = false;
            for(int j = 0 ; j < arr.length - 1; j++){
                count++;
                if(arr[j] > arr[j+1]){
                    swap(j,j+1);
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        System.out.println("" + count + "!\n");
        printArr();

    }

    public static void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(){
        for(int a : arr){
            System.out.print(" - " + a);
        }
    }

}