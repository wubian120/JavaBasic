package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/14 09:52
 */
public class A93_self_one {


    static  List<String> container;
    public static List<String> restoreIpAddresses(String s){
        container = new ArrayList<>();

        addDot(s,"",3);

        return container;
    }

    private static void addDot(String handle, String result, int k){
        int len = handle.length();
        if(len <=k || len> 3*(k+1))return;

        if(k==0){
            if((handle.charAt(0)=='0' && handle.length()>1)||Integer.parseInt(handle)>=256)
                return;
            container.add(result+"."+handle);
            return;
        }
        for(int i=1;i<len;i++){
            String temp = handle.substring(0,i);

            if(Integer.parseInt(temp)<256){
                String str = handle.substring(i);
                if(result.length()>0){
                    temp = result + "."+temp;
                }
                addDot(str, temp, k-1);
                if(handle.charAt(0) =='0'){
                    break;
                }

            }else {
                break;
            }
        }
    }
}
