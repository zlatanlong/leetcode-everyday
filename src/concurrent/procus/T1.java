package concurrent.procus;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class T1 {


    public static void main(String[] args) throws InterruptedException {
        //指定阻塞队列容量为 100
//        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(100);
        MyLinkedBlockingQueue queue = new MyLinkedBlockingQueue(100);
        //put带有阻塞功能， offer不带有阻塞功能
        queue.put(10);
        //take带有阻塞功能,poll不带有阻塞功能
        queue.take();
        //生产者线程
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    //Thread.sleep(1000);
                    queue.put(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产了 " + i);
            }
        });
        producer.start();
        //消费者线程
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    Integer value = queue.take();
                    System.out.println("消费了 " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class MyLinkedBlockingQueue {
    private int start;
    private int end;
    private int[] array;
    //阻塞队列元素个数
    private int size;
    //锁对象
    ReentrantLock lock;
    Condition condition;

    public MyLinkedBlockingQueue() {
        this.array = new int[Integer.MAX_VALUE];
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public MyLinkedBlockingQueue(int capacity) {
        this.array = new int[capacity];
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public void put(int value) throws InterruptedException {
        lock.lock();
        //判断队列是否已满
        while (this.size == this.array.length) {
            condition.await();
        }
        this.array[this.end++] = value;
        this.size++;
        //判断end是否已经到达数组末尾
        if (this.end == this.array.length) {
            this.end = 0;
        }
        //每次插入都唤醒一个线程
        condition.signal();
        lock.unlock();
    }

    public int take() throws InterruptedException {
        lock.lock();
        //判断队列是否为空
        while (this.size == 0) {
            condition.await();
        }
        int value = this.array[this.start++];
        this.size--;
        //判断start是否走到数组末尾
        if (this.start == this.array.length) {
            this.start = 0;
        }
        //唤醒一个线程
        condition.signal();
        lock.unlock();
        return value;
    }
}
