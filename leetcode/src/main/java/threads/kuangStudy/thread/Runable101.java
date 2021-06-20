package threads.kuangStudy.thread;

/**
 * @Author jw9j
 * @create 2021/6/21 0:57
 */

// 1. 实现runable接口 重写run方法
class TestThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread()+"我在看代码---"+i);
        }
    }
}
public class Runable101 {
    public static void main(String[] args) {
        // 2. 创建runable接口实现类对象
        TestThread2 thread2 = new TestThread2();
        // 3. 启动线程
        new Thread(thread2,"jw9j").start();
        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread()+"我在学习多线程---"+i);
        }
    }
}
