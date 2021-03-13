package designMode;

import util.PrintUtil;

/**
 * 工厂方法
 *    1、工厂生产单一产品（只有一个方法）
 *    2、每个工厂只能生产对应一个产品
 * 客户只知道创建产品的工厂名，而不知道具体的产品名。如 TCL 电视工厂、海信电视工厂等。
 * 创建对象的任务由多个具体子工厂中的某一个完成，而抽象工厂只提供创建产品的接口。
 * 客户不关心创建产品的细节，只关心产品的品牌
 */
public class MethodFactory {


    interface Factory{
        Product makeProduct();
    }


    interface Product{
        void show();
    }


    static class CarFactory implements Factory {
        @Override
        public Product makeProduct() {
            return new CarProduct();
        }
    }

    static class BusFactory implements Factory {
        @Override
        public Product makeProduct() {
            return new BusProduct();
        }
    }

    static class CarProduct implements Product{

        @Override
        public void show() {
            PrintUtil.println("我是" + getClass().getSimpleName());
        }
    }

    static class BusProduct implements Product{

        @Override
        public void show() {
            PrintUtil.println("我是" + getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        Factory factory = new CarFactory();
        Product product = factory.makeProduct();
        product.show();

        factory = new BusFactory();
        product = factory.makeProduct();
        product.show();

    }

}
