class BubbleSort{

    static int arr[] = {14, 5, 87, 12, 7, 2, 26, 9, 3};

    public static void main(String[] args) {

        int count = 0;
        
        for(int i = 0 ; i < arr.length; i++){
            boolean swapped = false;
            for(int j = 0 ; j < arr.length-1; j++){
                count++;
                if(arr[j] > arr[j+1]){
                    swap(j,j+1);
                    swapped = true;
                }
            }
            if(swapped) break;
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