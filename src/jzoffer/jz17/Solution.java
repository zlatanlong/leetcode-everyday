package jzoffer.jz17;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/4 18:12
 */
public class Solution {
    public int[] printNumbers(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = count * 10 + 9;
        }
        int[] ints = new int[count];
        for (int i = 0; i < count; i++) {
            ints[i] = i + 1;
        }
        return ints;
    }

    public int[] printNumbers2(int n) {
        return null;
    }

    private class Solution2 {
        StringBuilder res;
        int count = 0, n, nine = 0, start;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        public String printNumbers(int n) {
            this.n = n;
            res = new StringBuilder(); // 数字字符串集
            num = new char[n]; // 定义长度为 n 的字符列表
            start = n-1;
            dfs(0); // 开启全排列递归
            res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
            return res.toString(); // 转化为字符串并返回
        }

        /**
         * x 表示dfs层数，将每层当前遍历的值存在num中，并打印
         * @param x
         */
        void dfs(int x) {
            if (x == n) { // 终止条件：已固定完所有位
                String s = String.valueOf(num).substring(start);
                if(!s.equals("0")) res.append(s + ",");
                if(n - start == nine) start--;
                return;
            }
            for (char i : loop) { // 遍历 ‘0‘ - ’9‘
                if(i=='9') nine++;
                num[x] = i; // 固定第 x 位为 i
                dfs(x + 1); // 开启固定第 x + 1 位
            }
            nine--;
        }
    }
}


