package syn;

/**
 * @ClassName UnsafeTest01
 * @Description
 * @Author chendapeng
 * @Date 2019/6/17
 **/
public class UnsafeTest01 {
    public static void main(String[] args) {
        UnWeb12306 web = new UnWeb12306();
        //多个代理
        new Thread(web, "码农").start();
        new Thread(web, "程序员").start();
        new Thread(web, "代码狗").start();
    }
}

class UnWeb12306 implements Runnable {

    //票数
    private int ticketNums = 10;
    private boolean flag = true;

    public void run() {
        while (flag) {
          test();
        }

    }

    public synchronized void test() {
        if (ticketNums < 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "票数：" + ticketNums--);
        ;

    }
}
