package cn.brady.threadpool;

/**
 * Created by Brady on 2017/7/4.
 */
public class Worker implements Runnable {

    private String filePath;

    public Worker(String filePath){
        this.filePath = filePath;
    }


    @Override
    public void run() {

        if(filePath == null || filePath.isEmpty()){
            System.out.println("file is empty or null.");
            return;
        }





    }
}
