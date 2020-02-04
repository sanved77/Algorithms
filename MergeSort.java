class MergeSort{

    /**
     * Merge Sort 
     */

    static int arr[] = {14, 5, 87, 12, 7, 2, 26, 9, 3};
    // static int arr[] = {6,5,5,3,2,1,1};
    
    public static void main(String[] args) {

        int count = 0;
        
        mergeSort(arr, 0, arr.length - 1);
        printArr();

    }

    public static void mergeSort(int[] arr, int left, int right){

        if(left >= right)
            return;

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);

        merge(arr, left, mid, right);
    }
    
    public static void merge(int[] arr, int left, int mid, int right){

        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        for(int i = 0; i < leftArr.length; i++){
            leftArr[i] = arr[left + i];
        }

        for(int i = 0; i < rightArr.length; i++){
            rightArr[i] = arr[(mid + 1) + i];
        }

        int arrPtr = left;
        int lPtr = 0;
        int rPtr = 0;

        while(lPtr < leftArr.length && rPtr < rightArr.length){
            arr[arrPtr++] = (leftArr[lPtr] < rightArr[rPtr]) ? leftArr[lPtr++] : rightArr[rPtr++] ;
        }

        while(lPtr < leftArr.length)
            arr[arrPtr++] = leftArr[lPtr++];
        
        while(rPtr < rightArr.length)
            arr[arrPtr++] = rightArr[rPtr++];
            
    }

    public static void printArr(){
        for(int a : arr){
            System.out.print(" - " + a);
        }
        System.out.println();
    }

}