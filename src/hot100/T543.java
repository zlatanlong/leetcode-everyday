package hot100;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/23 19:12
 */
public class T543 {

    private int maxLength = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxLength;
    }

    public int helper(TreeNode root) {
        if (root==null) {
            return 0;
        }
        int ld = helper(root.left);
        int rd = helper(root.right);

        if ((ld+rd)>maxLength) {
            maxLength = ld + rd;
        }
        return Math.max(ld,rd) + 1;
    }
}
