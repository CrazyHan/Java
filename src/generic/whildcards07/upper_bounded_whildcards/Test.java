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

}
