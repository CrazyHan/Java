package generic.AAADemo1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void sene1() {
        ArrayList<Apple> apples = new ArrayList<>();
        ArrayList<Banana> bananas = new ArrayList<>();
//        apples = bananas;//编译时类型检查
        System.out.println(apples.getClass() == bananas.getClass());
    }

    public static void scene2() {
        ArrayList<String> strings = new ArrayList<>();
        System.out.println(strings instanceof ArrayList<?>);//泛型又擦除了，证明了运行时是没有泛型的

    }


    public static void main(String[] args) {
        sene1();
        scene2();
        scene5();
    }

    public static void scene5() {
        Apple[] apples = new Apple[10];
        Fruit[] fruits = new Fruit[10];
        //这个没有问题
        fruits = apples;

        System.out.println(apples.getClass());
        System.out.println(fruits.getClass());
        System.out.println("-------------");
        //java.lang.ArrayStoreException
        //fruits[0] = new Banana();//这里是没有问题的，编译器知道 Banana 是水果，但不知道内存已经是苹果

        Plate<?>[] plates = new Plate<?>[10];

        RawPlate rawPlate = new RawPlate();
        rawPlate.set(new Integer(1));
        plates[0] = rawPlate;

        Plate<Apple> appleAIPlate = new AIPlate<>();
        appleAIPlate.set(new Apple());
        plates[1] = appleAIPlate;

        System.out.println(plates[0].getClass());
        System.out.println(plates[0].get());

        System.out.println(plates[1].getClass());
        System.out.println(plates[1].get());

        AIPlate<Banana> aiPlate = new AIPlate<>();
        aiPlate.set(new Banana());

        plates[0] = aiPlate;
        plates[1] = aiPlate;

        System.out.println(plates[0].getClass());
        System.out.println(plates[0].get());

        System.out.println(plates[1].getClass());
        System.out.println(plates[1].get());

        List<Fruit> fruitList = new ArrayList<>();
        List<Apple> appleList = new ArrayList<>();
        Test2.<Fruit>realUsage(fruitList, appleList);

    }

    public static <T> T generate( Class<T> tClass){
        T t = null;
        try {
            t = tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }

    //PESC
    public static <T> void realUsage(List<? super T> dst, List<? extends T> src) {
        Collections.copy(dst, src);
    }

}
