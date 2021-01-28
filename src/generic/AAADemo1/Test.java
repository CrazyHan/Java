package generic.AAADemo1;

import com.sun.rowset.internal.Row;

public class Test {

    public static void scene1(){
        XiaoMing xiaoMing = new XiaoMing();
        XiaoLi xiaoLi = new XiaoLi();
        XiaoMingMa xiaoMingMa = new XiaoMingMa();
//        xiaoMing.getPlate()
        xiaoMingMa.add1();

        xiaoMingMa.add2(xiaoMing.getAIPlate());
        //这个为什么能行？
        RawPlate row =new RawPlate();
        xiaoMingMa.add2(row);

        xiaoMingMa.add2(new Plate<Apple>() {
            @Override
            public void set(Apple apple) {

            }

            @Override
            public Apple get() {
                return null;
            }

        });
//        Plate<? super Apple> plate = new AIPlate<Apple>();
//        xiaoMingMa.add2(plate);
    }

    public static void sene2() {
        int[] ints = new int[10];
        sort(ints);
        Object[] i = new Object[10];
        sort(i);

    }

    public static void sort(int [] a){}
    public static void sort(double [] a){}
    public static <T> void sort(T [] a){}


    public static void main(String[] args) {
        scene1();
    }

}
