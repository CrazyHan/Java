package proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) throws IOException {
        ApiImpleClass api = new ApiImpleClass();
        ApiClass proxy = (ApiClass) Proxy.newProxyInstance(api.getClass().getClassLoader(), new Class[]{ApiClass.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(api, args);
                    }
                });
        proxy.test("saaa");

        String name = Api.class.getName()+"$Proxy0";
        //生成代理指定接口的Class数据
        byte[] bytes = ProxyGenerator.generateProxyClass(name, new Class[]{ApiClass.class});
        File file = new File(  name + ".class");
        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println(file.getAbsolutePath());
        FileOutputStream fos = new FileOutputStream(name+".class");
        fos.write(bytes);
        fos.close();

    }


}
