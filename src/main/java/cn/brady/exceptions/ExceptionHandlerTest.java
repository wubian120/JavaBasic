package cn.brady.exceptions;

/***
 *
 * exception test
 *
 * bian.wu
 * 2018.9.27
 */
public class ExceptionHandlerTest {

    public static void main(String... args){

        String s = null;

        try{

            if(s == null || s.length() <= 0){
                System.out.println(s);
            }

        }catch (Exception e){

            e.printStackTrace();
        }







    }

}
