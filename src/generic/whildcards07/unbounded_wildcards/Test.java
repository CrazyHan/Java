package generic.whildcards07.unbounded_wildcards;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args){
        List<String> stringList = Arrays.asList("xxx", "eee", "ddd");
//        报错
//        test1(stringList);
        test2(stringList);
    }

    public static void test1(List<Object> objectList) {
        for (Object o : objectList) {
            System.out.println(o);
        }
    }

    public static void test2(List<?> objects) {
        for (Object object : objects) {
            System.out.println(object);
        }
    }

}
