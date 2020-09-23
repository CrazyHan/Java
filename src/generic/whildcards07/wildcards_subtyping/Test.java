package generic.whildcards07.wildcards_subtyping;

import java.util.ArrayList;
import java.util.List;

class A{

}

class B extends A {

}

public class Test {

    //第一组没有问题
    B b = new B();
    A a = b;


    //第二组
    List<B> list = new ArrayList<>();
    //这个报错，因为限定了必须是 A 类型
    //尽管 B 是 A 的子类 ，但是List<B> 不是 List<A>子类型，实际上他们有共同的父类 List<?>
//    List<A> aList = list;
    List<? extends A> bli = list;


    //第三组  跟二级类似
    List<? extends Integer> integers = new ArrayList<>();
    List<? extends Number> munList = integers;

}
