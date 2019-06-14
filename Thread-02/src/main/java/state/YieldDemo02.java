package state;

/**
 * @ClassName YieldDemo01
 * @Description
 * yield 礼让线程，暂停线程  直接进入就绪状态 而不是阻塞状态
 * @Author chendapeng
 * @Date 2019/6/14
 **/
public class YieldDemo02 {
    public static void main(String[] args) {
       new Thread(()-> {
          for(int i=0;i<100;i++){
              System.out.println("lambda..."+i);
          }
       }).start();

       for(int i=0;i<100;i++){
           if(i%20==0){
               Thread.yield(); //main线程礼让
           }
           System.out.println("main..."+i);
       }
    }
}


