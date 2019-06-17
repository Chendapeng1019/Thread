package state;

/**
 * @ClassName InfoTest
 * @Description
 * 其他方法
 * isAlive()：表示线程是否还活着
 * Thread.currentThread()：当前线程
 * setName、getName：代理名称
 * @Author chendapeng
 * @Date 2019/6/14
 **/
public class InfoTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isAlive());

        //设置名称 ：真实角色 + 代理角色
        MyInfo info = new MyInfo("战斗机");
        Thread t = new Thread(info);
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());

    }
}

class MyInfo implements Runnable{
    private String name;

    public MyInfo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+name);
    }
}