package cn.brady.leecode;

/**
 * @description:
 *
 * @beat   99%
 * @auther: bian.wu
 * @date: 2019/4/21 12:18
 */
public class A37解数独 {
    public static void solveSudoku(char[][] board) {
        int len = 9;
        boolean[][] row = new boolean[len][len],
                col = new boolean[len][len],
                box = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                char c;
                if ((c = board[i][j]) != '.') {
                    int num = c-'1';
                    row[i][num] = col[j][num] = box[i/3*3+j/3][num] = true;
                }
            }
        }

        solve(board, row, col, box, 0, 0);
    }

    private static boolean solve(char[][] board, boolean[][] row,
                                 boolean[][] col, boolean[][] box, int i, int j) {
        if (i == 8 && j == 9) return true;
        if (j == 9) {
            ++i;
            j = 0;
        }

        if (board[i][j] != '.')
            return solve(board, row, col, box, i, j+1);

        for (int k = 0; k < 9; k++) {
            if (!row[i][k] && !col[j][k] && !box[i/3*3+j/3][k]) {
                board[i][j] = (char) (k + '1');
                row[i][k] = col[j][k] = box[i/3*3+j/3][k] = true;
                if (solve(board, row, col, box, i, j+1)) {
                    return true;
                }
                board[i][j] = '.';
                row[i][k] = col[j][k] = box[i/3*3+j/3][k] = false;
            }
        }
        return false;
    }
}
