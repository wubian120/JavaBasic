package cn.brady.designpattern.singleton;

/**
 * Created by Brady on 2017/5/23.
 */
public class SingleDCL {

    private volatile static SingleDCL singleDCL = null;

    private SingleDCL(){}

    public static SingleDCL getSingleDCL(){

        if(singleDCL == null){

            synchronized (SingleDCL.class){
                if(singleDCL == null){
                    singleDCL = new SingleDCL();
                }
            }
        }
        return singleDCL;
    }

}
