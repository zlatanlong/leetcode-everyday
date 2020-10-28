package JavaDevelopmentClassTest;

import java.util.Arrays;

public class T1471 {

  public int[] getStrongest(int[] arr, int k) {
    Arrays.sort(arr);
    int median = arr[(arr.length - 1) / 2];
    return Arrays.stream(arr).boxed().sorted((n1, n2) -> Math.abs(n2 - median) - Math.abs(n1 - median))
    .limit(k).mapToInt(Integer::valueOf).toArray();
  }

  public static void main(String[] args) {
    T1471 t1471 = new T1471();
    int[] arr = { 6, -3, 7, 2, 11 };
    int k = 3;
    Arrays.stream(t1471.getStrongest(arr, k)).forEach(System.out::print);
  }

}
