package JavaDevelopmentClassTest;

public class T1493 {
  public int longestSubarray(int[] nums) {
    int maxLength = 0;
    int currentLength = 0;
    int zeroCount = 0;
    int lastContainOneLength = 0;
    boolean hasOne = false;
    boolean hasDelete = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        hasOne = true;
        currentLength++;
        if (zeroCount == 0) {
          lastContainOneLength++;
        }
      } else {
        hasDelete = true;
        if (i > 0 && nums[i - 1] == 0) {
          if (maxLength < currentLength) {
            maxLength = currentLength;
          }
          currentLength = 0;
          zeroCount = 0;
          lastContainOneLength = 0;
          continue;
        }
        if (zeroCount == 0) {
          zeroCount++;
        } else {
          if (maxLength < currentLength) {
            maxLength = currentLength;
          }
          currentLength -= lastContainOneLength;
          lastContainOneLength = currentLength;
        }
      }
    }
    if (maxLength < currentLength) {
      maxLength = currentLength;
    }
    if (hasOne && !hasDelete) {
      maxLength--;
    }
    return maxLength;
  }

  public static void main(String[] args) {
    T1493 t1493 = new T1493();
    int[] nums = { 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1,
        1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
    System.out.println(t1493.longestSubarray(nums));
  }
}
