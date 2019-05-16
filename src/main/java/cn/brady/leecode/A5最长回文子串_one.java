package cn.brady.leecode;

/**
 * @description: 5. 最长回文子串
 *
 * 题目：https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 解法：https://github.com/stephanieengelhardt/LongestPalindrome/blob/master/Solutions.java
 *
 * @auther: bian.wu
 * @beat     50%
 * @date: 2019/2/16 21:52
 */
public class A5最长回文子串_one {

    /**
     * @beat  46%
     * todo:  read
     * todo:  write accordingly
     * todo:
     *
     */
    public String longestPalindrome(String s) {
        int currentBest = 1;
        int length = s.length();
        if(length == 0){
            return "";
        }
        int start = 0;

        //if dynamicTable[i][j] is true, then that substring from i to j is a palindrom
        boolean dynamicTable[][]= new boolean[length][length];

        //All substrings that are of length 1 are palindromes, so make those indices true
        for (int i = 0; i < length; i++){
            dynamicTable[i][i] = true;
        }

        //Now do all the lengths of two and see if they are the same character
        for (int i = 0; i < length - 1; i++) {
            //If the two characters are the same
            if (s.charAt(i) == s.charAt(i + 1)) {
                dynamicTable[i][i + 1] = true;
                //The longest palindrom now starts here
                start = i;
                //Woohoo! New best!
                currentBest = 2;
            }
        }

        // Continue making it bigger to check for more palindroms. Let l be the length we are checking for, go until n
        for (int l = 3; l <= length; l++) {
            for (int i = 0; i < length - l + 1; i++) {
                // Let j be where the ending index would be if this is a palindrom
                int j = i + l - 1;

                // Now use the dynamic table we have created and the new characters to see if it is a palindrome!
                if ((dynamicTable[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j))) {
                    //A new palidrome! Save our information
                    dynamicTable[i][j] = true;
                    if (l > currentBest) {
                        //Another win is on the way, Michael Phelps!
                        start = i;
                        currentBest = l;
                    }
                }
            }
        }
        return s.substring(start, start+currentBest);

    }


    public static void main(String...args){
        String s = "babad";
//        String s = "ac";
        A5最长回文子串_one a5One = new A5最长回文子串_one();

        String result = a5One.longestPalindrome(s);
        System.out.println(result);
        System.out.println("end");


    }


}
