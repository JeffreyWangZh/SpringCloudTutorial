package threads.kuangStudy.thread;

/**
 * 线程stop
 *  建议线程正常停止 -> 利用次数，不建议死循环
 *  建议是哟个标志位-> 设置一个标志位
 *  不适用stop destory等过程或者JDk不建议使用的方法
 * @Author jw9j
 * @create 2021/6/22 1:25
 */
public class ThreadStop101 implements Runnable{
    // 1. 创建标志位
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while(flag){
            System.out.println("run -- the threat "+ i++);
        }
    }
    // 2. 设置一个公开的方法停止线程，转换标志位
    public void stop(){
        flag = false;
    }

    public static void main(String[] args) {
        ThreadStop101 threadStop101 = new ThreadStop101();
        new Thread(threadStop101).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if(i==900){
                threadStop101.stop();
                System.out.println("线程停止");
            }
        }
    }
}
