package dingshiwork;

/**
 * @ClassName VolatileTest
 * @Description
 * volatile用于保证数据的同步，也就是可见性
 * @Author chendapeng
 * @Date 2019/6/20
 **/
public class VolatileTest {
    private volatile static int num =0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
           while(num==0){

           }
        }).start();
        Thread.sleep(1000);
        num =1;
    }
}
