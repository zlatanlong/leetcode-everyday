package byteDance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/2 20:53
 */
public class Wwmxd {

    public String vaild(String ori) {
        char[] chars = ori.toCharArray();
        char[] result = new char[chars.length];
        result[0] = chars[0];
        result[1] = chars[1];
        int index = 2;
        for (int i = 2; i < chars.length; i++) {
            // 最后两个相等, 来了有一个相等的
            if (result[index - 1] == result[index - 2] && chars[i] == result[index - 1]) {
                continue;
            }
            // 最后两个
            if (index > 2 && result[index - 2] == result[index - 3] && result[index - 1] == chars[i]) {
                continue;
            }
            result[index++] = chars[i];
        }
        return String.valueOf(Arrays.copyOf(result, index));
    }

    public static void main(String[] args) {
        Wwmxd wwmxd = new Wwmxd();
//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//        for (int j = 0; j < i; j++) {
//            System.out.println(wwmxd.vaild(scanner.next()));
//        }
        System.out.println(wwmxd.vaild("mmccchww"));
//        System.out.println("mmchwwkccojxbzooeyygxggswwynnuffsdsmmnuunmmuvvzyycttijjrmttvckklquuykkvgglhtw  ");
    }
}
