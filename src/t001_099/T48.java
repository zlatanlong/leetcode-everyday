package t001_099;

/**
 * @author zlatanlong
 * @date 2021/7/23 11:52
 */
public class T48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < (len + 1) / 2; i++) {
            // i是当前i*i的
            int curLen = len - i * 2;
            for (int j = i; j < len - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[curLen - 1 - j][i];
                matrix[curLen - 1 - j][i] = matrix[curLen - 1 - i][curLen - 1 - j];
                matrix[curLen - 1 - i][curLen - 1 - j] = matrix[j][curLen - 1 - i];
                matrix[j][curLen - 1 - i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println('['-']');
        System.out.println('('-')');
        System.out.println('{'-'}');
    }
}
