package cn.brady.leecode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/3/28 15:50
 */
public class A557反转字符串中的单词 {


    /**
     * @ref https://blog.csdn.net/weixin_42130471/article/details/82558355
     * @beats 62.5%
     * @status  pass
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        String [] words=s.split(" ");
        StringBuilder res=new StringBuilder();
        for(String word:words){
            res.append(new StringBuilder(word).reverse().append(" "));
        }
//        System.out.println(res);
        return res.toString().trim();

    }

    public static void main(String...args){

        String s = "Let's take LeetCode contest";


        String result = A557反转字符串中的单词.reverseWords(s);

        System.out.println(result);

    }
}
