package generic.generic_inheritance_subtypes05;

import generic.generic_types02.Box;

/**
 * 总结：
 * 1、无论 A，B 是否想关，Class<A> Class<B>是没有关系的
 */
public class Test {
    public static void main(String[] args) {
        //第一组
        Object object = new Object();

        Integer integer = new Integer(10);
        //可以把对象给obj
        object =integer;

        //第二级
        test0(new Integer(10));
        test0(new Float(20));



        //第三组
        //这样是不行的
        //无论 A，B 是否想关，Class<A> Class<B>是没有关系的
//        Box<Integer> box = new Box<>();
//        test(box);

    }

    public static void test0(Number numberBox) {}

    //Box<Number> Box<Integer> 没有关系
    public static void test(Box<Number> numberBox) {}

}
