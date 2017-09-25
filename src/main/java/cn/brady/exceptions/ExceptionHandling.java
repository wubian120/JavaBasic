package cn.brady.exceptions;

// example from below:
//http://blog.csdn.net/hp910315/article/details/49305225

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling {

    public static void testException(int i) throws FileNotFoundException, IOException{
        if(i < 0){

            FileNotFoundException myException = new FileNotFoundException("Negative integer " + i);
            throw myException;

        }else if(i >10 ){
            throw new IOException("Only supported for index to 10.");
        }
    }


    public static void main(String[] args){

        try{
            testException(-5); // 抛出异常
            testException(-10); //不执行
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Releasing resources");
        }


    }


}
