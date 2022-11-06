package bishiti.nybank;

public class ChangeCharInStr {

    String str = "company";
    char[] ch = {'a', 'b', 'c'};

    public static void main(String[] args) {
        ChangeCharInStr ex = new ChangeCharInStr();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }
}
