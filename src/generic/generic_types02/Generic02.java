package generic.generic_types02;

public class Generic02 {

    public static void main(String[] args) {
        Box box = new Box();
        box.set("xxxx");
        box.get();
    }

    static class Box{
        private Object object;

        public Object get() {
            return object;
        }

        public void set(Object object) {
            this.object = object;
        }
    }

}
