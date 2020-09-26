package JavaDevelopmentClassTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class T1560 {
  public List<Integer> mostVisited(int n, int[] rounds) {
    int count = 0;
    // 数组下标i - 1 表示round i
    int[] firstPlusLastRoundArray = new int[n];
    Arrays.fill(firstPlusLastRoundArray, 0);
    // 先判断是否跑完了一圈
    for (int i = 0; i < rounds.length; i++) {
      if (i != rounds.length - 1 && rounds[i] > rounds[i + 1]) {
        count++;
        break;
      }
    }
    List<Integer> arrayList = new ArrayList<>();
    if (count == 0) {
      // 一圈都没跑完
      IntStream.rangeClosed(rounds[0], rounds[rounds.length - 1]).forEach(i -> arrayList.add(i));
      return arrayList;
    } else {
      // 第一圈从开始到n，都加一
      IntStream.rangeClosed(rounds[0], n).forEach(round -> firstPlusLastRoundArray[round - 1]++);
      // 如果跑过一圈了，那么最后一圈到终点前的也都经过了
      IntStream.rangeClosed(1, rounds[rounds.length - 1]).forEach(round -> firstPlusLastRoundArray[round - 1]++);
    }
    int max = Arrays.stream(firstPlusLastRoundArray).max().getAsInt();
    for (int i = 0; i < firstPlusLastRoundArray.length; i++) {
      if (firstPlusLastRoundArray[i] == max) {
        arrayList.add(i + 1);
      }
    }
    return arrayList;
  }

  public static void main(String[] args) {
    T1560 t1560 = new T1560();
    int[] arr = { 1,3,5,7 };
    System.out.println(t1560.mostVisited(7, arr));
  }
}
