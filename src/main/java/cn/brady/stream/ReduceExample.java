package cn.brady.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceExample {

    public static void main(String[] args){


        List<A> aList = new ArrayList<>();
        /***
         *  初始化 alist
         */
//        aList = aList.stream()
//                .filter(a->a.num > 100)
//                .filter(a->a.name.equals("ddd"))
//                .collect(Collectors.toList());

        List<B> bList = new ArrayList<>();
//        aList.stream().forEach(a->{
//            B b = new B();
//            b.setId(a.id);
//            b.setName(b.getName());
//            bList.add(b);
//        });
        A a1 = new A();
        a1.setId(1);
        a1.setName("a1");
        a1.setNum(10);

        A a2 = new A();
        a2.setId(2);
        a2.setName("a2");
        a2.setNum(20);

        A a3 = new A();
        a3.setId(3);
        a3.setName("a3");
        a3.setNum(30);

        aList.add(a1);
        aList.add(a2);
        aList.add(a3);

        bList = aList.stream().map(a->B.toB(a)).collect(Collectors.toList());


        List<List<Integer>> listList = new ArrayList<>();
        Integer[] a = {1,2,5};
        Integer[] b = {10,20,30};
        Integer[] c = {100,300, 500};

        listList.add(Arrays.asList(a));
        listList.add(Arrays.asList(b));
        listList.add(Arrays.asList(c));

        List<Integer> finalList = listList.stream().flatMap(l->l.stream()).collect(Collectors.toList());

        Long count = finalList.stream().count();



        finalList = finalList.stream().sorted().collect(Collectors.toList());

//        aList = aList.stream().sorted(Comparator.comparing(i->i.getNum())).collect(Collectors.toList());

        aList = aList.stream().sorted((i1,i2)->i1.getName().compareTo(i2.getName())).collect(Collectors.toList());
        aList = aList.stream().sorted(Comparator.comparing(i->i.getName())).collect(Collectors.toList());






        /***
         * Optional<T> reduce(BinaryOperator<T> accumulator)
         */
        int[] array1 = {23,43,56,97,20};
//        Arrays.stream(array1).reduce((i1,i2)->i1+i2).ifPresent(i->System.out.println(i));

        /***
         * T reduce(T identity, BinaryOperator<T> accumulator)
         */
        int start = 100;
        int result = Arrays.stream(array1).reduce(start, Integer::sum);
//        System.out.println(result);

        /**
         *  <U> U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
         */
        List<Integer> intList = Arrays.asList(13,24,15);
        int res = intList.parallelStream().reduce(2,(i1,i2)->i1 * i2, (j1,j2)->j1+j2);
//        System.out.println(res);


    }

}
