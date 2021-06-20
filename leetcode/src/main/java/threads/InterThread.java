package threads;

/**
 * @Author jw9j
 * @create 2021/6/17 1:26
 */
class Q{
    int num;
    boolean valueSet = false;
    public synchronized void put(int num){
        while(valueSet){
            try{
                wait();
            }catch (Exception e){}
        }
        System.out.println("put:"+num);
        this.num = num;
        valueSet = true;
        notify();
    }
    public synchronized void get(){
        while(!valueSet) {
            try{
                wait();
            }catch (Exception e){}
        }
        System.out.println("Get:"+num);
        notify();
    }
}

class Producer implements  Runnable{
    Q q;

    public Producer(Q q) {
        this.q = q;
        Thread t = new Thread(this,"Producer");
        t.start();
    }

    @Override
    public void run() {
        int i = 0;
        while(true){
            q.put(i++);
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }

    }
}

class Comsumer implements Runnable{
    Q q;

    public Comsumer(Q q) {
        this.q = q;
        Thread t  = new Thread(this,"Consumer");
        t.start();
    }

    @Override
    public void run() {
        while(true){
            q.get();
            try{
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }
}
public class InterThread {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Comsumer(q);

    }
}
