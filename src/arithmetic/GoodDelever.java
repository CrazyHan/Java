package arithmetic;

public class GoodDelever {
    public int shipWithinDays(int[] weights, int D) {
        int min = getMax(weights);
        int max = 0;
        for(int n : weights){
            max+=n;
        }
        System.out.println("min:"+min + "   max:"+max);
        // for(int i = max;i<=max; i++){}  这种方式有可能溢出，只能用二分查找

        while(min<=max){
            int mid = min + (max - min) / 2;
            if(canDelever(weights,mid,D)){
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return min;
    }

    public int getMax(int[] weights){
        int max = Integer.MIN_VALUE;
        for(int n : weights){
            if(max<n){
                max = n;
            }
        }
        return max;
    }

    public boolean canDelever(int[] weights,int weightPerDay,int D){

        int i = 0;


        for(int day = 0;day<D;day++){
            int weight = weightPerDay;
            while((weight -= weights[i]) >= 0){
                i++;
                if(i == weights.length){ //这样就是已经发完了
                    return true;
                }
            }

        }

        return false;

    }


    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,10};
        int x = 5;

        GoodDelever delever = new GoodDelever();


        System.out.println(delever.shipWithinDays(ints,x));
    }


}
