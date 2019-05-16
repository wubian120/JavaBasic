package cn.brady.leecode;

/**
 * @description: 最后一个单词的长度
 * leecode 58
 * <p>
 * https://leetcode-cn.com/problems/length-of-last-word/
 * @auther: bian.wu
 * @date: 2018/12/1 15:23
 */
public class lengthOfLastWord1st {

    public static int lengthOfLastWord(String s) {

        s = s.trim();
        boolean hasChar = false;
        for (char c : s.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                hasChar = true;
            }
        }
        if (!hasChar) {
            return 0;
        }
        s = s.toLowerCase();
        int length = s.length();
        String lastWord = "";
        while (length > 0) {

            int lastIndex = s.lastIndexOf(" ");
            lastWord = s.substring(lastIndex + 1, s.length());
            boolean isLast = false;
            for (char c : lastWord.toCharArray()) {
                if ('a' <= c && c <= 'z') {
                    isLast = true;
                    continue;
                } else {
                    break;
                }
            }
            if (isLast) {
                break;
            } else {
                s = s.substring(0, lastIndex);
            }
        }
        return lastWord.length();
    }

    public static void main(String... args) {
        String s = "Hello World    ()$#@$@#$@ ";
        String s1 = "    ()$#@$@#$@ ";

//        int result = 0;
        int result = lengthOfLastWord1st.lengthOfLastWord(s1);

        char c = 'z';

        boolean isBig = c > 'a';
        boolean isLess = c < 'z';

        System.out.println(result);
    }


}
