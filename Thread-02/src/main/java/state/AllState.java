package state;

/**
 * @ClassName AllState
 * @Description
 * 观察线程额状态
 * @Author chendapeng
 * @Date 2019/6/14
 **/
public class AllState {
    public static void main(String[] args) throws InterruptedException {
        Thread t= new Thread(()-> {
            for(int i=0;i<5;i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("...");
            }

        });
        //观察状态
        Thread.State state = t.getState();
        System.out.println(state); //NEW

        t.start();
        state = t.getState();
        System.out.println(state); //RUNNABLE

        while(true){
            int num = Thread.activeCount();
            System.out.println(num);
            if(num==1) break;
            Thread.sleep(200);
            state = t.getState();
            System.out.println(state); //RUNNABLE
        }


    }
}
