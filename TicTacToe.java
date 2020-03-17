class TicTacToe {
    
    int[] rowg;
    int[] colg;
    int diag1 = 0;
    int diag2 = 0;
    
    int n;
    
    public TicTacToe(int n) {
        rowg = new int[n];
        colg = new int[n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        
        rowg[row] = (player == 1) ? rowg[row] + 1 : rowg[row] - 1;
        colg[col] = (player == 1) ? colg[col] + 1 : colg[col] - 1;
        if(row == col) diag1 = (player == 1) ? diag1 + 1 : diag1 - 1;
        if(row + col == n-1) diag2 = (player == 1) ? diag2 + 1 : diag2 - 1;
        
        if(rowg[row] == n) return 1;
        if(rowg[row] == -n) return 2;
        
        if(colg[col] == n) return 1;
        if(colg[col] == -n) return 2;
        
        if(diag1 == n) return 1;
        if(diag1 == -n) return 2;
        
        if(diag2 == n) return 1;
        if(diag2 == -n) return 2;
        
        
        return 0;
    }
}
