class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<>();
        for(int row=0;row<9;row++) {
            for(int col=0;col<9;col++) {
                char c = board[row][col];
                if(c!='.' ) {
                    if(!set.contains(c)) {
                        set.add(c);
                    }else{
                        return false;
                    }
                }
            }
            set.clear();
        }
        
        for(int col =0;col<9;col++) {
            for(int row=0;row<9;row++) {
                char c = board[row][col];
                if(c!='.' ) {
                    if(!set.contains(c)) {
                        set.add(c);
                    }else{
                        return false;
                    }
                }
            }
            set.clear();
        }

       

        for(int row=0;row<9;row+=3) {
            for(int col=0;col<9;col+=3) {
                set.clear();

                for(int i=0;i<3;i++) {
                    for(int j=0;j<3;j++) {
                        char c = board[row+i][col+j];
                        if(c!='.') {
                            if(!set.contains(c)) {
                                set.add(c);
                            }else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;


    }
}
