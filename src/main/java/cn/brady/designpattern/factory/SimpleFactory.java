package cn.brady.designpattern.factory;

/**
 * Created by Brady on 2017/5/18.
 */
public class SimpleFactory {

    public static final String CIRCLE    ="circle";
    public static final String RECTANGLE = "rectangle";
    public static final String TRIANGLE  = "triangle";

    public static Shape create(String name){

        Shape shape = null;
        if(name == null || name == ""){
            throw new NullPointerException();
        }

        // or switch
        if(name.equals("circle")){
            shape = new Circle();
        }else if(name.equals("rectangle")){
            shape = new Rectangle();
        }else if(name.equals("triangle")){
            shape = new Triangle();
        }
        return shape;
    }

    public static void main(String[] args){

        String s = "circle";
        String s1 = "rectangle";
        String s2 = "triangle";

        Shape shape1 = SimpleFactory.create(s);
        shape1.sayHi();

        Shape shape2 = SimpleFactory.create(s1);
        shape2.sayHi();

        Shape shape3 = SimpleFactory.create(s2);
        shape3.sayHi();

    }

}
