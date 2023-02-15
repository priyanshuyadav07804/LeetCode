class Solution {
    public boolean isSafe(int row,int col,char[][] board){
        //horizontally row = same,col = 0 to len
        for(int c = 0;c<board.length;c++){
            if(board[row][c] == 'Q'){
                return false;
            }
        }

        //vertically row = 0 to len, col = same
        for(int r = 0;r<board.length;r++){
            if(board[r][col] == 'Q'){
                return false;
            }
        }

        //upper left r--, c--
        int r= row;
        for(int c = col;c>=0 && r>=0;c--,r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        //upper right r--,c++
        r = row;
        for(int c = col;c<board.length && r>= 0; c++,r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //lower left => r++,c--
        r = row;
        for(int c= col;c>=0 && r<board.length;c--,r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //lower right -> c++,r++
        r = row;
        for(int c = col;c<board.length && r<board.length; c++,r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public int helper(char[][] board,int col){
        if(col == board.length){
            return 1;
        }
        int c = 0;
        for(int row = 0;row<board.length;row++){
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                c+=helper(board,col+1);
                board[row][col] = '.';
            }
        }
        return c;
    }
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];

        return helper(board,0);
    }
}
