package threads;

/**
 * 关键字synchronized
 * @Author jw9j
 * @create 2021/6/17 1:00
 */

class Counter{
    int count;
    public void increment(){
        synchronized (this){
            count++;
        }
    }
}
public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    c.increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    c.increment();
                }
            }
        });
        t1.start();
        t2.start();
        // 等待线程执行完
        t1.join();
        t2.join();
        System.out.println("count:"+c.count);
    }
}
