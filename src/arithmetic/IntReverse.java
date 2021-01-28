package arithmetic;

public class IntReverse {
    /**
     * 数字翻转
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x == 0) return 0;
        int result = 0;
        int pop = 0;
        while (x != 0) {
            pop = x % 10;
            x = x / 10;
            //为了为避免逸出问题只能在乘法之前添加判断
            // if(result>Integer.MAX_VALUE/10) return 0;
            // if(result<Integer.MIN_VALUE/10)return 0;
            if (result * 10 / 10 != result) {
                return 0;
            }
            result = result * 10 + pop;
            System.out.println("x=" + x + "   result=" + result);
        }
        return result;
    }

    /**
     * 还是一个意思
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int inital = x;
        int pop = 0;
        int revers = 0;
        while (x != 0) {

            pop = x % 10;
            x = x / 10;

            if (revers > Integer.MAX_VALUE / 10) return false;


            revers = revers * 10 + pop;
            System.out.println("x=" + x + "   result=" + revers);

        }

        if (revers == inital) {
            return true;
        } else {
            return false;
        }
    }

    //输入1534236469 时当最后一位乘10会越界变成一个不对的数
    public static void main(String[] args) {
        IntReverse intReverse = new IntReverse();
//        intReverse.reverse(1534236469);
        System.out.println(intReverse.isPalindrome(121));
    }


}
