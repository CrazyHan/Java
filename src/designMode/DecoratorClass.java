package designMode;

import util.PrintUtil;

/**
 * 在不改变现有对象结构的情况下，动态的给该对象增加一些职责
 */
public class DecoratorClass {

    /**
     * 抽象构件
     */
    interface Component{
        void operation();
    }

    /**
     * 抽象装饰
     * 里面扩展一个方法
     */
    static abstract class Decorator implements Component {

        public Component component;

        abstract void addSomething();
    }

    static class RealCompnent implements Component {


        @Override
        public void operation() {
            PrintUtil.println("我是" + getClass().getSimpleName());
        }


    }


    static class Decorator1 extends Decorator {

        @Override
        public void operation() {
            addSomething();
            component.operation();
        }

        @Override
        void addSomething() {
            PrintUtil.println("我是" + getClass().getSimpleName()+"穿一个红色衣服");
        }
    }


    static class Decorator2 extends Decorator {
        @Override
        public void operation() {
            component.operation();
            addSomething();
        }

        @Override
        void addSomething() {
            PrintUtil.println("我是" + getClass().getSimpleName()+"穿一个绿色衣服");
        }
    }




    public static void main(String[] args) {

    }

}
