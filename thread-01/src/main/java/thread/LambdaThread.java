package thread;

/**
 * @ClassName StartThread
 * @Description 创建线程方式二：
 * Lambda 表达式 简化线程（用一次）的使用
 * @Author chendapeng
 * @Date 2019/6/13
 **/
public class LambdaThread {
    //静态内部类
    static class Test implements Runnable {
        public void run() {
            for (int i = 0; i < 20; i++) {
                System.out.println("一边听歌");
            }
        }
    }

    public static void main(String[] args) {

        //简化书写（只使用一次）
        //   new Thread(new Test()).start();

        //局部内部类
        class Test2 implements Runnable {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("一边听歌");
                }
            }
        }
        new Thread(new Test2()).start();

        //匿名内部类 必须借助接口或者父类
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("一边听歌");
                }
            }
        }).start();

        //jdk8简化 lambda
        new Thread(()-> {
                for (int i = 0; i < 20; i++) {
                    System.out.println("一边听歌");
                }
            }
        ).start();

    }
}
