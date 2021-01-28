package arithmetic;

public class RemoveElement {


    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int p = 0;
        int q = 1;

        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[++p] = nums[q];
                q++;
            }else{
                q++;
            }
        }

        return p + 1;

    }

    public int removeElement(int[] nums, int val) {
        return 0;
    }


    public static void main(String[] args) {


        RemoveElement removeElement = new RemoveElement();

        removeElement.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
}
