package generic.whildcards07.wildcard_capture_helper_methods;

import java.util.List;

public class Test {

    public static void main(String[] args) {

    }

}
class WildcardError{
    /**
     * 在此示例中，编译器将i输入参数处理为Object类型。当foo方法调用List.set(int, E)时，
     * 编译器无法确认要插入列表中的对象的类型，并产生错误。当发生这种类型的错误时，
     * 通常意味着编译器认为你正在将错误的类型分配给变量。
     * 为此，将泛型添加到Java语言中（以便在编译时强制类型安全）
     * @param
     */
    void foo(List<?> list) {
//        list.set(0, new Object());
    }
}

class WildcardFixed{
    void foo(List<?> list) {
        help(list);
    }
/**
 * 在此示例中，代码正在尝试执行安全操作，那么如何解决编译器错误？
 * 你可以通过编写捕获通配符的私有帮助器方法来修复它。在这种情况下，
 * 你可以通过创建私有帮助器方法fooHelper来解决此问题
 *
 * 由于使用了辅助方法，编译器在调用中使用推断来确定T是CAP＃1（捕获变量）。该示例现在可以成功编译。
 *
 * 按照约定，辅助方法通常命名为originalMethodNameHelper
 */
    public <T> void help(List<T> list) {
        list.set(0, list.get(0));
    }

}

class WildcardErrorBad{
/**
 * 虽然List<Integer>和List<Double>都满足了List<? extends Number>的条件，
 * 但从Integer值列表中提取一个项并试图将其放入Double值列表中显然是不正确的
 */

    void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
        Number number = l1.get(9);
        //这样是不行的没有一个准确的类型
//        l1.set(0, l2.get(0));

    }

    void swapSecond(List<?> l1, List<?> l2) {
        //不行哦
//        swapHelper(l1, l2);
    }

    //没有解决此问题的辅助方法，因为代码根本上是错误的,这里辅助方法也没有用
    private <T> void swapHelper(List<T> t1, List<T> t2) {
        t1.set(0, t2.get(0));
    }

}