package concurrent.procus;

import java.util.concurrent.atomic.AtomicBoolean;

public class Xiechengmianshi {

    static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                if (flag.get()) {
                    System.out.print('A');
                    flag.compareAndSet(true, false);
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                if (!flag.get()) {
                    System.out.print('B');
                    flag.compareAndSet(false, true);
                }
            }
        }).start();
    }
}
