package designMode;

import util.PrintUtil;

/**
 *
 * 系统中有多个产品族，每个具体工厂创建同一族但属于不同等级结构的产品。
 * 系统一次只可能消费其中某一族产品，即同族的产品一起使用。
 */
public class AbstractFactory {

    interface Factory{
        Television makeTelevision();

        Radio makeRadio();

    }

    interface Product{
        void show();
    }

    interface Television extends Product{}

    interface Radio extends Product{}

    static class MeidiFactory implements Factory{

        @Override
        public Television makeTelevision() {
            return new MeidiTelevision();
        }

        @Override
        public Radio makeRadio() {
            return new MeidiRadio();
        }
    }

    static class GeliFacotry implements Factory {

        @Override
        public Television makeTelevision() {
            return new GeliTelevision();
        }

        @Override
        public Radio makeRadio() {
            return new GeliRadio();
        }
    }

    static class MeidiTelevision implements Television{

        @Override
        public void show() {
            PrintUtil.println("我是" + getClass().getSimpleName());
        }
    }

    static class MeidiRadio implements Radio {

        @Override
        public void show() {
            PrintUtil.println("我是" + getClass().getSimpleName());
        }
    }

    static class GeliTelevision implements Television {

        @Override
        public void show() {
            PrintUtil.println("我是" + getClass().getSimpleName());
        }
    }

    static class GeliRadio implements Radio {

        @Override
        public void show() {
            PrintUtil.println("我是" + getClass().getSimpleName());
        }
    }


    public static void main(String[] args) {
        Factory factory = new GeliFacotry();
        Product product = factory.makeRadio();
        product.show();

        product = factory.makeTelevision();
        product.show();


        factory = new MeidiFactory();
        product = factory.makeTelevision();
        product.show();

        product = factory.makeRadio();
        product.show();

    }

}
