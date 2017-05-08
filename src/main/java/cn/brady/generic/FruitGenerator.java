package cn.brady.generic;

import java.util.Random;

/** 泛型接口
 * Created by Brady on 2017/5/5.
 */
public class FruitGenerator implements Generator<String> {

    private String[] fruits = new String[]{"Apple","Pear", "Banana"};

    public String next() {
        Random random = new Random();
        return fruits[random.nextInt(3)];
    }

    public static void main(String[] args){

        FruitGenerator fruitGenerator = new FruitGenerator();
        System.out.println(fruitGenerator.next());
        System.out.println(fruitGenerator.next());
        System.out.println(fruitGenerator.next());
    }

}
