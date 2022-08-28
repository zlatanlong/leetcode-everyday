package t001_099;

public class T69 {
    int s;

    public int mySqrt(int x) {
        s = x;
        if(x==0) return 0;
        return (int) sqrt(x);
    }

    public double sqrt(double x) {
        double nextStep = (x + s / x) / 2;
        return nextStep == x ? nextStep : sqrt(nextStep);
    }

    public static void main(String[] args) {
        T69 t = new T69();
        System.out.println(t.mySqrt(15));
    }
}
