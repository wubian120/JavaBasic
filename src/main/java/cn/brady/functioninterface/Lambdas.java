/**
 * Copyright (C), 2015-2018, ele me
 * FileName: Lambdas
 * Author:   bian.wu
 * Date:     2018/6/26 15:58
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */
package cn.brady.functioninterface;

/**
 * 《Java 8 实战》 chapter 3  exmaple
 *
 * @author bian.wu
 * @create 2018/6/26
 * @since 1.0.0
 */
public class Lambdas {


    public static void main(String ...args){


        Runnable r = ()->{System.out.println("Hello this is lambda example.");};
        r.run();



    }

    public static class Apple{

        private int weight = 0;
        private String color = "";

        public Apple(int w, String c){
            this.weight = w;
            this.color = c;
        }


    }

}