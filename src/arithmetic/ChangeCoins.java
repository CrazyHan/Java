package arithmetic;

import java.util.HashMap;
import java.util.Map;

public class ChangeCoins {

    public static void main(String[] args) {
        int[] sh = new int[]{1,2,5};
        System.out.println(coinChange(sh,100));
    }

    static Map<String, Integer> map = new HashMap<>();
    public static int coinChange(int[] coins, int amount) {
        //base case
        if (amount ==0) {
            return 0;
        }
        if(amount<0) return -1;

        if(map.get(amount+"") !=null){
            return map.get(amount+"");
        }

        int res = Integer.MAX_VALUE;
        for(int coin: coins){
            int sub = coinChange(coins,amount-coin);
            if(sub ==-1)  continue;
            res = Math.min(res,1+sub);
        }

        res = res!=Integer.MAX_VALUE ? res: -1;
        map.put(amount+"",res);

        return res;
    }

}
