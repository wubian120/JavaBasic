package cn.brady.designpattern.jdk_dynamic_proxy;

/**
 * Created by Brady on 2017/6/29.
 */
public class UserServiceImpl implements UserService {

    @Override
    public int getAge(int id) {

        System.out.println(this.getClass().getSimpleName()+" getAge("+id+")");

        return id;
    }

    @Override
    public String getName(int id) {
        System.out.println(this.getClass().getSimpleName()+" getName("+id+")");
        return "name: " + id;
    }
}
