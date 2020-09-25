package generic.type_erasure08.erasure_generic_types;

public class Test {
    public static void main(String[] args) {

    }
}

/**
 * 没有边界就换成 Object
 * @param <T>
 */
class Node<T>{
    private T data;
    private Node<T> next;

    public Node(T t, Node<T> next) {
        this.data = t;
        this.next = next;
    }

    public T getData() {
        return data;
    }
}

/**
 * 编译器把类型参数 T 替换为第一个绑定类 Comparable
 * @param <T>
 */
class Node1<T extends Comparable<T>>{
    private T data;
    private Node1<T> next;

    public Node1(T t, Node1<T> next) {
        this.data = t;
        this.next = next;
    }

    public T getData() {
        return data;
    }

}