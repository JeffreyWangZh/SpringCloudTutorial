package threads.kuangStudy.thread;

import java.util.concurrent.*;

/**
 * 实现Callable接口
 * 1. 实现Callable接口 需要返回值类型
 * 2. 重写call方法，需要抛出已成
 * 3. 创建目标对象
 * 4. 创建执行任务 ExecutorService ser = Executors.newFixedThreadPool(1)
 * 5. 提交执行 Future<Boolean> result1 = ser.submit(t1);
 * 6. 获取结果 boolean r1 = result1.get()
 * 7. 关闭服务 ser.shutdownNow();
 * @Author jw9j
 * @create 2021/6/21 1:05
 */
class TestThread3 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 200; i++) {
            System.out.println("我在写代码---"+i);
        }
        return 1;
    }
}
public class CallAble101 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建目标对象
        TestThread3 thread3 = new TestThread3();

        // 创建执行任务
        ExecutorService ser = Executors.newFixedThreadPool(1);

        // 提交任务
        Future<Integer> test = ser.submit(thread3);
        // 结束任务
        ser.shutdown();

        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread()+"我在学习多线程---"+i);
        }


    }
}
