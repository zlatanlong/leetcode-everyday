package bishiti.hulu;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zlatanlong
 * @date 2022/9/16 19:31
 */
public class T2 {
    static class TreeNode {
        String val;
        List<TreeNode> children;

        public TreeNode(String str) {
            val = str;
        }

        public void add(TreeNode node) {
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(node);
        }
    }

    public static void main(String[] args) {
        String rawstr = "<root><1><2></2></1><3><6/></3><3/><4></4><5><7/><8><9><10><2/></10></9></8></5></root>";
        rawstr = "<moni>" + rawstr;
        int i = 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        while (i < rawstr.length()) {
            if (rawstr.charAt(i) == '<') {
                i++;
                StringBuilder cur = new StringBuilder();
                if (rawstr.charAt(i) != '/') {
                    // 需要闭合的标签
                    while (rawstr.charAt(i) != '/' && rawstr.charAt(i) != '>') {
                        cur.append(rawstr.charAt(i));
                        i++;
                    }
                    if (rawstr.charAt(i) == '/') {
                        // 不用闭合的标签
                        list.getLast().add(new TreeNode(cur.toString()));
                        i += 2;
                    } else if (rawstr.charAt(i) == '>') {
                        TreeNode curNode = new TreeNode(cur.toString());
                        list.addLast(curNode);
                        i++;
                    }
                } else {
                    // 需要闭合的标签
                    i++;
                    while (rawstr.charAt(i) != '>') {
                        cur.append(rawstr.charAt(i));
                        i++;
                    }
                    TreeNode lastNode = list.getLast();
                    if (!lastNode.val.equals(cur.toString())) {
                        System.out.println("不合法");
                    } else {
                        TreeNode curLeft = list.removeLast(); // 左标签
                        if (!list.isEmpty()) {
                            list.getLast().add(curLeft);
                        }
                    }
                    i++;
                }
            }
        }
        System.out.println(123);
        TreeNode root = list.getLast().children.get(0);// 此时list只有那个假结点
        Deque<TreeNode> printdeque = new LinkedList<>();
        printdeque.addLast(root);
        while (!printdeque.isEmpty()) {
            int size = printdeque.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = printdeque.removeFirst();
                System.out.print(node.val + " ");
                if (node.children != null) {
                    for (TreeNode child : node.children) {
                        printdeque.addLast(child);
                    }
                }
            }

        }
    }
}
