package cn.brady.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/14 11:09
 */
public class A51_self {

    public List<List<String>> solveNQueens(int n){
        if(n<=0) return null;
        List<List<String>> results = new ArrayList<>();
        int[] queen = new int[n];
        BackTrack(results,queen,0);
        return results;

    }

    public void BackTrack(List<List<String>> results, int[] queen, int pos){
        if(pos == queen.length){
            List<String> temp = new LinkedList<>();
            for(int i=0;i<queen.length;i++){
                StringBuilder builder = addPoint(queen.length);
                builder.setCharAt(queen[i], 'Q');
                temp.add(builder.toString());
            }
            results.add(temp);
            return;
        }
        for(int i=0;i<queen.length;i++){
            // pos 行 放在i 位置
            queen[pos] =i;
            if(isValid(queen,pos)){
                BackTrack(results,queen,pos+1);
            }
        }
    }

    public boolean isValid(int[] queen, int pos){
        for(int i=0;i<pos;i++){
            //同行
            if(queen[i] == queen[pos])return false;
            //对角线
            if(Math.abs(queen[pos]-queen[i]) == Math.abs(pos-i)) return false;
        }
        return true;
    }

    public StringBuilder addPoint(int n){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<n;i++){
            builder.append(".");
        }
        return builder;
    }
}
