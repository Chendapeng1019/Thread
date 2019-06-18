package syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Happy12306
 * @Description 快乐火车票
 * @Author chendapeng
 * @Date 2019/6/18
 **/
public class Happy12306 {
    public static void main(String[] args) {
        //可用位置
        List<Integer> available = new ArrayList<>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(4);
        available.add(5);
        available.add(6);
        available.add(7);

        List<Integer> seats1 = new ArrayList<>();
        seats1.add(2);
        seats1.add(5);
        seats1.add(3);

        List<Integer> seats2 = new ArrayList<>();
        seats2.add(6);
        seats2.add(7);

        Web12306 web12306 = new Web12306(available, "happy sxt");
        new Passenger(web12306, seats1, "老高").start();
        new Passenger(web12306, seats2, "陈").start();

    }
}

//顾客
class Passenger extends Thread {
    List<Integer> seats;

    public Passenger(Runnable target, List<Integer> seats, String name) {
        super(target, name);
        this.seats = seats;
    }

}

//火车票
class Web12306 implements Runnable {
    List<Integer> available;//可用的位置
    String name;//名称

    public Web12306(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override
    public void run() {
        Passenger passenger = (Passenger) Thread.currentThread();
        boolean flag = this.bookTickets(passenger.seats);
        if (flag) {
            System.out.println("出票成功：" + Thread.currentThread().getName() + "-<位置为：" + passenger.seats);
        } else {
            System.out.println("出票失败:" + Thread.currentThread().getName() + "-<位置不够");
        }
    }

    //购票
    public synchronized boolean bookTickets(List<Integer> seats) {
        System.out.println("可用位置为：" + available);
        List<Integer> copy = new ArrayList<>();
        copy.addAll(available);

        //相减
        copy.removeAll(seats);

        //判断大小
        if (available.size() - copy.size() != seats.size()) {
            return false;
        }
        //成功
        available = copy;
        return true;
    }
}

