package thread;

/**
 * @ClassName LambdaTest01
 * @Description
 * lambda推导 +参数
 * @Author chendapeng
 * @Date 2019/6/14
 **/
public class LambdaTest02 {

    public static void main(String[] args) {
        ILove love = (int a)->{
            System.out.println("i like lambda -->"+a);
        };
        love.lambda(100);

        //简化
        love = (a)->{
            System.out.println("i like lambda -->"+a);
        };
        love.lambda(50);
        //一个参数可省略括号
        love = a->{
            System.out.println("i like lambda -->"+a);
        };
        love.lambda(30);

        //一行代码的时候{}可省略
        love = a-> System.out.println("i like lambda -->"+a);
        ;
        love.lambda(10);
    }
}

interface ILove{
    void lambda(int a);
}

class Love implements ILove{

    @Override
    public void lambda(int a) {
        System.out.println("i like lambda -->"+a);
    }
}
