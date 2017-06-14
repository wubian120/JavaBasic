package cn.brady.designpattern.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Brady on 2017/5/23.
 */
public class SingleContainer {


    private static Map<String, Object> objMap = new HashMap<String, Object>();

    private SingleContainer(){}

    public static void registeInstance(String key, Object instance){

        if(!objMap.containsKey(key)){

            objMap.put(key, instance);
        }

    }

    public static Object getInstance(String key){
        return objMap.get(key);

    }

}
