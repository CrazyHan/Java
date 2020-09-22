package generic.type_inference_06;

import javax.xml.soap.Text;
import java.io.Serializable;
import java.util.ArrayList;

public class Test {

    static <T> T pick(T a1,T a2){
        return a2;
    }

    public static void main(String[] args) {
        Serializable s = Test.<Serializable>pick("d", new ArrayList<String>());
    }
}
