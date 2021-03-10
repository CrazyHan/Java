package arithmetic;

public class EatBanana {

    public int minEatingSpeed(int[] piles, int H) {

        int min = 1;
        int max = getMax(piles);

        for(int i = min;i<=max;i++){
            if(canFinish(piles,i,H)){
                return i;
            }
        }
        return min;
    }

    public boolean canFinish(int[] piles,int speed,int H){
        int time = 0;
        for(int i = 0; i< piles.length;i++){
            time += timeOf(piles[i],speed);
            System.out.println(time);
        }

        if(time >H){
            return false;
        }else {
            return true;
        }

    }
    public int timeOf(int nums,int speed){
        return (nums/speed)+(nums%speed >0 ? 0:1);
    }

    public int getMax(int[] piles){

        int max = Integer.MIN_VALUE;
        for(int i = 0;i< piles.length;i++){
            if(max<piles[i]){
                max = piles[i];
            }
        }
        return max;
    }



    public static void main(String[] args) {
        int[] param = new int[]{332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        int hour = 823855818;

        EatBanana banana = new EatBanana();
        System.out.println(banana.minEatingSpeed(param,hour));
    }

}
