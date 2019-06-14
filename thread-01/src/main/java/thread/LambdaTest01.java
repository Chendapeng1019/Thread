package thread;

/**
 * @ClassName LambdaTest01
 * @Description
 * lambda推导
 * @Author chendapeng
 * @Date 2019/6/14
 **/
public class LambdaTest01 {
    //内部类
   static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like2();
        like.lambda();



        //匿名内部类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        };
        like.lambda();

        //方法内部类
        class Like4 implements ILike{
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        }
        like =new Like4();
        like.lambda();

        //lambda
        like = ()-> {
            System.out.println("i like lambda5");
        };
        like.lambda();
    }
}

interface ILike{
    void lambda();
}

class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
