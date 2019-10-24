class QuickSort{

    static int arr[] = {14, 5, 87, 12, 7, 2, 26, 9, 3};
    public static void main(String[] args) {
        qsort(0, arr.length - 1);
        printArr();
    }

    
    public static void qsort(int start, int end){

        if(start > end || start == end || start < 0) return;

        int ptr = start-1;
        int mid = (start + end) / 2;
        int pivot = arr[mid];

        swap(mid, end);

        for(int i = start; i < end; i++){
            if(arr[i] <= pivot)
                swap(++ptr, i);
        }

        swap(end, ++ptr);

        qsort(start, ptr-1);
        qsort(ptr+1, end);

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