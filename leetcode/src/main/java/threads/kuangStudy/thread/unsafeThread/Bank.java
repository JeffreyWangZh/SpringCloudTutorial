package threads.kuangStudy.thread.unsafeThread;

/**
 * 线程不安全 同时取银行的钱，出现幻读
 * @author Zenghui Wang
 * @create 2021-06-24 10:20 AM
 */
public class Bank {
    public static void main(String[] args) {
        Account account = new Account("test",10000);
        new Thread(new WithDraw(account,5000),"A").start();
        new Thread(new WithDraw(account,9000),"B").start();
//        WithDrawThread thread = new WithDrawThread(account,5000,"A");
//        WithDrawThread thread2 = new WithDrawThread(account,7000,"B");
//        thread2.start();
//        thread.start();

    }
}

// 账户
class Account {
    public String accountName;
    public int balance;

    public Account(String accountName, int balance) {
        this.accountName = accountName;
        this.balance = balance;
    }
}

class WithDraw implements Runnable{

    public Account account;
    // 取了多少钱
    public int withDrawNumber;
    // 剩余多少钱
    public int balance;

    @Override
    public void run() {
//        synchronized (account){
            if (account.balance>withDrawNumber){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.balance = account.balance-withDrawNumber;
                System.out.println(Thread.currentThread().getName()+"取走"+withDrawNumber+",结余"+account.balance);


            }
            System.out.println("钱不够");
//        }
    }

    public WithDraw(Account account, int withDrawNumber) {
        this.account = account;
        this.withDrawNumber = withDrawNumber;
    }
}

class WithDrawThread extends Thread {
    public Account account;
    // 取了多少钱
    public int withDrawNumber;
    // 剩余多少钱

    public WithDrawThread(Account account, int withDrawNumber, String name) {
        super(name);
        this.account = account;
        this.withDrawNumber = withDrawNumber;
    }

    // 取钱
    @Override
    public void run() {
        if(account.balance<withDrawNumber){
            System.out.println(this.getName()+"钱不够");
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.balance = account.balance-withDrawNumber;
        System.out.println(this.getName()+"取钱"+withDrawNumber+",余额"+account.balance);
    }
}
