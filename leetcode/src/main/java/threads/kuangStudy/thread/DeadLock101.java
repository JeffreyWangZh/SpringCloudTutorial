package threads.kuangStudy.thread;

/**
 * 死锁 必要条件
 * 1. 互斥条件：
 * 2. 请求与保持条件： 一个进程因请求资源而阻塞时，对已获得的资源不释放
 * 3. 不剥夺条件
 * 4. 循环等待条件
 *
 * @author Zenghui Wang
 * @create 2021-06-24 12:28 PM
 */
public class DeadLock101 {
    public static void main(String[] args) {
        MakeUp makeUp1 = new MakeUp(1,"Jane");
        MakeUp makeUp2 = new MakeUp(0,"Joey");
        makeUp1.start();
        makeUp2.start();
    }
}
// 口红
class Lipstick{

}
// 镜子
class Mirror{

}
class MakeUp extends Thread{
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;
    String girlName;

    MakeUp(int choice,String girlName){
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeUp1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // 化妆 死锁， 解决方法： 将内部使用的锁拿出来
    private void makeUp() throws InterruptedException {
        if(choice==0){
            synchronized (lipstick){//获得口红锁
                System.out.println(this.getName()+"获得口红");
                Thread.sleep(1000);
                synchronized (mirror){//一秒钟后获得镜子的锁
                    System.out.println(this.getName()+"获得镜子");
                    Thread.sleep(1000);
                }
            }
        }else {
            synchronized (mirror){
                System.out.println(this.getName()+"获得镜子");
                Thread.sleep(2000);
                synchronized (lipstick){
                    System.out.println(this.getName()+"获得口红");
                }
            }
        }
    }
    // 将锁拿出
    private void makeUp1() throws InterruptedException {
        if(choice==0){
            synchronized (lipstick){//获得口红锁
                System.out.println(this.getName()+"获得口红");
                Thread.sleep(1000);
            }
            synchronized (mirror){//一秒钟后获得镜子的锁
                System.out.println(this.getName()+"获得镜子");
                Thread.sleep(1000);
            }
        }else {
            synchronized (mirror){
                System.out.println(this.getName()+"获得镜子");
                Thread.sleep(2000);
            }
            synchronized (lipstick){
                System.out.println(this.getName()+"获得口红");
            }
        }
    }
}
