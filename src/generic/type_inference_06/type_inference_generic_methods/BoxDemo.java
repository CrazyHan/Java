package generic.type_inference_06.type_inference_generic_methods;

import generic.type_inference_06.Box;

import java.util.ArrayList;
import java.util.List;

public class BoxDemo {

    public static <U> void addBox(U u, List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBoxed(List<Box<U>> boxes) {
        int count = 0;
        for (Box<U> box : boxes) {
            U boxContents = box.get();
            count++;
        }
    }

    public static void main(String[] args) {
        ArrayList<Box<Integer>> list = new ArrayList<>();

        BoxDemo.<Integer>addBox(Integer.valueOf(10), list);
        BoxDemo.addBox(Integer.valueOf(20), list);
        BoxDemo.addBox(Integer.valueOf(20), list);
        BoxDemo.outputBoxed(list);

    }

}
