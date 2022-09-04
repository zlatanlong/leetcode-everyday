package bishiti.wangyi0904;

import java.util.*;

/**
 * @author zlatanlong
 * @date 2022/9/4 15:56
 */
public class T4 {

    static class TreeNode {
        List<TreeNode> children;
        int q;
        int count;
        boolean visited;

        public TreeNode() {
        }

        public TreeNode(int q) {
            this.q = q;
        }

        public void add(TreeNode node) {
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(node);
        }
    }

    public static int qiuyinzi(int n) {
        if (n == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                ans++;
                if (n == i * i) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 求此节点以下所有因子
     *
     * @param node
     * @return
     */
    public static int dfs(TreeNode node) {
        if (node == null || node.visited) {
            return 0;
        }
        int count = 0;
        if (node.children != null) {
            for (TreeNode child : node.children) {
                count += dfs(child);
            }
        } else {
            count = qiuyinzi(node.q);
            node.q = 0;
        }
        node.count = count;
        node.visited = true;
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(sc.nextInt());
        }
        int[][] gx = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            int i1 = sc.nextInt();
            int i2 = sc.nextInt();
            gx[i][0] = Math.min(i1, i2);
            gx[i][1] = Math.max(i1, i2);
        }
        sc.nextLine();
        Arrays.sort(gx, Comparator.comparingInt(e -> e[0]));

        for (int[] ints : gx) {
            nodes[ints[0] - 1].add(nodes[ints[1] - 1]);
        }
        for (int i = 0; i < n; i++) {
            dfs(nodes[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += nodes[i].count;
            ans %= 10e9 + 7;
        }
        System.out.println(ans);
    }
}

