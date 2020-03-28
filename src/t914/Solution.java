package t914;

import java.util.Collection;
import java.util.HashMap;

public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int zu = 0;
        int length = deck.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Integer currentDeck = map.get(deck[i]);
            if (currentDeck == null) {
                map.put(deck[i], 1);
            } else {
                map.put(deck[i], currentDeck + 1);
            }
        }
        Collection<Integer> c = map.values();
        Object[] num = c.toArray();

        int x = 0;
        for (Object o : num) {
            x = gcd((Integer) o, x);
            if (x == 1) {
                return false;
            }
        }
        return true;
    }

    // 辗转相除法
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] deck = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        boolean b = solution.hasGroupsSizeX(deck);
        System.out.println(b);
    }
}
