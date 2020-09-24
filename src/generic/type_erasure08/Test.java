package generic.type_erasure08;

import java.util.ArrayList;

public class Test {

    static class Pair<T>{
        private T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }


    public static void main(String[] args) {
        Pair<String> pair = new Pair<>();
        pair.setValue("myvalue");

        System.out.println(pair);


        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();

        System.out.println(arrayList.getClass() ==  arrayList1.getClass());

    }

}
