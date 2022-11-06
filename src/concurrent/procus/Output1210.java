package concurrent.procus;

import java.util.concurrent.locks.ReentrantLock;

public class Output1210 implements Runnable {

    static ReentrantLock lock = new ReentrantLock();
    static int num = 1;

    @Override
    public void run() {
        String threadname = Thread.currentThread().getName();
        while (true) {
            lock.lock();
            int thread_number = Integer.parseInt(threadname);
            if (thread_number == num) {
                if (num == 10) {
                    System.out.println(thread_number);
                    num = 1;
                } else {
                    System.out.print(thread_number);
                    num++;
                }
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Output1210 rt = new Output1210();
        int i = 1;
        while (i <= 10) {
            Thread t = new Thread(rt, String.valueOf(i));
            i++;
            t.start();
        }
    }

}
