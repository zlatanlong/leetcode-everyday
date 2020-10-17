package problems.t977;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/16 14:51
 */
public class Solution {


    /**
     * 思路：先用一个指针找到最后一个小于0的点，从该指针往前，另一个指针往后
     *
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int toLeft = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0) {
                break;
            }
            toLeft = i;
        }
        int toRight =  toLeft + 1;
        for (int i = 0; i < A.length; i++) {
            if (toRight == A.length
                    || toLeft >= 0 && -A[toLeft] <= A[toRight]) {
                res[i] = A[toLeft] * A[toLeft--];
            } else {
                res[i] = A[toRight] * A[toRight++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().sortedSquares(new int[]{-1});
    }

}
