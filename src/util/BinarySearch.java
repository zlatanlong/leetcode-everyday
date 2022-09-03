package util;

public class BinarySearch {


    /**
     * @param x
     * int m = (l + r + 1) >>> 1; 向上取整 l=m, r=m-1
     * int m = (l + r) >>> 1; 向下取整， l=m+1, r=m
     * 举例 当 l=2 r=3时 向下取整 m=2 此时 l=m将陷入循环 所以l=m+1
     *     当 l=2 r=3时 向上取整 m=3 此时 r=m将陷入循环 所以r=m-1
     * @return
     */
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            int m = (l + r + 1) >>> 1;
            if ((long) m * m == x) return m;
            if ((long) m * m < x) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
