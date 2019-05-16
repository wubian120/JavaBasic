package cn.brady.leecode;

/**
 * @description:
 *
 * @beat     80%
 * @auther: bian.wu
 * @date: 2019/4/22 10:18
 */
public class A37解数独two {

    boolean[][] row = new boolean[9][10];
    boolean[][] col = new boolean[9][10];
    boolean[][] block = new boolean[9][10];

    public void solveSudoku(char[][] board) {
        for(int i =0; i <9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j]!='.'){
                    row[i][board[i][j]-'0'] = true;
                    col[j][board[i][j]-'0'] = true;
                    block[i/3*3+j/3][board[i][j]-'0'] = true;
                }
            }
        }

        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int i, int j){
        if(i == 9){
            return true;
        }

        if(j == 9){
            return solve(board, i+1, 0);
        }

        if(board[i][j] != '.'){
            return solve(board, i, j+1);
        }

        for(int k = 1; k<=9; k++){
            if(row[i][k]==false && col[j][k]==false && block[i/3*3+j/3][k]==false){

                board[i][j] = (char)('0'+k);

                row[i][k] = col[j][k] = block[i/3*3+j/3][k] = true;

                if(solve(board, i, j+1)){
                    return true;
                }

                board[i][j] = '.';
                row[i][k] = col[j][k] = block[i/3*3+j/3][k] = false;
            }
        }

        return false;
    }
}
