package cn.brady.basic.callback.one;

/**
 * callback example
 *https://blog.csdn.net/xiaanming/article/details/8703708
 */
public class Li {

    public void executeMessage(CallBack callBack, String question){

        System.out.println("Li : question: "+question);

        for(int i=0;i<1000;i++){
            /**
             *
             *
             */
        }
        /***
         *
         * compute ...
         */

        String result = "someting result";

        callBack.solve(result);
    }
}
