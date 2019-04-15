package jdk.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author tengjinbao
 * <p>
 * lambda 使用
 * lambda使代码函数化 更加简洁
 * 2019/3/15
 */
public class Lambda {

    public static void main(String[] args) {
        //lambda 简化代码 例
        //Java 8之前写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8 ");
            }
        }).start();

        //Java 8 之后写法
        new Thread(() -> System.out.println("In Java8!")).start();

        //任何集成Collection 皆可以使用stream转换成流
        List<String> list = Arrays.asList("java", "c++", "c", "go", "python");
        list.stream().filter(s -> s.length() > 2).map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        int i = 0;
        System.out.println(++i);
        System.out.println(i);
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(1.4);
        doubleList.add(1.6);
        System.out.println(doubleList.stream().collect(Collectors.toList()));


    }
}
