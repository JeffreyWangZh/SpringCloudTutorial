package threads.kuangStudy.thread.unsafeThread;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayList 线程不安全，使用synchronized 保证线程安全
 * @author Zenghui Wang
 * @create 2021-06-24 11:03 AM
 */
public class UnSafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
//        synchronized (list){
            for (int i = 0; i < 10000; i++) {
                new Thread(()->{
                    list.add(Thread.currentThread().getName());
                }).start();
            }
//        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }
}

