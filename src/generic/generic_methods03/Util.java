package generic.generic_methods03;

import generic.generic_types02.OrderedPair;
import generic.generic_types02.Pair;

/** 方法泛型 */
public class Util {
    public static <K, V> boolean compare(K k, V v) {
        return false;
    }

    public static <K, V> boolean compare1(Pair<K,V> p1, Pair<K,V>p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

    public static void main(String[] args) {
        Pair<Integer, String> p1 = new OrderedPair<Integer, String>(1, "111");
        Pair<Integer, String> p2 = new OrderedPair<>(2, "222");

        //完整语法
        boolean result = Util.<Integer,String>compare1(p1, p2);
        //类型推导
        result = Util.compare1(p1, p2);

        System.out.println("结果"+result);

    }
}
