package cn.brady.algorithm.sort;

public abstract class  Sort<T> {


    protected abstract void sort (Comparable<T>[] array);

    protected boolean less(Comparable<T> a, Comparable<T> b){

        return a.compareTo( (T) b) < 0;

    }

    /***
     * exchange the element by giving index
     * @param array
     * @param i
     * @param j
     */
    protected void exchange(Comparable<T>[] array, int i, int j){
        Comparable<T> temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

//    protected boolean  isSorted(Comparable<T>[] array){
//
//        for(int i=0;i<array.length;i++){
//            if()
//        }
//
//    }
}
