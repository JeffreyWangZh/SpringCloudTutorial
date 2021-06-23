package threads.kuangStudy.thread;

/**
 * 守护线程
 * 线程分为用户线程和守护线程
 * 虚拟机确保用户线程执行完毕
 * 虚拟机不用等待守护线程执行完毕
 *
 * @Author jw9j
 * @create 2021/6/24 0:45
 */
public class ThreadDaemon101 {
    // 用户线程
    public static void main(String[] args) {
        God god = new God();
        DaemonYou you = new DaemonYou();

        Thread thread = new Thread(god);
        thread.setDaemon(true); // 默认false 表示用户线程
        thread.start();
        new Thread(you).start();// 启动用户线程
    }
}

class DaemonYou implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 30000; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("=============GoodBy world================");;
    }
}
// 守护线程
class God implements Runnable{
    int i = 0;
    @Override
    public void run() {
        while(true){
            System.out.println("God bless you"+i++);
        }
    }
}