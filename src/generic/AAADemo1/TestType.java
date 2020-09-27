package generic.AAADemo1;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class TestType {

    Map<String, Integer> map;

    public static void main(String[] args) {
        try {
            Field f = TestType.class.getDeclaredField("map");
            System.out.println(f.getGenericType());//java.util.Map<java.lang.String, java.lang.Integer>
            System.out.println(f.getGenericType() instanceof ParameterizedType);//true
            ParameterizedType type = (ParameterizedType) f.getGenericType();
            System.out.println(type.getRawType());//interface java.util.Map
            for (Type type1 : type.getActualTypeArguments()) {
                System.out.println(type1);//class java.lang.String  class java.lang.Integer
            }
            System.out.println(type.getOwnerType());//null

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
