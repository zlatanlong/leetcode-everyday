package hot100;

import java.util.HashMap;
import java.util.Map;

public class T105 {
    Map<Integer, Integer> in;

    public void helper(int[] pre, int pL, int pR, int iL, int iR, int[] post, int poL, int poR) {
        if (pL == pR)
            return;
        int root = pre[pL];
        // 后序数组中，当前树的最后一个节点是根节点
        post[poR-1] = root;
        int index = in.get(root);
        // 左子树的长度
        int lLength = index - iL;
        // 左子树
        helper(pre, pL + 1, pL + lLength + 1, iL, index, post, poL, poL + lLength);
        helper(pre, pL + lLength + 1, pR, index + 1, iR, post, poL + lLength, poR - 1);
    }

    public void buildTree(int[] preorder, int[] inorder) {
        in = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        int[] post = new int[preorder.length];
        helper(preorder, 0, preorder.length, 0, inorder.length, post, 0, inorder.length);

        for (int i = 0; i < post.length; i++) {
            System.out.print(post[i]+", ");
        }
    }

    public static void main(String[] args) {
        T105 t = new T105();
        t.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
    }

}
