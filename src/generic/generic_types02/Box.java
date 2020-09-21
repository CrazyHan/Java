package generic.generic_types02;

import java.util.List;
/** 泛型接口 */
interface Generics<T> {

}
/** 泛型接口 */
interface GenericsN<T,S,U,V>{

}

class GenericsMethod{
    public void test(Object o) {

    }
    /**
     * 泛型方法
     */
    public <T> T test1(T t) {
        return t;
    }

    public void test2(List<String> list) {

    }

    public void test3(List<?> list) {

    }

}
/** 泛型类 */
public class Box<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    /** 限定类型参数 */
    public <U extends Number> void test(U u) {
        System.out.println(t.getClass().getName());
        System.out.println(u.getClass().getName());

    }

    public static void main(String[] args) {

        Box box = new Box();
        Box<Integer> integerBox = new Box<>();//类型推断
        //参数化类型，请为形式类型参数 T 提供一个实际的类型参数
        Box<Integer> integerBox1 = new Box<Integer>();
        //允许将参数化类型分配给其原始类型
        box = integerBox;
        Box box1 = new Box();


        integerBox1 = box1;

    }

    static Box createBox() {
        return new Box();
    }


}
