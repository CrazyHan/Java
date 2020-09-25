package generic.type_erasure08.erasure_generic_methods;

public class Test {

    public static void main(String[] args) {

    }

    public static <T> int count(T[] array, T elem) {
        int cnt = 0;
        for (T t : array) {
            if (t.equals(elem)) {
                ++cnt;
            }
        }
        return cnt;
    }

    public static <T extends Shape> void draw(T shape) {



    }


    class Shape{}

    class Circle extends Shape{}

    class Rectangle extends Shape{}

}
