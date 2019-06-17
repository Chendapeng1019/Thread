package state;

/**
 * @ClassName InfoTest
 * @Description
 * 其他方法
 * @Author chendapeng
 * @Date 2019/6/14
 **/
public class InfoTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().isAlive());

        //设置名称 ：真实角色 + 代理角色
        MyInfo info = new MyInfo("战斗机");

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