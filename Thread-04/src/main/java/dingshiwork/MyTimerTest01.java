package dingshiwork;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName MyTimerTest01
 * @Description
 * 任务调度：Timer 和TimerTask类
 * @Author chendapeng
 * @Date 2019/6/18
 **/
public class MyTimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //执行安排
      //  timer.schedule(new MyTask(),1000,500); //执行多次
        Calendar cal = new GregorianCalendar(2019,5,18,17,22,10);
        timer.schedule(new MyTask(),cal.getTime(),500);
    }
}

//任务类
class MyTask extends TimerTask{

    public void run() {
        for(int i =0;i<10;i++){
            System.out.println("放空大脑，休息一会");
        }
        System.out.println("-------end -------");
    }
}