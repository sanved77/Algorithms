class Stairs {

    public static void main(String ag[]){
        
        int a[] = new int[50];

        final int k = 3;

        for(int i = 1 ; i <= k ; i++){
            a[i] = (int) Math.pow((double) 2, (double)(i-1));
        }

        for(int i = k+1; i <= 10; i++){
            for(int j = 1 ; j <= k; j++){
                a[i] += a[i-j];
            }
        }

        for(int b : a){
            System.out.println("" + b);
        }

    } 

}