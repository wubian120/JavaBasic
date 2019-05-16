package cn.brady.leecode;

import java.util.Arrays;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/1 20:40
 */
public class A155最小栈_one {

    /**
     * beat 59%
     */
    private int[] z;
    private int[] y;
    private int k;
    private int size;
    /** initialize your data structure here. */
    public A155最小栈_one() {
        size=64;
        z=new int[size];
        y=new int[size];
        k=0;
    }

    public void push(int x) {
        if(k==0){
            z[0]=0;
            y[0]=x;
            k++;
            return;
        }
        y[k]=x;
        if(x<y[z[k-1]]){
            z[k]=k;
        }else{
            z[k]=z[k-1];
        }
        k++;
        if(k>size/2){
            size*=2;
            z=Arrays.copyOf(z,size);
            y=Arrays.copyOf(y,size);
        }
    }

    public void pop() {
        k--;
    }

    public int top() {
        return y[k-1];
    }

    public int getMin() {
        return y[z[k-1]];
    }
}
