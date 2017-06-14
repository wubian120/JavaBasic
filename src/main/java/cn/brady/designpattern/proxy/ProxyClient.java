package cn.brady.designpattern.proxy;

/**
 * works
 * jdk proxy example
 *
 * Created by Brady on 2017/6/13.
 */
public class ProxyClient {

    public static void main(String[] args){

        UserManager manager = (UserManager) new UserManagerProxy().newProxyInstance(new UserManagerImpl());

        manager.addUser("1234","brady");

    }

}
