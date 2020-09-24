package generic.type_erasure08.non_reifiable_types;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        Box<Integer> integerBox = new Box<>();
        Box<Object> objectBox = new Box<>();

        //报错
//        stringBox = objectBox;

        System.out.println(stringBox instanceof Box);

        if(stringBox instanceof Box){

        }
        if(integerBox instanceof Box){

        }
        if(objectBox instanceof Box){

        }

        System.out.println("result:="+stringBox.equals(integerBox));
//不能这样使用的 //没有泛型数组
//        Box<String>[] boxes = new Box<String>[]{new Box<String>()};

        Box<?>[] ar = new Box<?>[]{new Box<>()};

    }
}
class Box<T>{
    T t;
}