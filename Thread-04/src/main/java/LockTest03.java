/**
 * @ClassName LockTest
 * @Description
 * 不可重入锁：锁不可以延续使用
 * @Author chendapeng
 * @Date 2019/6/20
 **/
public class LockTest03 {
    ReLock lock = new ReLock();
    public void a() throws InterruptedException {
        lock.lock();
        System.out.println("a-->"+lock.getHoldCount());
        dosomething();
        lock.unlock();
    }
    public void dosomething() throws InterruptedException {
        lock.lock();
        System.out.println("do1-->"+lock.getHoldCount());

        //.....
        lock.unlock();
        System.out.println("do2-->"+lock.getHoldCount());

    }
    public static void main(String[] args) throws InterruptedException {
        LockTest03 test = new LockTest03();
        test.a();
        test.dosomething();
        Thread.sleep(1000);
        System.out.println("main-->"+test.lock.getHoldCount());
    }
}

//可重入锁
class ReLock{
    //是否占用
    private boolean isLocked = false;
   private Thread lockedBy = null; //存储线程
    private int holdCount =0;
    //使用锁
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while(isLocked && lockedBy!=t){
            System.out.println("线程等待");
            wait();

        }
        isLocked = true;
        lockedBy =t;
        holdCount++;
    }

    //释放锁
    public synchronized void unlock(){
        if(Thread.currentThread()==lockedBy){
            holdCount--;
            if(holdCount ==0){
                isLocked = false;
                notify();
                lockedBy=null;
            }
        }


    }

    public int getHoldCount() {
        return holdCount;
    }

    public void setHoldCount(int holdCount) {
        this.holdCount = holdCount;
    }
}
