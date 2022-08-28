package util;

public class ArraysPrint {

    public static void main(String[] args) {
        String ori = "[[2,5,8],[4,0,-1]]\n";
        String s = ori.replaceAll("\\[", "{");
        System.out.println(s.replaceAll("]","}"));
    }
}
