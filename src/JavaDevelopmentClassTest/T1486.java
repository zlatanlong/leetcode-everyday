package JavaDevelopmentClassTest;

public class T1486 {

  public int xorOperation(int n, int start) {
    int[] nums = new int[n];
    nums[0] = start;
    for (int i = 1; i < nums.length; i++) {
      nums[i] = nums[i - 1] ^ (start + 2 * i);
    }

    return nums[nums.length - 1];
  }

  public static void main(String[] args) {
    T1486 t1486 = new T1486();
    System.out.println(t1486.xorOperation(10, 5));

  }

}
