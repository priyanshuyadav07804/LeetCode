class Solution {
    public boolean isSafe(char[][] board,int row,int col,int number){
        //for horizontal and vertical
        for(int i = 0;i<board.length;i++){
            if(board[i][col] == (char)(number+'0')){
                return false;
            }
            if(board[row][i] == (char)(number+'0')){
                return false;
            }
        }
        //for condition 3 -> grid
        int nr = (row/3)*3;
        int nc = (col/3)*3;
        //3X3 me hi to search krna h na
        for(int i = nr;i<nr+3;i++){
            for(int j = nc;j<nc+3;j++){
                if(board[i][j] == (char)(number+'0')){
                    return false;
                }
            }
        }

        //atlast
        return true;
    }
    public boolean helper(char[][] board,int row,int col){
        //base condition
        if(row == board.length){
            return true;
        }

        int nrow = 0;
        int ncol = 0;

        //agar bich me h to nrow = same,ncol = col+1
        if(col != board.length-1){
            nrow = row;
            ncol = col+1;
        }
        else{    //agar last column me h to
            nrow = row+1;
            ncol = 0;
        }

        //kya number already hai
        if(board[row][col] != '.'){
            if(helper(board,nrow,ncol)){                    //if yes then agle row and col pr chale jao
                return true;
            }
        }else{                                              //koi number nhi hai => khali hai
            for(int i = 1;i<=9;i++){                        //1 se 9 tk number dalo
                if(isSafe(board,row,col,i)){                //kya safe h number dalna
                    board[row][col] = (char)(i+'0');        //if yes => daldo
                    if(helper(board,nrow,ncol)){            //check for next row and col
                        return true;                        //if true => return true;
                    }
                    else{
                        board[row][col] = '.';              //backtrack me khali kr do
                    }
                }
                
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
        
    }
}
