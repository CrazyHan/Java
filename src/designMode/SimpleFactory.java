package designMode;

import util.PrintUtil;

/**
 * 简单工厂：
 *     1、只对生产的物品进行一个抽象
 *     2、工厂使用if或者switch进行选择性返回所需物品
 * 对于产品种类相对较少的情况，考虑使用简单工厂模式。使用简单工厂模式
 * 的客户端只需要传入工厂类的参数，不需要关心如何创建对象的逻辑，可以
 * 很方便地创建所需产品。
 */
public class SimpleFactory {

    interface Product {
        void show();
    }


    static class CarProduct implements Product {

        @Override
        public void show() {
            PrintUtil.println("我是" + getClass().getSimpleName());
        }
    }

    static class BusProduct implements Product {

        @Override
        public void show() {
            PrintUtil.println("我是" + getClass().getSimpleName());
        }
    }

    static class SimpleFactor {

        public static final String CAR_PRODUCT = "car";
        public static final String BUS_PRODUCT = "bus";


        public static Product getProduct(String name) {

            switch (name) {
                case BUS_PRODUCT:
                    return new BusProduct();
                case CAR_PRODUCT:
                    return new CarProduct();

                default:
                    PrintUtil.println("输入参数错误");
                    return null;

            }

        }

    }


    public static void main(String[] args) {
        Product car = SimpleFactor.getProduct(SimpleFactor.CAR_PRODUCT);
        car.show();


        car = SimpleFactor.getProduct(SimpleFactor.BUS_PRODUCT);
        car.show();


    }

}
