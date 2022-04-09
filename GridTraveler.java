class GridTraveler {

    public static void main(String[] args) {
        System.out.println("2,3 - " + gridTraveler(2,3));
        System.out.println("4,3 - " + gridTraveler(4,3));
        System.out.println("3,4 - " + gridTraveler(3,4));
        System.out.println("4,5 - " + gridTraveler(4,5));
        System.out.println("18, 18 - " + gridTraveler(18,18));
    }

    public static long gridTraveler(int m, int n){
        long[][] res = new long[m][n];

        for(int i = 0; i < res.length; i++)
            res[i][0] = 1;

        for(int j = 0; j < res[0].length; j++)
            res[0][j] = 1;

        for(int i = 1; i < res.length; i++){
            for(int j = 1; j < res[0].length; j++){
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }

        return res[m-1][n-1];
    }

    public static int gridTravelerBranched(int m, int n) {
        if(m == 0 || n == 0) return 0;
        if(m == 1 && n == 1) return 1;

        return (gridTravelerBranched(m-1, n) + gridTravelerBranched(m, n-1));
    }
}

/**
 * Time complexity - O(mn)
 * Space complexity - O(mn)
 */