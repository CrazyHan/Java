package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * 泛型总结：
 *
 */
public class GenericReview {

    public static void main(String[] args) {
        process(new ArrayList<Integer>());
    }

    public static void process(ArrayList<? extends Number> list){
        Map<String, String> map = new HashMap<String, String>();
        map.put("xx","xx");
        map.put("ee","ee");
        map.put("dd","dd");

        Map<Integer, Integer> map4 = new HashMap();
        map4.put(1, 1);
        map4.put(2, 2);
        map4.put(3, 3);
        map4.put(4, 4);
//类型推断发现类型不匹配，出错
//        Map<String, String> map1 = new HashMap<>(map4);
        Map<String, String> map1 = new HashMap<>();
        map1.put("xx","xx");
        map1.put("ee","ee");
        map1.put("dd","dd");

       //没有类型推断，可以放入里面
        Map<String, String> map2 = new HashMap(map4);
        map2.put("xx","xx");
        map2.put("ee","ee");
        map2.put("dd","dd");

        Iterable iterable = map2.keySet();
        iterable.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);

            }
        });
    }

}
