package thread;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ThreadBase {

    public static void main(String[] args) throws InterruptedException {

        testOrder2();

    }

    public static void testOrder2() {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread thread1 = new Thread("线程1") {
            @Override
            public void run() {
                super.run();
                System.out.println(getName() + "执行任务3秒");
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "执行完成");
                countDownLatch.countDown();
            }
        };
        thread1.start();

        Thread thread2 = new Thread("线程2") {
            @Override
            public void run() {
                super.run();
                System.out.println(getName() + "执行任务3秒");
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "执行完成");
                countDownLatch.countDown();
            }
        };
        thread2.start();

        try {
            countDownLatch.await(5, TimeUnit.SECONDS);
            System.out.println(Thread.currentThread().getName() + "执行任务等不及了，后面先执行了"+countDownLatch.getCount());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void testOrder(){
        System.out.println(Thread.currentThread().getName()+"排队打饭中");

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println(getName()+"来排队打饭");

                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println(getName() + "打完饭");
            }
        };
        thread1.setName("第一名");



        thread1.start();


        Thread thread2 = new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println(getName()+"来排队打饭");

                System.out.println(getName() + "发现第一名来打饭，让他插队");

                try {
                    thread1.join();

                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "打完饭");
            }
        };

        thread2.setName("第二名");

        thread2.start();

        System.out.println(Thread.currentThread().getName() + "发现第二名来打饭，让他插队");

        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("自己打打饭");
    }


}
