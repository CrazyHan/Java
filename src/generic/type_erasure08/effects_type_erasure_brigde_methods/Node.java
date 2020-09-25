package generic.type_erasure08.effects_type_erasure_brigde_methods;

public class Node<T> {

    public T data;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
