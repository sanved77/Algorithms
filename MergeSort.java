class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 32, 4, 7, 27, 86, 100, 18 };
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    public static void mergeSort(int[] arr) {
        int len = arr.length;

        if (len < 2)
            return;

        int mid = len / 2;

        int[] left = new int[mid];
        int[] right = new int[len - mid];

        for (int i = 0; i < mid; i++)
            left[i] = arr[i];

        for (int i = mid; i < len; i++)
            right[i - mid] = arr[i];

        mergeSort(left);
        mergeSort(right);

        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int ls = left.length, rs = right.length;
        int lp = 0, rp = 0, ap = 0;

        while (lp < ls && rp < rs) {
            arr[ap++] = (left[lp] < right[rp]) ? left[lp++] : right[rp++];
        }

        while (lp < ls)
            arr[ap++] = left[lp++];

        while (rp < rs)
            arr[ap++] = right[rp++];
    }
}