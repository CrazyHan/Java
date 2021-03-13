package designMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 这种命令模式感觉不是我想象中的命令模式
 * 这种实现是有一个类A集成了所有的命令所要执行的动作，扩展的话需要修改这个内部逻辑
 * 命令接口只是对命令的一个具体操作放到了子类进行
 * 命令执行者只是对发送的命令进行一个封装，执行的时候进行挨个调用
 *
 *
 * 好像并不容易扩展呢？为什么叫命令模式
 */
public class CommandClass {


    public static void main(String[] args) {
        Broket broket = new Broket();

        Stock stock = new Stock();
        stock.quantity = 100;
        stock.name = "开始运动";

        broket.take(new BuyStock(stock));
        broket.take(new SellStock(stock));

        broket.execute();
    }


    //命令包装类
    static class Stock{

        public String name;
        public int quantity;

        public void buy() {
            System.out.println( name + "要买"+quantity);
        }

        public void sell() {
            System.out.println(name + "要卖" + quantity);
        }

    }


    static class Broket{

        List<Order> orders = new ArrayList<>();

        public void take(Order order) {
            orders.add(order);
        }


        public void execute() {
            for (Order order : orders) {
                order.execute();
            }
        }

    }


    interface  Order{
        void execute();
    }


    static class BuyStock implements Order{

        Stock stock;

        public BuyStock(Stock stock) {
            this.stock = stock;
        }

        @Override
        public void execute() {
            stock.buy();
        }
    }

    static class SellStock implements Order{

        Stock stock;

        public SellStock(Stock stock) {
            this.stock = stock;
        }

        @Override
        public void execute() {
            stock.sell();
        }

    }




}
