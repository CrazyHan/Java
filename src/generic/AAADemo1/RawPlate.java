package generic.AAADemo1;

import java.util.ArrayList;
import java.util.List;

/**
 * 没有泛型的盘子
 */
public class RawPlate implements Plate{

    private List fruit = new ArrayList(10);

    public RawPlate() {
    }

    @Override
    public void set(Object o) {
        fruit.add(o);
    }

    @Override
    public Object get() {
        int index = fruit.size()-1;
        if (index >= 0) {
            return fruit.get(index);
        }
        return null;
    }

    @Override
    public String toString() {
        return "RawPlate{" +
                "fruit=" + fruit +
                '}';
    }
}
