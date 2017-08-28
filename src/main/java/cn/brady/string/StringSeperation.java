package cn.brady.string;


import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.CharSetUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

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
        for(String key :keys){

            System.out.println("Key: " + key);

        }


        //前面是中文 斜杠 后面是英文斜杠 output : false；
        System.out.println("／".equals("/"));


        //todo 整体流程; 1.判断是否有 中文斜杠， 有则转换为 英文斜杠；2.StringUtils.split 划分为多个字符串。
        //todo: 3. 判断 key 前面是否有 + - ;






    }


    public static void main(String[] args){

//        readKeysFromString(sample3);


        String sampleKeyword = "halo/-simg／+等你哈／+草草";
        KeywordProcedure keywordProc = new KeywordProcedure(sampleKeyword);

        Set<Keyword> keywords = keywordProc.getKeywords();

        System.out.println(keywords.isEmpty());

    }

}
