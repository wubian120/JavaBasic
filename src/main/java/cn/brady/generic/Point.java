package cn.brady.generic;

/**
 * 泛型类 定义 基本使用
 * Created by Brady on 2017/5/4.
 */
public class Point<T> {

    private T x;
    private T y;

    public T getX() {return x;}

    public void setX(T x) {this.x = x;}

    public T getY() {return y;}

    public void setY(T y) {this.y = y;}

    public static void main(String[] args){

        Point<Integer> pointInt = new Point<Integer>();
        pointInt.setX(new Integer(100));
        pointInt.setY(new Integer(20));

        System.out.println("x: "+pointInt.getX()+" y: "+ pointInt.getY());

        Point<Double> pD = new Point<Double>();
        pD.setX(new Double(10.00));
        pD.setY(new Double(41.23));

        System.out.println("x: "+ pD.getX() +" y: "+ pD.getY());

    }

}


