package cn.brady.designpattern.proxy;

/**
 * Created by Brady on 2017/6/13.
 */
public class UserManagerImpl implements UserManager {

    @Override
    public void addUser(String userId, String name) {

        System.out.println("add user "+ userId + " name: " + name);
    }

    @Override
    public String findUser(String id) {
        System.out.println("find user: " + id);
        return "a user";
    }

    @Override
    public void deleteUser(String id) {
        System.out.println("delete user: " + id);
    }

    @Override
    public void modifyUser(String id, String name) {
        System.out.println("modify user: " + id + " name" + name);

    }


}
