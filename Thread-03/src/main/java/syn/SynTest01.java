package syn;

/**
 * @ClassName UnsafeTest01
 * @Description
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 同步方法
 * 同步块
 * @Author chendapeng
 * @Date 2019/6/17
 **/
public class SynTest01 {
    public static void main(String[] args) {
        SafeWeb12306 web = new SafeWeb12306();
        //多个代理
        new Thread(web, "码农").start();
        new Thread(web, "程序员").start();
        new Thread(web, "代码狗").start();
    }
}

class SafeWeb12306 implements Runnable {

    //票数
    private int ticketNums = 1000;
    private boolean flag = true;

    public void run() {
        while (flag) {
          test();
        }

    }

    public synchronized void test() {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "票数：" + ticketNums--);
        ;

    }
}
