class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        Set<int[]> set = new HashSet<>();

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(board[i][j]==word.charAt(0)) {
                    if(dfs(i,j,0,word,board)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int row, int col, int ind, String word, char[][] board) {
        if(ind==word.length()) {
            return true;
        }

        if(row<0 || row>=board.length || col<0 || col>= board[0].length ||
        board[row][col]!=word.charAt(ind))  {
            return false;
        }

        board[row][col] = '#';

        int[] dirr = {-1,0,1,0};
        int[] dirc = {0,1,0,-1};
        boolean res =false;

        for (int i=0;i<4;i++) {
            int nextr = row + dirr[i];
            int nextc = col + dirc[i];
             if(dfs(nextr,nextc,ind+1,word,board)) {
                board[row][col] = word.charAt(ind);
                return true;
             }
           
        }
        board[row][col] = word.charAt(ind);
        return false;
         
    }
}
