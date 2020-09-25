package generic.type_erasure08.effects_type_erasure_brigde_methods;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1、Set<?> 这样传泛型变量可以防止用户修改数据导致错误的发生
 * 2、
 */
public class SetDemo {

    HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4));

    Set origin = set1;

    public static void main(String[] args) {
        //第一组
        Set<? super Number> set=null;
        set.add(1);
        //不能放String
//        set.add("ddd");

        set.add(new Float(2.3));
        set.add(new Integer(1));
//        set.add(new Object());
    }

    static void printSet(Set set) {
        set.add(2);
        set.add("dd");
        for (Object o : set) {
            System.out.println(o);
        }
    }

    //这样传泛型变量可以防止用户修改数据
    static void printSet1(Set<?> set) {
    }

}
