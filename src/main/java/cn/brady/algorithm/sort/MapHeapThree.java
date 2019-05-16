package cn.brady.algorithm.sort;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2018/12/17 10:31
 */
public class MapHeapThree {
    private int[] data = new int[20];
    private int size;

    public int size() {
        return size;
    }

    public void insert(int val) {
        if (size + 1 > data.length) {
            int[] newData = new int[size * 2 + 1];
            System.arraycopy(data,0,newData,0,size+1);
            data = newData;
        }
        data[++size] = val;

    }

    private void shiftUp(int k){
        while(k>1 && data[k/2] < data[k]){
            swap(data, k/2, k);
            k /= 2;
        }
    }

    private void swap(int[] d,int f, int t){
        int v = d[f];
        d[f] = d[t];
        d[t] = v;
    }

    public static void main(String...args){
        MapHeapThree mht = new MapHeapThree();
        int[] t = {3,4,8,9,12,90,10,2,19};
        for(int i: t){
            mht.insert(i);
        }

        System.out.println(mht.size);

    }
}
