package cooperation;

/**
 * @ClassName CoTest01
 * @Description 协助模型：生产者消费者实现方式一：信号灯法
 * 借助标志位
 * @Author chendapeng
 * @Date 2019/6/18
 **/
public class CoTest02 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//生产者 演员
class Player extends Thread{
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for(int i =0;i<20;i++){
            if(i%2==0){
                this.tv.play("奇葩说");
            }else {
                this.tv.play("太污了，喝瓶立白洗洗嘴");
            }
        }
    }
}
//消费者 观众
class Watcher extends Thread{
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for(int i =0;i<20;i++){
            tv.watch();
        }
    }
}

//同一资源 电视
class Tv {
    String voice;
    //信号灯
    // T 表示演员表演 观众等待
    //F 表示观众观看 演员等待
    boolean flag = true;

    //表演
    public synchronized void play(String voice) {
        //演员等待
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //表演时刻
        System.out.println("表演了：" + voice);
        this.voice = voice;
        //唤醒
        this.notifyAll();
        this.flag = !flag;
    }

    //观看
    public synchronized void watch() {
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //观看时刻
        System.out.println("听到了：" + voice);
        //唤醒
        this.notifyAll();
        //切换
        this.flag = !flag;
    }
}