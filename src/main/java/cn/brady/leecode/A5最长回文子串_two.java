package cn.brady.leecode;

/**
 * @description:
 * @beat    99%
 * @auther: bian.wu
 * @date: 2019/4/1 20:25
 */
public class A5最长回文子串_two {

    /***
     * @beat 99%
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        //1，判断空串
        if(s == null || s.length() == 0){
            return "";
        }
        //2，保存起始位置，将字符串转为字符数组
        int[] range = new int[2];
        char[] str = s.toCharArray();
        //3,循环字符长度，将当前字符与字符数组和起始位置传入，查找这个字符串的最大回文长度
        for(int i = 0 ; i <  s.length(); i ++){
            i = findLongest(str,i,range);
        }
        return s.substring(range[0],range[1]+1);

    }
    public static int findLongest(char[] str, int low, int[] range){
        //1，查找中间部分，判断可以进行high++
        int high = low ;
        while (high < str.length - 1 && str[high + 1] == str[low]){
            high ++ ;
        }
        //2，定位中间部分的最后一个字符，进行两边判断
        int ans = high;
        while (low > 0 && high < str.length - 1 && str[low -1] == str[high + 1]){
            low --;
            high ++;
        }
        //3，记录最大长度
        if(high - low > range[1] - range[0]){
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }


    public static void main(String...args){

        String s = "babad";
        A5最长回文子串_two  a5_2 = new A5最长回文子串_two();
        String result = a5_2.longestPalindrome(s);

        System.out.println(result);



    }
}
