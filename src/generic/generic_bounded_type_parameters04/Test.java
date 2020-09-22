package generic.generic_bounded_type_parameters04;

public class Test {

    public static <T> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
//        for (T t : anArray) {
//            方法的实现很简单，但是不能编译，因为大于运算符（>）仅适用于基本类型，
//            if (t > elem) {
//                ++count;
//            }
//        }
        return count;
    }

    //限定为 Comparable 及其子类
    public static <T extends Comparable<T>> int count(T[] anArray, T elem) {

        int count = 0;
        for (T t : anArray) {
            if (t.compareTo(elem) > 0) {
                ++count;
            }
        }
        return count;
    }

}
