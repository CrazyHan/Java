package generic.type_erasure08.effects_type_erasure_brigde_methods;

public class MyNode extends Node<String> {

    public MyNode(String s){
      super(s);
    }

    public void setData(String data) {
        super.setData(data);
    }

}
