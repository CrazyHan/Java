package generic.type_inference_06.type_inference_instantiation_generaic_classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String, List<String>> myMap = new HashMap<>();
        Map<String, List<String>> myMap1 = new HashMap<String, List<String>>();
        Map<String, List<String>> myMap2 = new HashMap();
    }
}
