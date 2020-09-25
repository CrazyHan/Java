package generic.type_erasure08.effects_type_erasure_brigde_methods;

public class Test {
    public static void main(String[] args) {

        MyNode mn = new MyNode("1");
        Node n = mn;
        n.setData("2");
//        String x = n.data;//这个不行，因为 n 是没有指定类型的
        String y = mn.data;



    }
}
