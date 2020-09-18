package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class AnotationReview {


    public static void main(String[] args) throws NoSuchFieldException {
        Class cls = AnotationReview.class;
        Field field = cls.getDeclaredField("one");
        AnnotationOne annotationOne = field.getAnnotation(AnnotationOne.class);
        System.out.println(annotationOne.value());
    }

    //-------------- 回忆1、自定义注解 BEGIN --------------
    @Target({ElementType.FIELD,ElementType.METHOD})//这个是作用域，指定使用在哪里，Target 为 ANNOTATION_TYPE 的叫做元注解，使用在注解上面的注解
    @Retention(RetentionPolicy.RUNTIME)//这个是生命周期，如果生命周期不对有可能报空指针异常
    public @interface AnnotationOne{
        String value();
        int id() default 1;
    }
    @AnnotationOne(value = "show")
    int one;

    /**
     * test code
     *
     *         Class cls = AnotationReview.class;
     *         Field field = cls.getDeclaredField("one");
     *         AnnotationOne annotationOne = field.getDeclaredAnnotation(AnnotationOne.class);
     *         System.out.println(annotationOne.value());
     *
     * 总结：
     * 1、Target 为 ANNOTATION_TYPE 的叫做元注解，使用在注解上面的注解
     * 2、属性可以通过 default 关键字给默认值
     * 3、使用getAnnotations()得到所有注解信息。使用getAnnotation(clazz),getDeclaredAnnotation(clazz)得到对应的注解对象
     *
     */

    //-------------- 回忆1、自定义注解 END --------------

}
