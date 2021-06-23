package threads.kuangStudy.thread;

/**
 * 线程礼让，让当前正在执行的线程礼让，但不阻塞
 * 将相乘从运行状态转化未就绪状态
 * 让CPU重新调度，礼让不一定成功
 * @author Zenghui Wang
 * @create 2021-06-23 11:29 AM
 */
public class ThreadYield101 {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"线程A").start();
        new Thread(myYield,"线程B").start();
    }

}
class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();// 线程礼让
        System.out.println(Thread.currentThread().getName()+"线程结束");
    }
}
