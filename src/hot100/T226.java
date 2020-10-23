package hot100;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/23 14:02
 */
public class T226 {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) {
            return root;
        }
        TreeNode left = root.left;
        // 前序dfs
        root.left = invertTree(root.right);
        root.right = invertTree(left);

        return root;
    }
}
