package generic.type_inference_06.generic_non_generic_classes;

public class MyClass<X> {

    <T> MyClass(T t){

    }

    public static void main(String[] args) {
        new MyClass<Integer>("");

        MyClass<Integer> myObject = new MyClass<Integer>("");
    }

}
