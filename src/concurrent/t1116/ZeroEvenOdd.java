package concurrent.t1116;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/3 12:27
 */
public class ZeroEvenOdd {
    private AtomicInteger i = new AtomicInteger(0);
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int j = 0; j < n; j++) {
            while (!i.compareAndSet(0, 3)) {
                Thread.yield();
            }
            printNumber.accept(0);
            if (j % 2 == 0) {
                i.set(1);
            } else {
                i.set(2);
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int j = 2; j <= n; j+=2) {
            while (!i.compareAndSet(2, 3)) {
                Thread.yield();
            }
            printNumber.accept(j);
            i.set(0);
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int j = 1; j <= n; j+=2) {
            while (!i.compareAndSet(1, 3)) {
                Thread.yield();
            }
            printNumber.accept(j);
            i.set(0);
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
