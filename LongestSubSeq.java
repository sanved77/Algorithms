class LongestSubSeq{

    public static void main(String[] args) {
        
        String str1,str2;
        str1 = "ABAC";
        // str1 = "ABCDGH";
        // str2 = "AEDFHR";
        str2 = "BDAB";

        int n = str1.length();
        int m = str2.length();

        int mat[][] = new int[n+1][m+1];
        char arrows[][] = new char[n+1][m+1];

        for(int i = 0; i <= n; i++){
            mat[i][0] = 0;
        }

        for(int i = 0; i <= m; i++){
            mat[0][i] = 0;
        }

        for(int i = 1 ; i <= n; i++){
            for(int j = 1; j <= m; j++){

                if(str2.charAt(i-1) == str1.charAt(j-1)){
                    arrows[i][j] = 'D';
                    mat[i][j] = mat[i-1][j-1] + 1;
                }else{
                    if(mat[i-1][j] == mat[i][j-1]){
                        mat[i][j] = mat[i][j-1];
                        arrows[i][j] = 'U';
                    }else{
                        if(mat[i-1][j] > mat[i][j-1]){
                            mat[i][j] = mat[i-1][j];
                            arrows[i][j] = 'U';
                        }else{
                            mat[i][j] = mat[i][j-1];
                            arrows[i][j] = 'L';
                        }
                    }
                }

            }
        }

        for(int i = 0 ; i <= n; i++){
            for(int j = 0; j <= m; j++){
                System.out.print(mat[i][j] + " |");
            }
            System.out.println("");
        }

        System.out.println("-------------");

        for(int i = 0 ; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(arrows[i][j] == '\u0000') System.out.print("N |");
                else System.out.print(arrows[i][j] + " |");
            }
            System.out.println("");
        }

        System.out.println("---- Longest Sequence ----");

        findElements(n, m, arrows, str1);


        int len = mat[n][m];
        int count = 0;
        for(int k = 0 ; k <= n; k++){
            for(int l = 0; l <= m; l++){
                if(mat[k][l] == len && arrows[k][l] == 'D'){
                    System.out.println("---- Longest Sub sequence no. "+ (++count) + " ----");
                    findElements(k, l, arrows, str1);
                }
            }
        }
    }

    private static void findElements(int n, int m, char arrows[][], String str1){
        int i = n, j = m;
        char stack[] = new char[str1.length()];
        int stackPtr = -1;
        while(true){
            if(arrows[i][j] == '\u0000') break;
            else if(arrows[i][j] == 'D'){
                stack[++stackPtr] = str1.charAt(j-1);
                i--;
                j--;
            }else if(arrows[i][j] == 'L'){
                j--;
            }else if(arrows[i][j] == 'U'){
                i--;
            }
        }

        while(stackPtr != -1){
            System.out.println("- " + stack[stackPtr--]);
        }
    }

}