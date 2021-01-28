package generic.AAADemo1;

import javax.xml.ws.soap.Addressing;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class XiaoMingMa extends Person {
    /**
     * 原始类型添加任何一个水果
     * @param rawPlate
     */
    public void addFruit(RawPlate rawPlate) {
        rawPlate.set(new Fruit());
        rawPlate.set(new Apple());
        rawPlate.set(new Banana());
    }

    public void add1() {
        Plate<? extends Fruit> fruitpate = new AIPlate(new Apple());
//        fruitpate.get();
        try {
            Method method = fruitpate.getClass().getMethod("set", Object.class);
            method.setAccessible(true);
            method.invoke(fruitpate, new Banana());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(fruitpate.get());

    }

    public void add2(Plate<? extends Fruit> fruitpate) {
        try {
            Method m = fruitpate.getClass().getMethod("set", Object.class);
            m.setAccessible(true);
            m.invoke(fruitpate, new Banana());
            System.out.println(fruitpate.get());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


}
