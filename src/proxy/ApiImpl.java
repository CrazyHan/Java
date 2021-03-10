package proxy;

public class ApiImpl implements Api {

    @Override
    public void test(String a) {
        System.out.println("真实实现：" + a);
    }
}
