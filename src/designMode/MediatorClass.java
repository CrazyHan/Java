package designMode;

import java.util.Date;

/**
 * 关系复杂，又不想写子类去实现，就用中介者
 */
public class MediatorClass {

    static class ChatRoom{
        static void showMessage(User user, String msg) {
            System.out.println(new Date().toString()
                    + " [" + user.name +"] : " + msg);
        }
    }

    static class User {

        public String name;

        public User(String name){
            this.name = name;
        }

        public void sendMessage(String msg) {
            ChatRoom.showMessage(this, msg);
        }

    }

    public static void main(String[] args) {
        User user = new User("Tom");
        user.sendMessage("您好Jay");

        user = new User("Jay");

        user.sendMessage("您好Tome");
    }



}
