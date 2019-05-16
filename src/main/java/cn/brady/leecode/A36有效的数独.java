package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/21 10:32
 */
public class A36有效的数独 {

    boolean canPut(char[][] board, int i, int j, char v) {
        for (int k = 0; k < 9; k++) {
            boolean isRow = board[i][k] == v;
            boolean isColumn = board[k][j] == v;
            boolean isCube = board[i / 3 * 3 + k % 3][j / 3 * 3 + k / 3] == v;

            if(isRow||isColumn||isCube) return false;

        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    char t = board[i][j];
                    board[i][j] = '.';
                    if (!canPut(board, i, j, t))
                        return false;
                    board[i][j] = t;
                }
            }
        }
        return true;
    }


    public static void main(String... args) {


        char[][] b = new char[100][100];

        b[1][3] = 'a';

        for (int k = 0; k < 9; k++) {

            System.out.println("i: " + (1 / 3 * 3 + k % 3) + " , j: " + (3 / 3 * 3 + k / 3));
        }


        System.out.println(1 % 3);

    }

}
