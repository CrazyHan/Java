package arithmetic;

import java.util.HashMap;
import java.util.Map;

public class FeiBo {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        System.out.println(fibHelper(map,6));

    }

    public static int fibHelper(Map<String,Integer> map, int n){
        if(n == 0) return 0;
        if(n == 1||n==2) return 1;
        if(map.get(n+"")!=null){
            return map.get(n+"");
        }
        int sum = fibHelper(map,n-1)+fibHelper(map,n-2);
        map.put(n+"",sum);
        return sum;
    }

}
