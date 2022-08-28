package jzoffer;

import java.util.*;

public class JJ38_2 {

    List<String> ans = new ArrayList<>();
    int len;

    public String[] permutation(String s) {
        len = s.length();
        char[] curChars = s.toCharArray();
        dfs(0, curChars);
        return ans.toArray(new String[0]);
    }

    public void dfs(int curIndex, char[] curChars) {
        if(curIndex == len-1) {
            ans.add(String.valueOf(curChars));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i=curIndex;i<len;i++) {
            // 准备把i放到curIndex位置
            if(set.contains(i)) continue;
            set.add(curChars[i]);

            swap(curChars,i,curIndex);

            dfs(curIndex+1, curChars);

            swap(curChars,i,curIndex);
        }
    }


    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new JJ38_2().permutation("aab")));

    }
}
