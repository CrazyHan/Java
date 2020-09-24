package generic.type_erasure08.non_reifiable_types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapPollutionTest {

    public static void main(String[] args) {
        List<String> stringListA = new ArrayList<>();
        List<String> stringListB = new ArrayList<>();

        ArrayBuilder.addToList(stringListA,"2","2","4");
        ArrayBuilder.addToList(stringListB,"0","1","2");

        List<List<String>> listOfStringList = new ArrayList<>();

        ArrayBuilder.addToList(listOfStringList, stringListA, stringListB);

        ArrayBuilder.faultyMethod(Arrays.asList("Hello"), Arrays.asList("world"));

    }

}
