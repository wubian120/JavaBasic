package cn.brady.leecode;

import java.util.Arrays;

/**
 * @description:
 * @beat 98%
 * @auther: bian.wu
 * @date: 2019/4/3 16:40
 */
public class A155最小栈_three {

    private int[] data;
    private int count;
    private int len;
    private int min;

    public A155最小栈_three() {
        this.len = 10;
        this.data = new int[len];
    }

    public void push(int x) {
        if (count == 0) {
            addElement(x);
            min = x;
        } else if (x <= min) {
            addElement(min);
            min = x;
        }
        addElement(x);
    }

    private void addElement(int x) {
        if (count == len) {
            len = len + (len >> 1);
            data = Arrays.copyOf(data, len);
        }
        data[count++] = x;
    }

    public void pop() {
        if (count == 0) {
            return;
        }

        if (data[--count] == min) {
            min = data[--count];
        }
    }

    public int top() {
        if (count == 0) {
            throw new java.util.EmptyStackException();
        }
        return data[count - 1];
    }

    public int getMin() {
        return min;
    }


}
