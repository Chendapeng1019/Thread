package thread;

/**
 * @ClassName TDownloader
 * @Description
 * @Author chendapeng
 * @Date 2019/6/13
 **/
public class IDownloader implements Runnable {
    private String url; // 远程路径
    private String name;//存储名字

    public IDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url,name);
        System.out.println(name);
    }

    public static void main(String[] args) {
        IDownloader td1 = new IDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560417147359&di=d83d89e0c8de925c1d174887933a0deb&imgtype=0&src=http%3A%2F%2Fphoto.tuchong.com%2F1546856%2Ff%2F22962937.jpg","1.jpg");
        IDownloader td2 = new IDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560417107236&di=ef8360bff46f31de619bbf38dd349c17&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201503%2F21%2F20150321220253_HRsSm.jpeg","2.jpeg");
        IDownloader td3 = new IDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560417045107&di=4bf4fd3cc9a0dcc9ffbe8ca71c51b1b9&imgtype=0&src=http%3A%2F%2Fcdn6.hbimg.cn%2Fstore%2Fwm%2Fpiccommon%2F1198%2F11984%2FD52581EA8EA2FFD0C6A281BA30.jpg","3.jpg");


        //启动三个线程
        new Thread(td1).start();
        new Thread(td2).start();
        new Thread(td3).start();
    }
}
