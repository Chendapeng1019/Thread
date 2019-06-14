package thread;

/**
 * @ClassName LambdaTest01
 * @Description
 * lambda推导 +参数+返回值
 * @Author chendapeng
 * @Date 2019/6/14
 **/
public class LambdaTest04 {

    public static void main(String[] args) {
      new Thread(()->{
          for (int i=0;i<50;i++){
          System.out.println("一边学习lambda");
          }
      }).start();

        new Thread(()->System.out.println("一边奔溃")).start();
    }
}


