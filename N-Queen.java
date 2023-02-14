class Solution {

    public boolean isSafe(int row,int col,char[][] board){
        //horizontally  row-same, col -> 0 to len
        for(int j = 0;j<board.length;j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }
        //vertically col-same, row -> 0 to len
        for(int i = 0;i < board[0].length;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //upper left
        int r = row;
        for(int c = col;c>=0 && r>=0;c--,r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //upper right
        r = row;
        for(int c = col;c<board[0].length && r>=0;c++,r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //lower left row++ col--
        r = row;
        for(int c = col;c>=0 && r<board.length;c--,r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        
        r = row;
        //lower right row++ col++
        for(int c = col;r<board.length && c<board[0].length;c++,r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public void saveBoard(List<List<String>> allBoard,char[][] board){
        String res = "";
        ArrayList<String> newBoard = new ArrayList<>();
        for(int i = 0;i<board.length;i++){
            res = "";
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j] == 'Q'){
                    res+='Q';
                }
                else{
                    res+='.';
                }
            }
            newBoard.add(res);
        }
        allBoard.add(newBoard);
    }

    public void helper(List<List<String>> allBoard,char[][] board,int col){
        if(col == board.length){
            saveBoard(allBoard,board);
            return;
        }

        for(int row = 0;row<board.length;row++){
            if(isSafe(row,col,board)){
                board[row][col] = 'Q';
                helper(allBoard,board,col+1);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoard = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(allBoard,board,0);
        return allBoard;
        
    }
}
