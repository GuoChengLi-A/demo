package com.shunteng.test01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Author GCL
 * @Date 2020/5/22 上午9:17
 */
public class StreamTest {

    public static void main(String[] args) {
      /*  Integer value1=3;
        Integer value2=2;
        boolean equals = Optional.ofNullable(value1).equals(value2);
        System.out.println(equals);
        Integer sum = Stream.of(value1, value2).reduce(1,Integer::sum).compareTo(Integer.MAX_VALUE);
        System.out.println(sum);
        Integer [] arr={1,2,3,4,5,6};
        Integer integer = Stream.of(arr).reduce(Integer::sum).get();
        System.out.println(integer);
        String reduce = Stream.of("A", "B", "C").filter(x->x.compareTo("B")>0).reduce("",String::concat);
        System.out.println(reduce);
        ArrayList<Integer> listIntgeters = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
            listIntgeters.add(i);
        }
        Integer integer1 = listIntgeters.stream().limit(10).skip(3).reduce(Integer::sum).get();
        System.out.println(integer1);*/
        List<Country> listCountries = new ForLoopTest().listCountries(10);
//        listCountries.stream().collect(Collectors.joining(Country::new.toString()));
        String ids="1,2,3,4,5,6,7,";
       Arrays.stream(ids.split(",")).map(Long::valueOf).collect(Collectors.toList()).forEach(System.out::println);

    }
}