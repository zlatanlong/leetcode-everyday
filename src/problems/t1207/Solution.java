package problems.t1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i]))
                map.put(arr[i], 1);
            else
                map.put(arr[i], map.get(arr[i]) + 1);
        }
        Set<Integer> times = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (times.contains(entry.getValue()))
                return false;
            times.add(entry.getValue());
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    }
}
