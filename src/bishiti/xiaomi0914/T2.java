package bishiti.xiaomi0914;

import util.TreeNode;

public class T2 {

    public class Solution {

        public TreeNode Convert(TreeNode pRootOfTree) {
            TreeNode p = pRootOfTree, pre = null, res = null;
            while (p != null) {
                while (p.left != null) {
                    TreeNode q = p.left;
                    while (q.right != null) {
                        q = q.right;
                    }
                    q.right = p;
                    TreeNode tmp = p.left;
                    p.left = null;
                    p = tmp;
                }
                p.left = pre;
                if (pre == null) {
                    res = p;
                } else {
                    pre.right = p;
                }
                pre = p;
                p = p.right;
            }
            return res;
        }
    }

}
