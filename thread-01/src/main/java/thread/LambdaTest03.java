package thread;

/**
 * @ClassName LambdaTest01
 * @Description
 * lambda推导 +参数+返回值
 * @Author chendapeng
 * @Date 2019/6/14
 **/
public class LambdaTest03 {

    public static void main(String[] args) {
        IInterest interest = (int a,int b)-> {
            System.out.println("i like lambda -->"+(a+b));
            return a+b;
        };
        interest.lambda(113,105);

        interest = (a,c)->{
            return a+c;
        };
        interest = (a,c)->a+c;

        System.out.println(interest.lambda(10,20));
    }
}

interface IInterest{
    int lambda(int a,int b);
}

class Interest implements IInterest{

    @Override
    public int lambda(int a,int b) {
        System.out.println("i like lambda -->"+a+b);
        return a+b;
    }
}
