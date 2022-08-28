package bishiti.dongzi;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class T1 {


    public int changcheng(int[] nums) {
        // 1就是奇数 2就是偶数 找奇数偶数位置出现最多的两个数  其他数变成最多即可
        // 如果最大各不相同 直接就是，否则各看看自己最大和对方第二大
        HashMap<Integer, Integer> m1 = new HashMap<>();
        Map.Entry<Integer, Integer> e11 = new AbstractMap.SimpleEntry<>(-1, 0);
        Map.Entry<Integer, Integer> e12 = new AbstractMap.SimpleEntry<>(-1, 0);
        HashMap<Integer, Integer> m2 = new HashMap<>();
        Map.Entry<Integer, Integer> e21 = new AbstractMap.SimpleEntry<>(-1, 0);
        Map.Entry<Integer, Integer> e22 = new AbstractMap.SimpleEntry<>(-1, 0);

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                m2.put(nums[i], m2.getOrDefault(nums[i], 0) + 1);
                int times = m2.get(nums[i]);
                if (times > e21.getValue()) {
                    if (e21.getKey() != nums[i])
                        e22 = e21;
                    e21 = new AbstractMap.SimpleEntry<>(nums[i], times);
                } else if (times > e22.getValue()) {
                    e22 = new AbstractMap.SimpleEntry<>(nums[i], times);
                }
            } else {
                m1.put(nums[i], m1.getOrDefault(nums[i], 0) + 1);
                int times = m1.get(nums[i]);
                if (times > e11.getValue()) {
                    if (e11.getKey() != nums[i])
                        e12 = e11;
                    e11 = new AbstractMap.SimpleEntry<>(nums[i], times);
                } else if (times > e12.getValue()) {
                    e12 = new AbstractMap.SimpleEntry<>(nums[i], times);
                }
            }
        }

        int len = nums.length;
        if (e11.getKey() != e21.getKey()) {
            return len - e11.getValue() - e21.getValue();
        } else {
            // 比比奇数最多和偶数第二多   偶数最多和奇数第二多
            int fangan1 = len - e11.getValue() - e22.getValue();
            int fangan2 = len - e21.getValue() - e12.getValue();
            return Math.min(fangan1, fangan2);
        }
    }

    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        System.out.println(new T1().changcheng(new int[]{1, 9, 1, 9}));
        System.out.println(new T1().changcheng(new int[]{1, 9, 1, 9, 1}));
        System.out.println(new T1().changcheng(new int[]{1, 1, 4, 5, 1, 4}));
        System.out.println(new T1().changcheng(new int[]{1, 1, 4, 5, 1, 4, 7, 12, 2, 4}));
        System.out.println(new T1().changcheng(new int[]{1, 1, 1, 1, 1}));
        System.out.println(new T1().changcheng(new int[]{1, 1, 1, 1, 1, 1}));
        System.out.println(new T1().changcheng(new int[]{2, 2, 1, 1, 1, 1}));
        System.out.println(new T1().changcheng(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(new T1().changcheng(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(new T1().changcheng(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
}
