package cn.brady.designpattern.proxy;

/**
 * Created by Brady on 2017/6/13.
 */
public interface UserManager {

    void addUser(String userId, String name);
    void deleteUser(String id);
    String findUser(String id);
    void modifyUser(String id, String name);

}
