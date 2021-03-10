package arithmetic;

public class Sourt {


    public static void main(String[] args) {
        int[] nums = new int[]{9,8,7,45,6,4,1,2,3};
//        selectSort(nums);
//        insertSort(nums);
//        popSort(nums);
//        shellSort(nums);
//        quickSort(nums,0,nums.length-1);
        mergeSort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.print(num+",");
        }
    }


    /**
     * 快排就是选中一个基点（平时使用left） 然后从右边找到一个比基点小的，然后从左边找到一个比基点大的，他们两个互换，直到low = hi。跳出循环进行基点判断，并是否需要交换
     * 递归
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(int[] nums,int left, int right){

        if(left>= right) return;
        int anchor = left;

        int i = left+1;
        int j = right;

        while(i<j) {
            while (i < j && nums[anchor] < nums[j]) {
                j--;
            }

            while (i <j && nums[anchor] > nums[i]) {
                i++;
            }

             swapViaTemp(nums,i,j);

        }

        if(nums[anchor]>nums[i]){
            swapViaTemp(nums,anchor,i);
        }
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);

    }


    public static int[] mergeSort(int[] nums,int left, int right){

        if(left<right){
            int mid = (left+right)/2;
            nums = mergeSort(nums,left,mid);

            nums = mergeSort(nums,mid+1,right);

            merge(nums,left,mid,right);

        }
        return nums;
    }

    public static int[] merge(int[] nums, int left, int mid, int right) {

        int[] temp = new int[right-left+1];
        int leftPoint = left;
        int rightPoint = mid+1;

        int tempPoint = 0;

        while (leftPoint <= mid && rightPoint <= right) {
            if(nums[leftPoint]<=nums[rightPoint]){
                temp[tempPoint++] = nums[leftPoint];
                leftPoint++;
            }else{
                temp[tempPoint++] = nums[rightPoint];
                rightPoint++;
            }
        }

        while(leftPoint>mid&& rightPoint<=right){
            temp[tempPoint++] = nums[rightPoint];
            rightPoint++;
        }

        while(rightPoint>right&& leftPoint <= mid){
            temp[tempPoint++] = nums[leftPoint];
            leftPoint++;
        }

        for (int i = 0; i < tempPoint; i++) {
            nums[left++] = temp[i];
        }
        return temp;
    }

    /**
     * 选择排序，每次选择最小的进行排序
     * @param nums
     * @return
     */
    public static int[] selectSort(int[] nums){
        int length = nums.length;
        for (int i = 0; i < length; i++) {

            int min = i;

            for (int j = i+1; j < length; j++) {
                if(nums[min]>nums[j]) {
                    System.out.println("min = "+ nums[min]+ " j = " +nums[j]);
                    min = j;

                }
            }
            if(nums[i]>nums[min]) {
                swapViaNoSpace(nums, i, min);
            }
        }
        return nums;
    }

    /**
     * 按顺序每次拿出一个，插入到前面已经排序的数组中
     * @param nums
     * @return
     */
    public static int[] insertSort(int[] nums){

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j >0; j--) {
                if(nums[j-1]>nums[j]){
                    swapViaTemp(nums,j-1,j);
                }else{
                    break;
                }
            }
        }
        return nums;
    }

    /**
     *
     * @param nums
     * @return
     */
    public static int[] popSort(int[] nums){

        for (int i = 0; i <= nums.length-1; i++) {
            for (int j = 0; j < nums.length-1 -i; j++) {
                if(nums[j] >nums[j+1]){
                    swapViaTemp(nums,j,j+1);
                }
            }
        }
        return nums;

    }

    public static void swapViaTemp(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void swapViaNoSpace(int[] nums,int left,int right){
        nums[left] = nums[right] + nums[left];
        nums[right] = nums[left] - nums[right];
        nums[left] = nums[left] - nums[right];
    }
}
