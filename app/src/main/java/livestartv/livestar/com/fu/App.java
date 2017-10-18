package livestartv.livestar.com.fu;

import android.app.Application;

import com.aspsine.multithreaddownload.DownloadConfiguration;
import com.aspsine.multithreaddownload.DownloadManager;

/**
 * Created by Administrator on 2017/10/18 0018.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initDownloader();

    }

    private void initDownloader() {
        DownloadConfiguration configuration = new DownloadConfiguration();
        configuration.setMaxThreadNum(10);
        configuration.setThreadNum(3);
        DownloadManager.getInstance().init(getApplicationContext(), configuration);
    }
}
