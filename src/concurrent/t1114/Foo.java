package concurrent.t1114;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zlatanlong
 * @Date: 2020/10/2 17:14
 */
public class Foo {

    private AtomicInteger flag = new AtomicInteger(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (flag.get() != 1) {

        }
        printSecond.run();
        flag.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (flag.get() != 2) {

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread r1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.println(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread r2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.println(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread r3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.println(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        r1.start();
        r3.start();
        r2.start();
    }

}

