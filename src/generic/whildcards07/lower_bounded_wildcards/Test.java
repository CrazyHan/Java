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

        //super 父类
        List<GrandPa> grandPas = new ArrayList<>();
        grandPas.add(new GrandPa("Grandpa1"));
        grandPas.add(new GrandPa("Grandpa2"));
        grandPas.add(new Son("sonn"));
        addChildren(grandPas);

        List<Daddy> daddies = new ArrayList<>();
        addChildren(daddies);

        //super 子类
        List<Son> sons = new ArrayList<>();
        //addChildren(sons);这个不行
        sons.add(new Son("son1"));
        sons.add(new Son("son2"));


        //案例3：说明List<? super GrandPa> 是 List<? super Daddy>的子类
        List<? super GrandPa> grandPas1 = new ArrayList<>();
        addChildren(grandPas1);


        /**
         * 上面两个例子说明  List<GrandPa> 是List<? super Daddy> 的子类
         */

        for (GrandPa grandPa : grandPas) {
            System.out.println(grandPa.toString());
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
    public static List<? super Integer> addNumbers(List<? super Integer> n) {
        for (int i = 0; i <= 10; i++) {
            n.add(i);
            n.add(3);
        }
        return n;
    }

    public static void addNumbers1(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }


    public static void addChildren(List<? super Daddy> biggerMan) {
        biggerMan.add(new Daddy("daddy1"));
        biggerMan.add(new Daddy("daddy2"));
        biggerMan.add(new Son("son1"));
        biggerMan.add(new Son("son2"));
//        biggerMan.add(new GrandPa());//这样不行，添加不了
    }

    /**
     *
     * @param biggerMan
     * @return
     */
    public static List<? super Son> addChildren2(List<? super Daddy> biggerMan) {
        biggerMan.add(new Daddy("daddy1"));
        biggerMan.add(new Daddy("daddy2"));
        biggerMan.add(new Son("son1"));
        biggerMan.add(new Son("son2"));
//        biggerMan.add(new GrandPa());//这样不行，添加不了
        return biggerMan;
    }


    public static <T extends GrandPa> void copy(List<? extends T> producter,List<? super T> consumer){

//        consumer.
        for (T t : producter) {
            consumer.add(t);
        }

    }

}

class GrandPa{
    public String name;

    public GrandPa(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GrandPa{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Daddy extends GrandPa {
    public Daddy(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Daddy{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Son extends Daddy{
    public Son(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Son{" +
                "name='" + name + '\'' +
                '}';
    }
}