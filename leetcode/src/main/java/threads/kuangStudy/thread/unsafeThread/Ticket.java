package threads.kuangStudy.thread.unsafeThread;

/**
 * 线程不安全，抢票的情况
 * 多个线程同事占用资源，导致出现错误
 * @author Zenghui Wang
 * @create 2021-06-24 10:12 AM
 */
public class Ticket {
    public static void main(String[] args) {
        TicketThread thread = new TicketThread();
        new Thread(thread,"小明").start();
        new Thread(thread,"车站").start();
        new Thread(thread,"黄牛").start();
    }
}

// 线程类
class TicketThread implements Runnable{

    int ticktNumber = 10;
    @Override
    public void run() {
        while (ticktNumber>0){
            System.out.println(Thread.currentThread().getName()+"抢到票第"+ticktNumber--+"张");
            // 模拟网络延迟，放大错误放生情况
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}