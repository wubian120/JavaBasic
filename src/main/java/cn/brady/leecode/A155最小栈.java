package cn.brady.leecode;

/**
 * @description: 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * @auther: bian.wu
 * @date: 2019/3/29 17:07
 */
public class A155最小栈 {


    /**
     * @beats 66%
     * @ref https://blog.csdn.net/DERRANTCM/article/details/47828195
     */
    private final static int DEFAULT_SIZE = 1000;
    private int[] stack;
    private int[] minIndex; // 用于保存前n个数据的栈中最小元素的下标
    private int min = Integer.MAX_VALUE; // 用于记录插入过程中的最小数据
    private int index = -1; // 记录最小元素在stack中的位置
    private int current = -1;

    public A155最小栈() {
        stack = new int[DEFAULT_SIZE];
        minIndex = new int[DEFAULT_SIZE];
    }

    public A155最小栈(int size) {
        stack = new int[size];
        minIndex = new int[size];
    }

    public void push(int x) {
        current++; // 移动到要插入的位置

        if (current >= stack.length) { // 扩容
            int[] tmp = new int[current * 2];
            System.arraycopy(stack, 0, tmp, 0, stack.length);
            stack = tmp;

            tmp = new int[current * 2];
            System.arraycopy(minIndex, 0, tmp, 0, minIndex.length);
            minIndex = tmp;
        }

        stack[current] = x; // 插入数据

        if (x < min) { // 保存插入的最小值
            min = x;
            index = current; // 记录[0, current]中最小的元素下标是index
        }

        minIndex[current] = index;
    }

    public void pop() {
        current--;
        if (current >= 0) {
            min = stack[minIndex[current]]; // 重新设置栈中的最小值
            index = minIndex[current]; // 重置最小值的索引
        }
    }

    public int top() {

        if (current < 0) {
            throw new RuntimeException("No more data");
        }

        return stack[current];
    }

    public int getMin() {
        if (current < 0) {
            throw new RuntimeException("No more data");
        }

        return stack[minIndex[current]];
    }


    public static void main(String... args) {

        A155最小栈 a155 = new A155最小栈();
        a155.push(11);
        a155.push(-2);
        a155.push(0);
        a155.push(-3);
        a155.push(2);
        a155.push(33);

        int min1 = a155.getMin();
        System.out.println("min: " + min1);
        a155.pop();
        int top = a155.top();
        System.out.println("top: " + top);
        min1 = a155.getMin();
        System.out.println("min: " + min1);

    }

}