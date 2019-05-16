package cn.brady.leecode;

/**
 * @description: leetcode 6 z字形变换
 * @题目： https://leetcode-cn.com/problems/zigzag-conversion/
 * @解法： https://www.jianshu.com/p/8b83c6a2eff8
 * @auther: bian.wu
 * @date: 2019/3/9 11:38
 */
public class A6_One {

    public static String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int nRows = numRows;
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }


    /***
     * @beat   91%
     * @param s
     * @param numRows
     * @return
     */
    public String convert_two(String s, int numRows) {

        if(s == null || s.length() == 0 || numRows < 2) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int n = s.length();
        int cycleLength = 2 * numRows - 2;

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j + i < n; j += cycleLength) {
                result.append(s.charAt(i + j));
                if(i != 0 && i != numRows - 1 && (j + cycleLength - i) < n) {
                    result.append(s.charAt(j + cycleLength - i));
                }
            }
        }

        return result.toString();
    }


    /***
     * @思路：
     *
     * @beat 80%
     * @param s
     * @param numRows
     * @return
     */
    public String convert_three(String s, int numRows) {
        //字符串转化成数组
        char[] c = s.toCharArray();
        //创建字符串数组
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0; i < sb.length; i++)
            sb[i] = new StringBuffer();
        int i = 0;
        int len = c.length;
        while(i < len){
            for(int idx = 0; idx < numRows && i < len; idx++)
                sb[idx].append(c[i++]);
            for(int idx = numRows - 2; idx >= 1 && i < len; idx--)
                sb[idx].append(c[i++]);
        }
        //拼接所有字符串
        for(int idx = 1;idx < numRows;idx++)
            sb[0].append(sb[idx]);

        return sb[0].toString();
    }


    public static void main(String... args) {

        String s = "LEETCODEISHIRING";


        String result = A6_One.convert(s, 3);

        for(char c : result.toCharArray()){
            System.out.print(c);
        }
        System.out.println("end");

    }

}
