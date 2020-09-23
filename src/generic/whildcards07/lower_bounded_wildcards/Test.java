package generic.whildcards07.lower_bounded_wildcards;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Number> list = new ArrayList<>();
        addNumbers(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    /**
     * PESC 原则
     * 当只从集合中获取数据，就把这个集合看成生产者，请使用<? extends T>
     * 当添加数据的时候,我们就要把这个集合看成消费者，请使用<? super T>
     *
     * 把一个变量传给一个方法去添加数据
     * @param n
     */
    public static void addNumbers(List<? super Integer> n) {
        for (int i = 0; i <= 10; i++) {
            n.add(i);
        }
    }

    public static void addNumbers1(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }

}
