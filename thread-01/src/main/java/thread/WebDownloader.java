package thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName WebDownloader
 * @Description
 * 下载
 * @Author chendapeng
 * @Date 2019/6/13
 **/
public class WebDownloader extends Thread {

    public void download(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (MalformedURLException e){
            e.printStackTrace();
            System.out.println("不合法的url");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载失败");
        }
    }
}
