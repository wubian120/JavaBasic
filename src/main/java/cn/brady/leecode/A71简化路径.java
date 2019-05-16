package cn.brady.leecode;

import java.util.Stack;

/**
 * @description:  71 简化路径
 * @题目：    https://leetcode-cn.com/problems/simplify-path/
 *
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 *
 * 两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。
 * 最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 * 示例 1：
 *
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 *
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 示例 3：
 *
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 *
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 示例 5：
 *
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 示例 6：
 *
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 *
 *
 *  todo: leetcode 71  简化路径
 *  todo: 1.跟一遍      done  3-25
 *  todo: 2.理解
 *  todo: 3. 背着写一遍
 *  todo: 4.可以默写完成
 *
 * @auther: bian.wu
 * @date: 2019/3/25 16:25
 */
public class A71简化路径 {
    /**
     *
     * @status  pass
     * @beats   61%
     * @cost   28ms
     *
     */
    public static String simplifyPath(String path) {
        path = path + "/"; //直接在path后加"/"防止特殊情况
        Stack<Integer> s = new Stack<>(); //栈,用来处理/../时,消除当前目录
        StringBuffer sb = new StringBuffer();//存储简化后的路径

        int len = path.length();
        int p = 0;
        int getparameter = 0;
        for (int i = 0; i < len - 1;) {
            if (path.charAt(i) == '/') {//双指针,截取/xxx/这段字符串
                p = i + 1;
                while (path.charAt(p) != '/') {
                    p++;
                }
            }
            String temp = path.substring(i, p + 1);

            getparameter = chooseForPath(temp);

            switch (getparameter) {//根据返回参数,处理简化路径
                case 1:
                    temp = path.substring(i, p);
                    sb.append(temp);
                    s.add(temp.length());
                    i = p; //指针移位
                    break;
                case 2:
                    i = p;
                    break;
                case 3:
                    if (!s.isEmpty()) {
                        int lenOfsb = sb.length();
                        int index = lenOfsb - s.pop();
                        sb.delete(index, sb.length());
                        i = p;
                    } else {
                        i = p;
                    }
                    break;
                case 4:
                    i = p;
                    break;

                default:
                    break;
            }
        }
        if (sb.length() == 0) {//特殊情况处理
            return "/";
        }
        return sb.toString();
    }
    public static  int chooseForPath(String tempOfsub) {
        /*
         * "/"a"/"  返回 1
         * "/"."/"  返回 2
         * "/".."/" 返回 3
         * "/"/"    返回 4
         */
        if (tempOfsub.equals("/./"))
            return 2;
        else if (tempOfsub.equals("/../"))
            return 3;
        else if (tempOfsub.equals("//"))
            return 4;
        else {
            return 1;
        }
    }


    public  static void main(String...args){


        String  s = "/a//b////c/d//././/..";
        String result = A71简化路径.simplifyPath(s);

        System.out.println(result);

    }




}
