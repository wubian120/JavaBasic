package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/3/31 18:21
 */
public class A155最小栈_self {

    private final static int DEFAULT_SIZE = 1000;
    private int[] stack;
    private int[] minIndex;
    private int min = Integer.MAX_VALUE;
    private int index = -1;
    private int current = -1;


    public A155最小栈_self() {
        stack = new int[DEFAULT_SIZE];
        minIndex = new int[DEFAULT_SIZE];
    }

    public A155最小栈_self(int size) {
        stack = new int[size];
        minIndex = new int[size];
    }

    public void push(int value) {
        current++;
        int len = stack.length;
        if (current > len) {
            //需要扩容
            int[] tmp = new int[len * 2];
            System.arraycopy(stack, 0, tmp, 0, len);
            stack = tmp;

            tmp = new int[current * 2];
            System.arraycopy(minIndex, 0, tmp, 0, minIndex.length);
            minIndex = tmp;
        }

        stack[current] = value;
        if (value < min) {
            min = value;
            index = current;
        }
        minIndex[current] = index;

    }

    public void pop(){

        current--;
        if(current>=0){
//            min =
        }



    }

}
