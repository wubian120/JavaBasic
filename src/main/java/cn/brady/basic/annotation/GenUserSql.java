package cn.brady.basic.annotation;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class GenUserSql {



    private static void genSql(User user){

        try{

            Class c = user.getClass();
            StringBuilder builder = new StringBuilder();
            builder.append("select * from ");
            if(c.isAnnotationPresent(Table.class)){
                Table table = (Table) c.getAnnotation(Table.class);
                String tableName = table.value();
                builder.append(tableName).append(" where 1=1 and ");
            }

            Field[] fields = c.getDeclaredFields();
            for(Field field : fields){
                String columnName;
                if(field.isAnnotationPresent(Column.class)){
                    Column column = field.getAnnotation(Column.class);
                    columnName = column.value();
                }else {
                    continue;
                }

                String fieldName = field.getName();
                String getMethodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
                Method method = c.getMethod(getMethodName);

                Object fieldValue = method.invoke(user);

                if(fieldValue == null || ((fieldValue instanceof Integer) && (Integer)fieldValue == 0 )){
                    continue;
                }

                if(fieldValue instanceof Integer){
                    builder.append(columnName + "=" + fieldValue);
                }

                if(fieldValue instanceof String){
                    builder.append(columnName + "=" + "'" + fieldValue + "'");
                }

            }
            System.out.println(builder.toString());


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        User u1 = new User();
        u1.setId(1);

        User u2 = new User();
        u2.setAge(35);
        u2.setName("carl");

        genSql(u1);
        genSql(u2);

        System.out.println(" the end ");

    }






}
