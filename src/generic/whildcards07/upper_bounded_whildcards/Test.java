package generic.whildcards07.upper_bounded_whildcards;

import generic.whildcards07.Foo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {
        List<Double> doubles = new ArrayList<>();
        sumofList1(doubles);

        reflectTest();

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        System.out.println("sum" + sumofList1(integers));


        List<Son> sons = new ArrayList<>();
        test(sons);

        for (Son son : sons) {
            System.out.println(son);
        }
        List<Daddy> daddies = new ArrayList<>();
        test(daddies);

        List<? extends Daddy> daddies1 = new ArrayList<>();
        test(daddies1);


        List<? extends Grandpa> grandpas = new ArrayList<>();
        //test(grandpas);这个不行
        List<Son> sons1 = new ArrayList<>();
        test(sons1);

        //这个玩意返回的不是 ArrayList 类型，不能添加
//        List<Integer> src = Arrays.asList(new Integer(6),7,8,9,10);
//        List<Integer> dst = Arrays.asList(new Integer(1),2,3,4,5);

        List<Integer> src = new ArrayList<>();
        src.add(6);
        src.add(7);
        src.add(8);
        src.add(9);

        List<Integer> dst = new ArrayList<>();
        dst.add(1);
        dst.add(2);
        dst.add(3);
        dst.add(4);
        dst.add(5);


        copy(src, dst);

        System.out.println(dst);

    }

    //
    public static <T> void copy(List<? extends T> productor, List<? super T> consumer) {
//        System.arraycopy(productor, 0, consumer, consumer.size(), productor.size());

        for (T t : productor) {
            consumer.add(t);
        }


    }


    public static void process(List<? extends Foo> foos) {
        for (Foo foo : foos) {
            foo.f1();
            System.out.println(foo.getFooSize());

        }
    }

    public static void reflectTest() throws Exception {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(new Integer(2));
        integers.add(2);

        Method m = integers.getClass().getDeclaredMethod("add", Object.class);
        m.invoke(integers, "xxx");
        System.out.println(integers);


        for (Object o : integers) {
            System.out.println(o.getClass());

        }

    }



    public static void text1(List<?> list) {
        for (Object o : list) {
            System.out.println(o.getClass());
        }
    }

    public static double sumofList1(List<?extends Number> list) {
        //不能添加
//        list.add(new Float(1.0f));
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }

    public static void test(List<? extends Daddy> daddies) {
        daddies.add(null);
        //这个出乎意料
        List list = new ArrayList<>();
        list.add(new Son());
        daddies.addAll(list);//我草，这个可以添加这个呢绝对出问题
    }

}

class Grandpa{

}
class Daddy extends Grandpa{

}
class Son extends Daddy{

}

