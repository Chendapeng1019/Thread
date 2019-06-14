package thread;

import java.util.concurrent.*;

/**
 * @ClassName TDownloader
 * @Description
 * @Author chendapeng
 * @Date 2019/6/13
 **/
public class CDownloader implements Callable<Boolean> {
    private String url; // 远程路径
    private String name;//存储名字

    public CDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Boolean call() throws Exception {
        WebDownloader wd = new WebDownloader();
        wd.download(url,name);
        System.out.println(name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CDownloader cd1 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560417147359&di=d83d89e0c8de925c1d174887933a0deb&imgtype=0&src=http%3A%2F%2Fphoto.tuchong.com%2F1546856%2Ff%2F22962937.jpg","1.jpg");
        CDownloader cd2 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560417107236&di=ef8360bff46f31de619bbf38dd349c17&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201503%2F21%2F20150321220253_HRsSm.jpeg","2.jpeg");
        CDownloader cd3 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560417045107&di=4bf4fd3cc9a0dcc9ffbe8ca71c51b1b9&imgtype=0&src=http%3A%2F%2Fcdn6.hbimg.cn%2Fstore%2Fwm%2Fpiccommon%2F1198%2F11984%2FD52581EA8EA2FFD0C6A281BA30.jpg","3.jpg");


        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> result1 = ser.submit(cd1);
        Future<Boolean> result2 = ser.submit(cd2);
        Future<Boolean> result3 = ser.submit(cd3);

        boolean r1 = result1.get();
        boolean r2 = result2.get();
        boolean r3 = result3.get();
        System.out.println(r3);
        //关闭服务
        ser.shutdownNow();

    }
}
