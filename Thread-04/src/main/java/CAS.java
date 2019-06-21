import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName CAS
 * @Description
 * CAS:比较并交换
 *
 * @Author chendapeng
 * @Date 2019/6/21
 **/
public class CAS {
    //库存
    private static AtomicInteger stock = new AtomicInteger(5);
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            new Thread(()->{
                //模拟网络延时
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left =stock.decrementAndGet();
                if(left <1){
                    System.out.println(Thread.currentThread().getName()+"没有抢到...");
                    return;
                }
                System.out.println(Thread.currentThread().getName()+"抢到了一件商品"+"-->还剩"+left);
            }).start();
        }
    }
}
