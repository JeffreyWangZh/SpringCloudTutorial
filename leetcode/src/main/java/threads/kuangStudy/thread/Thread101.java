package threads.kuangStudy.thread;

/**
 * 狂神说 多线程学习代码
 * https://www.bilibili.com/video/BV1V4411p7EF
 *
 * @Author jw9j
 * @create 2021/6/21 0:16
 */
// 多线程实现的三种方法：Thread(class) Runable(interface) Callable(Interface)
// 1. 继承Thread 复写run
class TestThread extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码----"+i);
        }
    }
}
public class Thread101 {


    public static void main(String[] args) {
        // 2. 创建线程对象
        TestThread t1 = new TestThread();
        // 2. 启动线程
        t1.start();
        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程--"+i);
        }

    }
}

