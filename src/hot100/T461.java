package hot100;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/23 15:29
 */
public class T461 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        // 布赖恩·克尼根算法
        while (xor != 0) {
            distance += 1;
            // remove the rightmost bit of '1'
            xor = xor & (xor - 1);
        }
        return distance;
    }
}
