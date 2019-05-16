package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/14 10:53
 */
public class A51N皇后 {

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return null;
        List<List<String>> res = new ArrayList<List<String>>();
        int[] queen = new int[n];
        BackTrack(res, queen, 0);
        return res;
    }

    public void BackTrack(List<List<String>> res, int[] queen, int pos) {
        if (pos == queen.length) {
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < queen.length; i++) {
                StringBuilder sb = addPoint(queen.length);
                sb.setCharAt(queen[i], 'Q');
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < queen.length; i++) {
            queen[pos] = i;
            if (isValid(queen, pos)) {
                BackTrack(res, queen, pos + 1);
            }
        }
    }

    public boolean isValid(int[] queen, int pos) {
        for (int i = 0; i < pos; i++) {
            if (queen[i] == queen[pos]) return false;
            if (Math.abs(queen[pos] - queen[i]) == Math.abs(i - pos)) return false;
        }
        return true;
    }

    public StringBuilder addPoint(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append('.');
        return sb;
    }

    public static void main(String... args) {

        A51N皇后 a51 = new A51N皇后();
        List<List<String>> results = a51.solveNQueens(4);

        System.out.println("end");

    }
}
