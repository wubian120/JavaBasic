package cn.brady.basic.annotation;

import java.lang.reflect.Field;

public class FruitInfoUtil {


    public static void getFruitInfo(Class<?> clazz){
        String fruitName =" Fruit Name: ";
        String fruitColor = " Fruit Color: ";
        String fruitProvider = " Fruit Provider ";

        Field[] fields = clazz.getDeclaredFields();

        for(Field field : fields){

            if(field.isAnnotationPresent(FruitName.class)){
                FruitName name = (FruitName) field.getAnnotation(FruitName.class);
                fruitName += name.value();
                System.out.println(fruitName);
            }
            else if(field.isAnnotationPresent(FruitColor.class)){

                FruitColor color = field.getAnnotation(FruitColor.class);
                fruitColor += color.fruitColor().toString();
                System.out.println(fruitColor);

            }
            else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider provider = field.getAnnotation(FruitProvider.class);
                fruitProvider = fruitProvider + provider.id() + provider.name() + provider.address();
                System.out.println(fruitProvider);
            }


        }

    }



    public static void main(String[] args){

        FruitInfoUtil.getFruitInfo(Apple.class);

    }
}
