/**
 * @ClassName LockTest
 * @Description
 * 不可重入锁：锁不可以延续使用
 * @Author chendapeng
 * @Date 2019/6/20
 **/
public class LockTest02 {
    Lock lock = new Lock();
    public void a() throws InterruptedException {
        lock.lock();
        dosomething();
        lock.unlock();
    }
    public void dosomething() throws InterruptedException {
        lock.lock();
        //.....
        lock.unlock();
    }
    public static void main(String[] args) throws InterruptedException {
        LockTest02 test02 = new LockTest02();
        test02.a();
        test02.dosomething();
    }
}

//不可重入锁
class Lock{
    //是否占用
    private boolean isLocked = false;
    //使用锁
    public synchronized void lock() throws InterruptedException {
        while(isLocked){
            System.out.println("线程等待");
            wait();

        }
        System.out.println("线程释放");
        isLocked = true;
    }

    //释放锁
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}
