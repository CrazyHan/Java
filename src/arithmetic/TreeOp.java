package arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeOp {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    List<TreeNode> duplicateList;
    Map<String,Integer> childTreeString;
//    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
//        duplicateList = new ArrayList<>();
//        childTreeString = new HashMap<>();
//        findDuplicateSub(root);
//    }

    public String findDuplicateSub(TreeNode root){
        if(root == null) return "";




        StringBuffer buffer = new StringBuffer();
        buffer.append(root.val).append(',').append(findDuplicateSub(root.left)).append(",")
                .append(findDuplicateSub(root.right));//带有前面信息的链

//        childTreeString.put(buffer., toString(), childTreeString.getOrDefault(buffer.toString(), 0) + 1);


        if (childTreeString.get(buffer.toString()) == 2) {
            duplicateList.add(root);
        }
        return null;

    }


}
