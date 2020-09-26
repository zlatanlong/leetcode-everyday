package JavaDevelopmentClassTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T1544 {

  public String makeGood(String s) {
    Stack<Character> stack = new Stack<>();
    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (stack.empty()) {
        stack.push(arr[i]);
        continue;
      }
      char peek = stack.peek();
      if (peek != arr[i] && Math.min(peek, arr[i]) + 32 == Math.max(peek, arr[i])) {
        stack.pop();
        continue;
      }
      stack.push(arr[i]);
    }
    List<Character> arrayList = new ArrayList<>(stack);
    Character[] newArr = new Character[arrayList.size()];
    char[] newCharArr = new char[arrayList.size()];
    arrayList.toArray(newArr);
    for (int i = 0; i < newCharArr.length; i++) {
      newCharArr[i] = newArr[i];
    }
    return String.valueOf(newCharArr);
  }
  public static void main(String[] args) {
    T1544 t1544 = new T1544();
    System.out.println(t1544.makeGood("s"));
  }
}
