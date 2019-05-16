package cn.brady.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * Unix 绝对路径/相对路径
 * https://blog.csdn.net/u011327334/article/details/50355600
 *
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 *
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
 * @auther: bian.wu
 * @date: 2019/4/27 10:03
 */
public class A71简化路径two {

    /***
     * 97%
     * @param path
     * @return
     */
    public String simplifyPath(String path) {

        int i = path.length() - 1, count = 0;

        List<String> symbols = new ArrayList<>();

        while (i > 0) {
            //lastIndexOf(int ch, int fromIndex) // 返回  从 fromIndex开始反向搜素 最后一次出现的索引。
            int j = path.lastIndexOf('/', i);

            if (i == j) i--;

            else {
                String x = path.substring(j + 1, i + 1);
                i = j - 1;
                if (".".equals(x)) ;
                else if ("..".equals(x)) count++;
                else if (count > 0) count--;
                else symbols.add(0, x);
            }
        }

        //string.join('/',[a,b,c]);  a,b,c 用 斜杠 分割
        return symbols.isEmpty() ? "/" : "/" + String.join("/", symbols);
    }


    public static void main(String...args){

        String s = "/a//b////c/d//././/..";
//        String s = "/../.";
        A71简化路径two a = new A71简化路径two();
        String result = a.simplifyPath(s);

        System.out.println("end");
    }






}
