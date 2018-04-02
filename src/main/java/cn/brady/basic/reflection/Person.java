package cn.brady.basic.reflection;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/***
 * this is a demo class object
 */

public class Person {

    private int id;
    private String name;
    private double salary;


    public Person(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public Person(){
        id  = 1;
        name = "no name";
        salary = 1000d;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "id: " + id + " name: " + name + " salary: " + salary;
    }

    public static void main(String[] args){

        Person p1 = new Person();
        Class c1 = p1.getClass();
        System.out.println(c1.getName());

        try{

            Class c2 = Class.forName(p1.getClass().getName());
            Method[] methods = c2.getDeclaredMethods();

            if(methods.length > 0){
                for(int i=0;i<methods.length;i++){

                    System.out.println("Method name: " + methods[i].getName());
                }
            }

            /**字面常量的方式*/
            Class c3 = Person.class;

            System.out.println("c3 : " + c3.getName());

            Person p2 = (Person)c3.newInstance();

            System.out.println(p2);


            Field name = c3.getDeclaredField("name");
            name.setAccessible(true);

            Person p4 = (Person) c3.newInstance();

            name.set(p4,"p4");
            System.out.println(p4);



        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
