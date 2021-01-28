package arithmetic;

public class CommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int indexCurrentSame =-1;
        if (strs.length == 0) {
            return "";
        }
        int maxCompareTime = strs[0].length();

        char indexAtThen = 1;
        for (int i = 0; i < maxCompareTime; i++) {
            indexAtThen = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {

                if (strs[j].length() <= i) {
                    if(indexCurrentSame>=0)
                        return strs[j].substring(0, indexCurrentSame+1);
                    else
                        return "";
                }
                char c = strs[j].charAt(i);
                if (indexAtThen != c) {
                    if(indexCurrentSame>=0)
                        return strs[j].substring(0, indexCurrentSame+1);
                    else
                        return "";
                }

            }
            indexCurrentSame = i;
        }
        if(indexCurrentSame>=0)
            return strs[0].substring(0, indexCurrentSame+1);
        else
            return "";

    }

    public static void main(String[] args) {
        CommonPrefix prefix = new CommonPrefix();
        System.out.println(prefix.longestCommonPrefix(new String[]{"ab","a"}));
    }

}
