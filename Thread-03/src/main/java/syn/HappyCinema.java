package syn;

/**
 * @ClassName HappyCinema
 * @Description
 * 快乐影院
 * @Author chendapeng
 * @Date 2019/6/17
 **/
public class HappyCinema {
    public static void main(String[] args) {

    }
}

class Cinema{
    int available;//可用的位置
    String name;//名称

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }

    //购票
    public boolean bookTickets(int seats) {
        System.out.println("可用位置为："+available);
        return true;
    }
}
