package cn.brady.practices.callback;

/**
 * Created by Brady on 2017/6/13.
 */
public class CallbackTest {

    public static void main(String[] args){

        final String url = "http://www.zhihu.com/question/234123";
        String result = UtilClass.call(url, new ICallback() {
            @Override
            public String handle(String content) {
                return url + "has been handled...";
            }
        });

        System.out.println(result);


    }

}


class UtilClass{

    public static String call(String url, ICallback handler){
        String respone="";
        //
        respone = url;
        return handler.handle(respone);


    }
}

interface ICallback{
    String handle(String content);
}