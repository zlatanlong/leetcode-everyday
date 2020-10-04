package concurrent.t1115;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/2 19:11
 */
public class FooBar {
    private int n;
    private AtomicInteger integer = new AtomicInteger(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!integer.compareAndSet(0,1)) {
                Thread.yield();
            }
            printFoo.run();
            integer.incrementAndGet();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!integer.compareAndSet(2,1)) {
                Thread.yield();
            }
            printBar.run();
            integer.decrementAndGet();
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(10);
        new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
