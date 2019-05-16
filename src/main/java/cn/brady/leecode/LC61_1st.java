package cn.brady.leecode;

/**
 * @description: leecode 66 加一 done 2018.12.28
 * <p>
 * https://leetcode-cn.com/problems/plus-one/
 * @auther: bian.wu
 * @date: 2018/12/28 15:52
 */
public class LC61_1st {

    public static int[] plusOne(int[] digits) {

        int[] newDigits = null;
        int len = digits.length;
        int number = digits[len - 1];
        number++;
        int index = len - 1;
        digits[index] = number;
        boolean isAdd = false;
        if(number == 10){
            isAdd = true;
            digits[index] = number-10;
        }
        while (isAdd  && index >0) {
            index--;
            number = digits[index];
            number++;
            if(number == 10){
                isAdd = true;
                digits[index] = number-10;
            }else {
                digits[index] = number;
                isAdd=false;
            }
        }
        if(index == 0 && number== 10){
            newDigits = new int[len+1];
            for(int i=len-1;i>1;i--){
                newDigits[i] = digits[i];
            }
            newDigits[0] = 1;
            newDigits[1] = 0;
        }

        if(newDigits != null){
            return newDigits;
        }else {
            return digits;
        }

    }


    public static void main(String... args) {
        int[] test1 = {1, 2, 3};
        int[] test2 = {9};
        int[] test3 = {9,9,9};
        LC61_1st.plusOne(test3);


        System.out.println("end");

    }
}
