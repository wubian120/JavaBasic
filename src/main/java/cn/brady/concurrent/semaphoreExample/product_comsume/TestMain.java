package cn.brady.concurrent.semaphoreExample.product_comsume;

public class TestMain {

    public static void main(String... args){

        Buffer buffer = new Buffer();
        startProduce(buffer);
        startProduce(buffer);

        startConsume(buffer);
        startConsume(buffer);


    }


    public static void startProduce(final Buffer buffer){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while (true){
                        buffer.put();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static void startConsume(final Buffer buffer){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while (true){
                        buffer.get();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
