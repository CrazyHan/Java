package arithmetic;

public class FindMissingNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{1};

        System.out.println(missingNumber(nums)+"");

    }

    public static int missingNumber(int[] nums) {
        int i,j;
        i = 0;
        j = nums.length-1;

        if(i==j){
            return 0;
        }



        while(j-i!=1){
            int middle = (j-i)/2+i;

            if((nums[middle]-nums[i])!=(middle-i)){
                j = middle;
            }else{
                i = middle;
            }
        }
        if(i!=0) {
            return nums[i] + 1;
        }else{
            return nums[j]-1;
        }

    }

}
