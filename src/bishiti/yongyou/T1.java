package bishiti.yongyou;

public class T1 {


    public long calculateTotal(int count) {
        if (count==1) {
            return 1;
        }
        if (count==2) {
            return 1;
        }
        return calculateTotal(count-1) + calculateTotal(count-2);
    }

    public long fib(int count) {
        if (count==1) {
            return 1;
        }
        if (count==2) {
            return 1;
        }
        return fib(count-1) + fib(count-2);
    }

    public static void main(String[] args) {

    }
}
