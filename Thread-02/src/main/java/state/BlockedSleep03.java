package state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName BlockedSleep03
 * @Description
 * sleep模拟倒计时
 * @Author chendapeng
 * @Date 2019/6/14
 **/
public class BlockedSleep03 {
    public static void main(String[] args) throws InterruptedException {
       // test();
        //倒计时
        Date endTime = new Date(System.currentTimeMillis()+1000*60*150);
        long end = endTime.getTime();
        while(true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endTime));
            endTime = new Date(endTime.getTime()-1000);
            if(end-1000*60*150>endTime.getTime()){
                break;
            }
        }
    }

    public static void test() throws InterruptedException {
        //倒数十个数，一秒一个
        int num = 10;
        while (num > 0){
            Thread.sleep(1000);
            System.out.println(num--);
        }
    }
}
