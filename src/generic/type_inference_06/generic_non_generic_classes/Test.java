package generic.type_inference_06.generic_non_generic_classes;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Collections.emptyList();

        //编译器推送类型
        List<String> listone = Collections.emptyList();

        processStringList(listone);

        //报错，java8可以
        processStringList(Collections.emptyList());

        processStringList(Test.<String>emptyList());
        //报错，java8可以
        processStringList(Test.emptyList());
    }

    static <T> List<T> emptyList() {
        return null;
    }

    static void processStringList(List<String> strings) {

    }

}
