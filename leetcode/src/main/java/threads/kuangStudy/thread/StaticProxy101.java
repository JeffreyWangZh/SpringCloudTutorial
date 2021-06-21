package threads.kuangStudy.thread;

import sun.awt.windows.ThemeReader;

/**
 * 静态代理
 *  真是对象和目标代理对象都要实现同一个接口
 *
 *  好处：代理对象可以做很多真实对象做不了的事情 真实对象专注做自己的事情
 * @Author jw9j
 * @create 2021/6/22 0:42
 */
public class StaticProxy101 {
    public static void main(String[] args) {

        // Thread 相当与 WeddingCompany 是代理
        new Thread(()-> System.out.println("我爱你")).start();

        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

// 真实角色
class You implements  Marry{

    @Override
    public void HappyMarry() {
        System.out.println("you 结婚");
    }
}

// 代理角色
class WeddingCompany implements Marry{

    // 代理 -》只想真实对象
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        target.HappyMarry();
        after();
    }

    private void before(){
        System.out.println("布置现场");
    }

    private void after(){
        System.out.println("收彩礼");
    }
}