package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 泛型总结：
 *
 */
public class GenericReview {

    public static void main(String[] args) {
        process(new ArrayList<Integer>());
    }

    public static void process(ArrayList<? extends Number> list){

    }

}
