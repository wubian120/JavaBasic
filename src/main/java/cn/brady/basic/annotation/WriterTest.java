package cn.brady.basic.annotation;


import java.lang.reflect.Method;

@Writer(name = "王小波",age = 46)
public class WriterTest {

    @Writer(name = "miya", age=10)
    public void writeLog(){
        System.out.println("write log");

    }



    public static void main(String[] args)throws ClassNotFoundException{
        try{

            Class c = Class.forName("cn.brady.basic.annotation.WriterTest");
            if(c.isAnnotationPresent(Writer.class)){
                Writer w = (Writer) c.getAnnotation(Writer.class);
                System.out.println(" name: "+w.name()+" age: " + w.age());
            }

            Method[] methods = c.getMethods();
            for(Method method : methods){
                if(method.isAnnotationPresent(Writer.class)){
                    Writer w = method.getAnnotation(Writer.class);

                    System.out.println("name: " + w.name() + " age: " + w.age());
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }





    }

}
