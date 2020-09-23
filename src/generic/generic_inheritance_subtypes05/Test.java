package generic.generic_inheritance_subtypes05;

import generic.generic_types02.Box;
import generic.scene1.Plate;

import java.util.*;

/**
 * 总结：
 * 1、无论 A，B 是否想关，Class<A> Class<B>是没有关系的
 * 2、泛型类的泛型参数相同，泛型类的子类是有继承关系的
 */
public class Test {
    public static void main(String[] args) {
        //第一组
        Object object = new Object();

        Integer integer = new Integer(10);
        //可以把对象给obj
        object =integer;

        //第二级
        test0(new Integer(10));
        test0(new Float(20));



        //第三组
        //这样是不行的
        //无论 A，B 是否想关，Class<A> Class<B>是没有关系的
//        Box<Integer> box = new Box<>();
//        test(box);



        //第四组
        MyList<String, Integer> myList = new MyList<>();
        MyList<String, Exception> myList1 = new MyList<>();
       //泛型类的泛型参数相同，泛型类的子类是有继承关系的
        test2(myList);
        test2(myList1);


        //第五组
        List<String> stringList = new ArrayList<>();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList1 = new ArrayList<>();

        arrayList = (ArrayList<String>) stringList;//强转解决

        stringList = arrayList;//可以直接
//类型校验不通过
//        stringList = arrayList1;


        //类型参数具有继承，和泛型类也具有继承，能进行转换吗？
        //结果看样子是没有问题的
        ArrayList<Integer> integers = new ArrayList<>();
        test3(integers);


    }

    public static void test0(Number numberBox) {}

    //Box<Number> Box<Integer> 没有关系
    public static void test(Box<Number> numberBox) {}

    //泛型类继承关系
    static void test2(List<String> strings) {

    }

    //类型参数具有继承，和泛型类也具有继承，能进行转换吗？
    static <T extends Number> void test3(List<T> list) {

    }


}


interface PayloadList<T, K> extends List<T>{
    void setPayload(int index, K val);

}

class MyList<T, K> implements PayloadList<T, K>{

    @Override
    public void setPayload(int index, K val) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}

