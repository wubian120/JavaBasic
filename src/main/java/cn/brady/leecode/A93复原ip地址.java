package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 93 复原ip地址
 * @auther: bian.wu
 *
 *  todo: 93  复原ip地址
 *  todo: 1.跟一遍
 *  todo: 2.理解
 *  todo: 3.把 解空间树  列一遍
 *  todo: 3. 背着写一遍
 *  todo: 4.可以默写完成
 * @date: 2019/3/23 14:48
 */
public class A93复原ip地址 {


    /**
     * @status pass
     * @cost   4ms
     * @beats   73%
     * @ref  https://blog.csdn.net/xygy8860/article/details/47074201
     */
    public static List<String> list;
    public static List<String> restoreIpAddresses(String s) {
        list = new ArrayList<String>();
        /**
         * 初始传入的字符串长度只能为4-12
         */
        addDot(s,"",3);

        return list;
    }
    /**
     *
     * @param s 需要处理的字符串
     * @param result 装载结果的字符串
     * @param k 当前还有几个"."
     */
    private static void addDot(String s,String result, int k){

        //传入字符串必须合法
        if(s.length() <= k){
            return;
        }
        if(s.length() > 3*(k+1)){
            return;
        }
        if(k == 0){//最后一段，判断小于256
            if((s.charAt(0) == '0' && s.length() > 1 ) || Integer.parseInt(s) >= 256)
                return;
            list.add(result + "." + s);
            return;
        }
        //遍历前面3位，如果小于256，则参与递归
        for(int i = 1; i <= s.length(); i++){
            //temp 取前面i位
            String temp = s.substring(0,i);
            //当前段小于256，表示合法，可以继续
            if(Integer.parseInt(temp) < 256){
                //取剩下的
                String str = s.substring(i);
                //分情况，如果result为空，则前面不加"."
                if(result.length() > 0){
                    temp = result + "." + temp;
                }
                addDot(str,temp, k-1);
                //如果第一个数字为0，则不再继续循环
                if(s.charAt(0) == '0'){
                    break;
                }
            }else{
                break;
            }
        }
    }



    public static void main(String...args){
        String s = "25525511135";

        List<String> results = A93复原ip地址.restoreIpAddresses(s);

        for(String r:results){
            System.out.println(r);
        }
        System.out.println("end");

    }




}
