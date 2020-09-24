package generic.type_erasure08.non_reifiable_types;

import java.util.Arrays;
import java.util.List;

public class ArrayBuilder<V> {


    public void test(V v) {
        System.out.println(v);
    }


    public static <T> void addToList(List<T> t,T... ts){
        for (T x : ts) {
            t.add(x);
        }
    }

    public static void faultyMethod(List<String>... lists) {
        //把 List[] 数组给 Objcet
        Object[] objects = lists;

        //给第一个元素赋值
        objects[0] = Arrays.asList(42);

        //拿时候没有警告,会报错
        String s = lists[0].get(0);
    }

    public static void main(String[] args) {
        Object[] object;


    }

}

class MyClass extends ArrayBuilder<String>{
    @Override
    public void test(String s) {
        System.out.println(s);
    }
}
