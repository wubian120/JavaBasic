package cn.brady.basic.callback.one;


/***
 * wang 实现回调函数
 *
 */
public class Wang implements CallBack{


    private Li li;

    public Wang(Li li){
        this.li = li;
    }

    public void askQuestion(final String str){
        new Thread(new Runnable() {
            @Override
            public void run() {
                /***
                 * why Wang.this；
                 */
                li.executeMessage(Wang.this, str);
            }
        }).start();

        /***
         * 表示是 异步的
         */
        play();
    };

    /***
     * do something else
     */
    public void play(){
        System.out.println("do somethingelse...");
    }

    @Override
    public void solve(String result) {
        System.out.println("Wang:solve: the result is :" + result);
    }


    public static void main(String... args){

        Li li = new Li();
        Wang wang = new Wang(li);

        wang.askQuestion("mother fucker...");


    }

}
