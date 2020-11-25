class QuickSort {

    /**
     * QuickSort Take the mid element as pivot and then compare every other number
     * to it All the number lower than the pivot go to the left of the pivot and the
     * larger go to the right. Keep the pivot as it is and do the same procedure on
     * the newly formed two arrays.
     */

    public static void main(String[] args) {
        int arr[] = { 14, 5, 87, 12, 7, 2, 26, 9, 3 };
        qsort(arr, 0, arr.length - 1);
        for (int a : arr)
            System.out.print(" - " + a);
    }

    public static void qsort(int[] arr, int begin, int end) {
        if (begin < end) {

            int partitionIdx = partition(arr, begin, end);

            qsort(arr, begin, partitionIdx - 1);
            qsort(arr, partitionIdx + 1, end);

        }
    }

    public static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int ptr = begin - 1;

        for (int i = begin; i < end; i++) {
            if (arr[i] <= pivot) {
                ptr++;
                int temp = arr[ptr];
                arr[ptr] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[ptr + 1];
        arr[ptr + 1] = arr[end];
        arr[end] = temp;

        return ptr + 1;
    }
}