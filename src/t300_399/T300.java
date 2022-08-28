package t300_399;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlatanlong
 * @date 2021/8/9 21:30
 */
public class T300 {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int[] maxLength = new int[nums.length];
        int res = 0;
        int index = 0;
        for (int num : nums) {
            int i = 0;
            int j = res;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (i == res) res++;
            maxLength[index++] = i+1;
        }
        return res;
    }
    public int[] LIS (int[] arr) {
        // write code here
        List<Integer> result = new ArrayList<>();
        int[] maxLength = new int[arr.length];
        for (int i = 0 ; i<arr.length;i++ ){
            if (result.size() > 0){
                if (result.get(result.size()-1) < arr[i]){
                    result.add(arr[i]);
                    maxLength[i] = result.size();
                }else{
                    for (int j = result.size() - 1 ; j >= 0 ; j--){
                        if (result.get(j) < arr[i]){
                            result.set(j+1,arr[i]);
                            maxLength[i] = j + 2;
                            break;
                        }
                        if (j == 0){
                            result.set(0,arr[i]);
                            maxLength[i] = 1;
                        }
                    }
                }
            }else {
                result.add(arr[i]);
                maxLength[i] = 1;
            }
        }
        int[] resultArray = new int[result.size()];

        for (int i = arr.length -1 , j = result.size(); j > 0; i-- ){
            if (maxLength[i] == j){
                resultArray[--j] = arr[i];
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        T300 t300 = new T300();
        t300.lengthOfLIS(new int[]{10, 9, 2, 4,5, 3, 7, 101, 18, 0, 1});
    }
}
