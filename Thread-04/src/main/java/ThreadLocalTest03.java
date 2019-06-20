/**
 * @ClassName ThreadLocalTest01
 * @Description
 * ThreadLocal:分析上下文
 * 1.构造器：哪里调用就属于哪里
 * 2.run方法:本线程自己的
 * get/set/initialValue
 * @Author chendapeng
 * @Date 2019/6/20
 **/
public class ThreadLocalTest03 {

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()-> 1);
    public static void main(String[] args) {
            new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable{
        public MyRun() { //属于main线程
            threadLocal.set(100);
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        }
    }
}
