package syn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName UnsafeTest01
 * @Description
 * 线程不安全：操作容器
 * @Author chendapeng
 * @Date 2019/6/17
 **/
public class SynContainer {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for(int i=0;i<10000;i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

        Thread.sleep(2000);
        System.out.println(list.size());
        }
}

