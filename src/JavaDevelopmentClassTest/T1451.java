package JavaDevelopmentClassTest;

import java.util.Arrays;

public class T1451 {

  public String arrangeWords(String text) {
    String[] words = text.split(" ");
    Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < words.length; i++) {
      String word = words[i].toLowerCase();
      if (i == 0) {
        char[] chars = word.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        word = new String(chars);
      }
      sb.append(word);
      if (i != words.length-1) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    T1451 t1451 = new T1451();
    System.out.println(t1451.arrangeWords("On and keep calm code"));
  }
}
