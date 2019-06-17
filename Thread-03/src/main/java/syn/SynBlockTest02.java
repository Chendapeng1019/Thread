package syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UnsafeTest01
 * @Description
 * 线程不安全：操作容器
 * @Author chendapeng
 * @Date 2019/6/17
 **/
public class SynBlockTest02 {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for(int i=0;i<10000;i++){
            new Thread(()->{
                //同步块
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }

            }).start();
        }

        Thread.sleep(2000);
        System.out.println(list.size());
        }
}

