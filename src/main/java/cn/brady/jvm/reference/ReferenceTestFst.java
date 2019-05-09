/**
 * Copyright (C), 2015-2018, ele me
 * FileName: ReferenceTestFst
 * Author:   bian.wu
 * Date:     2018/7/14 21:03
 * Description: ${DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 */
package cn.brady.jvm.reference;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 〈${DESCRIPTION}〉
 *
 * @author bian.wu
 * @create 2018/7/14
 * @since 1.0.0
 */
public class ReferenceTestFst {

    public class Person{

        private String name;
        private int age;

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "name: "+name+" age:" + age;
        }
    }

    public static void main(String... args){


        Person p1 = new ReferenceTestFst().new Person();

        p1.setAge(10);
        p1.setName("person1");

//        SoftReference<Person> softReference = new SoftReference<>(p1);
        WeakReference<Person> weakReference = new WeakReference<>(p1);
        p1 = null;

        System.gc();

//        Person p2 = softReference.get();
        Person p3 = weakReference.get();

//        System.out.println(p2);

        System.out.println(p3);




    }


}