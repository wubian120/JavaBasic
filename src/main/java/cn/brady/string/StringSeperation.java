package cn.brady.string;


import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;

/***
 * 选品关键字 处理
 */

//todo: 1.如何区分 中文/ 和 英文/
//todo: 2. 识别 + -号；区分中文+ 英文+
//todo：3.如何区分
public class StringSeperation {

    public static String sample1 = "key1/key2/咖啡/茶";
    public static String sample2 = "key3／key4/奶茶"; //with 中文符号
    public static String sample3 = "-鸡腿/+饭/-面/";

    public static void readKeysFromString(String sample){


        CharSet keysWithSlash = CharSet.getInstance("/");
        CharSet keysWithCNSlash = CharSet.getInstance("／");

        String sample1 = "key1/key2/咖啡/茶";
        String sample2 = "key3／key4/奶茶"; //with 中文符号

        String result = CharSetUtils.delete(sample,"/");

        String[] keys = StringUtils.split(sample,"/");
        Set<String> keySet = new HashSet<>();
        for(String key :keys){

            System.out.println("Key: " + key);

            if(key.contains("+")){
                keySet.add(StringUtils.remove(key,"+"));
//                StringUtils.remove(key,"+");
            }
            if(key.contains("-")){
                keySet.add(StringUtils.remove(key,"-"));
//                StringUtils.remove(key,"-");
            }

//            keySet.add(key);


        }


        //前面是中文 斜杠 后面是英文斜杠 output : false；
        System.out.println("／".equals("/"));


        //todo 整体流程; 1.判断是否有 中文斜杠， 有则转换为 英文斜杠；2.StringUtils.split 划分为多个字符串。
        //todo: 3. 判断 key 前面是否有 + - ;



    }




    public static void main(String[] args){

//        readKeysFromString(sample3);

        String PLUS = "+";
        String MINUS = "-";

        String kkk = "";
        String sampleKEy = "key";

        kkk += PLUS + sampleKEy;

//        System.out.println(kkk);

        String sampleKeyword = "haf-a-si  +mg+等你哈";

        System.out.println(sampleKeyword);

        StringUtils.trim(sampleKeyword);

        System.out.println(sampleKeyword);

        StringUtils.trimToEmpty(sampleKeyword);

        System.out.println(sampleKeyword);
//        if(StringUtils.containsAny(sampleKeyword,PLUS)){
//            System.out.println(" Yes ");
//
//            String[] keys = StringUtils.splitByWholeSeparator(sampleKeyword, PLUS);
//
//            for(String k : keys){
//                System.out.println(k);
//            }
//        }

        String empty = " ";
//        empty = StringUtils.trimToEmpty(empty); // output :true
//        System.out.println(StringUtils.isEmpty(empty));

        empty = StringUtils.trim(empty);
        System.out.println(StringUtils.isEmpty(empty));



        String s1 = "123-4mkj";

        System.out.println(StringUtils.containsNone(s1,"+"));

        String keyword = null;

        List<String> keys = new ArrayList<>();
        keys.add("423");
        keys.add("15");
        for(String k : keys){
            k += "%";
            keyword += k;
        }

        System.out.println(keyword);

//        String s2 = StringUtils.removeEnd(keyword,"%");  去掉
        String s2 = StringUtils.replace(s1,"-","%");  // 替换

        System.out.println(s2);





        System.out.println("...End...");
    }

}
