package generic.why_use01;

import java.util.ArrayList;
import java.util.List;

public class Generic01 {

    public static void main(String[] args) {
        method1();
        method2();
    }

    /** 需要强转 */
    static void method1(){
        List list = new  ArrayList();
        list.add("shello");
        String s = (String) list.get(0);
    }

    static void method2() {
        List<String> list = new ArrayList();
        list.add("dddd");
        String s = list.get(0);
    }

}
