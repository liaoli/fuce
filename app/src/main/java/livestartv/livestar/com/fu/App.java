package livestartv.livestar.com.fu;

import android.app.Application;

import com.aspsine.multithreaddownload.DownloadConfiguration;
import com.aspsine.multithreaddownload.DownloadManager;
import com.facebook.stetho.Stetho;

/**
 * Created by Administrator on 2017/10/18 0018.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        initDownloader();

    }

    private void initDownloader() {
        DownloadConfiguration configuration = new DownloadConfiguration();
        configuration.setMaxThreadNum(10);
        configuration.setThreadNum(2);
        DownloadManager.getInstance().init(getApplicationContext(), configuration);
    }
}
