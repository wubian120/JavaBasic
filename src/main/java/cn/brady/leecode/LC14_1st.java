package cn.brady.leecode;

/**
 * @description: leecode 14 最长公共前缀    done
 *
 *
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * @auther: bian.wu
 * @date: 2018/12/25 20:04
 */
public class LC14_1st {

    public static String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length ==0 || strs[0].length() == 0){
            return "";
        }
        if(strs.length < 2){
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int len = strs.length;
        char lastChar = strs[0].charAt(0);
        boolean isContinue = true;
        while (index < strs[0].length() && isContinue) {
            for (int i = 0; i < len; i++) {
                String word = strs[i];
                if (index >= word.length()) {
                    isContinue = false;
                    break;
                } else if (i == 0) {
                    lastChar = strs[i].charAt(index);

                } else {
                    if (lastChar == word.charAt(index)) {
                        if (i == len - 1) {
                            sb.append(lastChar);
                        }
                    }else {
                        isContinue = false;
                        break;
                    }
                }
            }
            index++;
        }



//        Character[] commonCharsArray = commonChars.toArray(new Character[commonChars.size()]);
        return sb.toString();
    }


    public static void main(String... args) {

        String[] test1 = {"flower", "flow", "flight"};
        String[] test2 = {"dog", "racecar", "car"};
        String[] test3 = {"a"};
        String[] test4 = {"c","acc","ccc"};
        String[] test5 = {"aca","cba"};


        String commonStr = LC14_1st.longestCommonPrefix(test5);

        System.out.println("end");


    }

}
