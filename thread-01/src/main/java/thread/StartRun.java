package thread;

/**
 * @ClassName StartThread
 * @Description 创建线程方式二：
 * 1.创建： 继承Runnable+重写run
 * 2.启动：创建实现类对象+Thread对象+ start()
 *
 * 推荐使用实现接口方式 ，避免单继承的局限性，优先使用接口
 * 方便共享资源
 * @Author chendapeng
 * @Date 2019/6/13
 **/
public class StartRun implements Runnable {
    /**
     * 线程入口点
     */
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("一边听歌");
        }
    }

    public static void main(String[] args) {

        //创建实现类对象
        StartRun sr = new StartRun();
        //创建代理类对象
        Thread t = new Thread(sr);
        //启动
        t.start();  //不保证立即运行 cpu调用

        //简化书写（只使用一次）
        new Thread(new StartRun()).start();
        for (int i = 0; i < 20; i++) {
            System.out.println("一边coding");
        }
    }
}
