package threads.kuangStudy.thread;

import common.TreeNode;

/**
 * Sleep
 *  模拟网络延迟： 放生问题发生行
 * @Author jw9j
 * @create 2021/6/22 1:36
 */
public class Thread101Sleep implements Runnable{
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
        Thread101Sleep thread101Sleep = new Thread101Sleep();
        new Thread(thread101Sleep,"小明").start();
        new Thread(thread101Sleep,"老师").start();
        new Thread(thread101Sleep,"黄牛").start();

    }
}

