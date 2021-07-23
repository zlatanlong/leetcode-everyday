package ms100;

public class T108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;

        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);

        int[] left = new int[mid];
        int[] right = new int[nums.length - mid -1];
        for (int i = 0; i < left.length; i++) {
            left[i]=nums[i];
        }
        for (int i = mid+1; i < nums.length; i++) {
            right[i] = nums[i];
        }
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);

        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}