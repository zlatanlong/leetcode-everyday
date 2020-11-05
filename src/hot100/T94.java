package hot100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class T94 {

    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        stack.push(root);
        while(!stack.isEmpty()){
            while(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
        
            if(node.right!=null) {
                cur = node.right;
            }
        }

        return res;
    }

}
