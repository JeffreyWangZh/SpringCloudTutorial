package threads.kuangStudy.thread;

/**
 * Sleep
 *  模拟网络延迟： 放生问题发生行
 * @Author jw9j
 * @create 2021/6/22 1:36
 */
public class ThreadSleep101 implements Runnable{
    private int ticketNums = 10;

    // 1. 模拟网络延迟
    @Override
    public void run() {
        while(true){
            if(ticketNums<=0){
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNums-- +"票");
        }
    }

    public static void main(String[] args) {
        ThreadSleep101 threadSleep101 = new ThreadSleep101();
        new Thread(threadSleep101,"小明").start();
        new Thread(threadSleep101,"老师").start();
        new Thread(threadSleep101,"黄牛").start();

    }
}

