package thread;


public class ThreadBase {

    public static void main(String[] args) throws InterruptedException {

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

        thread2.join();


        System.out.println("自己打打饭");

    }




}
