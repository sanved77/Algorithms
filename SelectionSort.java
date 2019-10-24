class SelectionSort{

    /**
     * Selection Sort
     * Basically runs n^2 times. Outside loop sets a position to fill in the elements and the inside one finds the smallest of the remaning array.
     * The smallest element found is then put in the position set by the outside loop
     */

    // static int arr[] = {14, 5, 87, 12, 7, 2, 26, 9, 3};
    static int arr[] = {6,5,5,3,2,1,1};

    public static void main(String[] args) {
       
        for(int i= 0; i < arr.length; i++){
            int low = i;
            for(int j= i; j < arr.length; j++){
                if(arr[low] >= arr[j]){
                    low = j;
                }
            }
            if(low != -1){
                swap(low, i);
            }
        }

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