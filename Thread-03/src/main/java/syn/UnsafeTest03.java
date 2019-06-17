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
public class UnsafeTest03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<10000;i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

        System.out.println(list.size());
        }
}

