package syn;

/**
 * @ClassName UnsafeTest01
 * @Description
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 同步方法
 * 同步块
 * @Author chendapeng
 * @Date 2019/6/17
 **/
public class SynTest02 {
    public static void main(String[] args) {
        //账号
        Account account = new Account(100,"结婚礼金");
        SafeDrawing you  = new SafeDrawing(account,80,"可悲的你");
        SafeDrawing wife  = new SafeDrawing(account,90,"haapy的她");
        you.start();
        wife.start();
    }
}



//模拟取款
class SafeDrawing extends Thread{
    Account account;//取钱的账号
    int drawingMoney;//取的钱数
    int packetTotal;//口袋的总数

    public SafeDrawing(Account account, int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        test();
    }
//目标不对锁定失败 这里不是锁this 应该锁定account
    public synchronized void test(){
        if(account.money-drawingMoney<0){
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money-=drawingMoney;
        packetTotal+=drawingMoney;
        System.out.println(this.getName()+"-->账号余额为："+account.money);
        System.out.println(this.getName()+"-->口袋的钱为："+this.packetTotal);
    }
}
