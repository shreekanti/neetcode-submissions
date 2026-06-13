class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) {
            Arrays.fill(board[i],'.');
        }
        int[] leftRow  = new int[n];
        int[] lowerDia = new int[2*n-1];
        int[] upperDia = new int[2*n-1];
        int[] res = new int[1];
        res[0]=0;
        f(0, n , board, leftRow, upperDia, lowerDia, res);
        return res[0];
    }

    public void f(int col, int n, char[][] board, int[] leftRow, int[] upperDia,int[] lowerDia, int[] res) {
        if(col==n) {
            res[0]++;
            return;
        }

        for(int row=0;row<n;row++) {
            if(leftRow[row] ==0 && upperDia[col+row]==0 && lowerDia[n-1+col-row]==0) {
                leftRow[row]=1;
                upperDia[col+row] =1;
                lowerDia[n-1+col-row]=1;
                board[row][col] = 'Q';
                f(col+1,n, board, leftRow, upperDia, lowerDia, res);
                leftRow[row]=0;
                upperDia[col+row] =0;
                lowerDia[n-1+col-row]=0;
                board[row][col] = '.';
            }
        }
    }
    
}