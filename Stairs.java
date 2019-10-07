class Stairs {

    /*

    Climbing Stairs problem.
    - Given - A person can climb stairs either 1 step at a time or two steps or 'k' number of steps.
    - To find out how many ways there are to reach to a given step. 

    @Recursive - a[i] += a[i-j]; 
    where : i goes {k+1 to n}
          : j goes {1 to k}

    Example - (k = 2)

        a[1] = 2^(i-1) = 2^(1-1) = 2^0 = 1
        a[] = {0,1}
        a[2] = 2^(i-1) = 2^(2-1) = 2^1 = 2
        a[] = {0,1,2}

        a[3] = a[3] + a[3-1] = a[3] + a[2] = 0 + 2 = 2
        a[3] = a[3] + a[3-2] = a[3] + a[1] = 2 + 1 = 3
        a[] = {0,1,2,3}
        
        a[4] = a[4] + a[4-1] = a[4] + a[3] = 0 + 3 = 3 
        a[4] = a[4] + a[4-2] = a[4] + a[2] = 3 + 2 = 5 
        a[] = {0,1,2,3,5}

        a[5] = a[5] + a[5-1] = a[5] + a[4] = 0 + 5 = 5 
        a[5] = a[5] + a[5-2] = a[5] + a[3] = 5 + 3 = 8 
        a[] = {0,1,2,3,5,8}

        and so on
        
    
    */

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