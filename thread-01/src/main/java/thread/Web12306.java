package thread;

/**
 * @ClassName Web12306
 * @Description
 * 共享资源,并发问题（线程安全）
 * @Author chendapeng
 * @Date 2019/6/13
 **/
public class Web12306 implements Runnable {

    //票数
    private int ticketNums =99;
    public void run() {
        while(true){
            if(ticketNums <0){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"票数："+ticketNums--);
        }
    }

    public static void main(String[] args) {
        //一份资源
        Web12306 web = new Web12306();
        //多个代理
        new Thread(web,"码农").start();
        new Thread(web,"程序员").start();
        new Thread(web,"代码狗").start();
    }
}
