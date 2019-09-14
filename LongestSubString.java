import java.util.Stack;

class LongestSubString {

    public static void main(String[] args) {
        
        String str1,str2;
        str1 = "EABBEEF";
        // str1 = "ABCDGH";
        // str2 = "AEDFHR";
        str2 = "BEEFDEAD";

        int n = str1.length();
        int m = str2.length();

        int mat[][] = new int[n+1][m+1];

        for(int i = 0; i <= n; i++){
            mat[i][0] = 0;
        }

        for(int i = 0; i <= m; i++){
            mat[0][i] = 0;
        }

        int max = -1, posI = -1 ,posJ = -1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    mat[i][j] = mat[i-1][j-1] + 1;
                    if(mat[i][j] > max){
                        max = mat[i][j];
                        posI = i;
                        posJ = j;
                    }
                }else {
                    mat[i][j] = 0;
                }

            }
        }

        for(int i = 0 ; i <= n; i++){
            for(int j = 0; j <= m; j++){
                System.out.print(mat[i][j] + " |");
            }
            System.out.println("");
        }

        Stack<Character> stack = new Stack<>();

        while(true){
            if(mat[posI][posJ] == 0){
                break;
            }else{
                stack.push(str1.charAt(posI -1));
                posI--;
                posJ--;
            }
        }

        System.out.println("\n----- Longest SubString ----- \n");
        while(!stack.isEmpty()){
            System.out.print("" + stack.pop());
        }

    }

}