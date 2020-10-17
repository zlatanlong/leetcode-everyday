package byteDance;

import java.util.Objects;
import java.util.Random;
import java.util.TreeMap;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/9 14:24
 */
public class Singleton {

    private Singleton() {
    }

    private static volatile Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        TreeMap<Bao, String> m = new TreeMap<>((b1, b2) -> (int) (b1.num - b2.num));
        m.put(new Bao(1), "s");
        m.put(new Bao(2), "sss");
        m.entrySet().forEach(System.out::println);

    }
}

class Bao {
    double num;

    public Bao(double num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bao bao = (Bao) o;
        return Double.compare(bao.num, num) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.random());
    }

    @Override
    public String toString() {
        return "Bao{" +
                "num=" + num +
                '}';
    }
}
