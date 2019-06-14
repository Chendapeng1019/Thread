package state;

/**
 * @ClassName BlockedSleep01
 * @Description
 * sleep模拟网络延时，放大了发生问题的可能性
 * @Author chendapeng
 * @Date 2019/6/14
 **/
public class BlockedSleep01 {
    public static void main(String[] args) {
        //一份资源
        Web12306 web = new Web12306();
        //多个代理
        new Thread(web,"码农").start();
        new Thread(web,"程序员").start();
        new Thread(web,"代码狗").start();
    }

}

 class Web12306 implements Runnable {

    //票数
    private int ticketNums =99;
    public void run() {
        while(true){
            if(ticketNums <0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"票数："+ticketNums--);
        }
    }

}

