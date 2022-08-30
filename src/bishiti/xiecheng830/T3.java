package bishiti.xiecheng830;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zlatanlong
 * @date 2022/8/30 20:39
 */
public class T3 {
    static class TreeNode {
        int rgb;

        public TreeNode() {
        }

        public TreeNode(int rgb) {
            this.rgb = rgb;
        }

        List<TreeNode> nodes;

        public void addNode(TreeNode node) {
            if (nodes == null) nodes = new ArrayList<>();
            nodes.add(node);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String rgb = scanner.nextLine();
        TreeNode[] nodes = new TreeNode[n];

        for (int i = 0; i < rgb.length(); i++) {
            if (rgb.charAt(i) == 'r') {
                nodes[i] = new TreeNode(0);
            }
            if (rgb.charAt(i) == 'g') {
                nodes[i] = new TreeNode(1);
            }
            if (rgb.charAt(i) == 'b') {
                nodes[i] = new TreeNode(2);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            String[] ss = scanner.nextLine().split("\\s");
            nodes[Integer.parseInt(ss[0])].addNode(nodes[Integer.parseInt(ss[1])]);
        }

    }
}
