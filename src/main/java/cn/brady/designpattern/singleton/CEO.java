package cn.brady.designpattern.singleton;



/**
 * Created by Brady on 2017/5/23.
 */
public class CEO extends Staff {

    private static final CEO ceo = new CEO();

    private CEO(){

    }

    public static CEO getCEO(){
        return ceo;
    }





}
