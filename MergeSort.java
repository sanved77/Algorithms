class MergeSort{

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
        
        mergeSort(arr, 0, arr.length - 1);
        printArr();

    }

    public static void mergeSort(int[] arr, int left, int right){

        if(left >= right){
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);

    }

    public static void merge(int arr[], int left, int mid, int right){

        int leftArr[] = new int[mid - left + 1];
        int rightArr[] = new int[right - mid];

        for(int i = 0; i < (mid - left + 1); i++){
            leftArr[i] = arr[left + i];
        }

        for(int i = 0; i < (right - mid); i++){
            rightArr[i] = arr[mid + i + 1];
        }

        int arrPtr = left;

        int lPtr = 0;
        int rPtr = 0;

        while(lPtr < leftArr.length && rPtr < rightArr.length){

            if(leftArr[lPtr] < rightArr[rPtr]){
                arr[arrPtr++] = leftArr[lPtr++];
            } else {
                arr[arrPtr++] = rightArr[rPtr++];
            }
            
        }
        
        while(lPtr < leftArr.length){
            arr[arrPtr++] = leftArr[lPtr++];
        }
        while(rPtr < rightArr.length){
            arr[arrPtr++] = rightArr[rPtr++];
        }
        
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
        System.out.println();
    }

}