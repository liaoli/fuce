package livestartv.livestar.com.fu;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class FuItemBean {

    public static final int STATUS_NOT_DOWNLOAD = 0;
    public static final int STATUS_CONNECTING = 1;
    public static final int STATUS_CONNECT_ERROR = 2;
    public static final int STATUS_DOWNLOADING = 3;
    public static final int STATUS_PAUSED = 4;
    public static final int STATUS_DOWNLOAD_ERROR = 5;
    public static final int STATUS_COMPLETE = 6;

    /**
     * name : EatRabbi
     * id : 1001
     * icon : https://lscdn.r2games.com/res/paster/test/sticker/EatRabbi.png
     * bundle : https://lscdn.r2games.com/res/paster/test/sticker/EatRabbi.bundle
     */

    private String name = "EatRabbi";
    private int id = 1001;
    private String icon = "https://lscdn.r2games.com/res/paster/test/sticker/EatRabbi.png";
    private String bundle = "https://lscdn.r2games.com/res/paster/test/sticker/EatRabbi.bundle";

    private int progress;
    private String downloadPerSize;
    private int status;
    private boolean isSelected;

    private boolean isDownload;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBundle() {
        return bundle;
    }

    public void setBundle(String bundle) {
        this.bundle = bundle;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getDownloadPerSize() {
        return downloadPerSize;
    }

    public void setDownloadPerSize(String downloadPerSize) {
        this.downloadPerSize = downloadPerSize;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isDownloadComplete(){

        boolean flag = false;
        switch(this.status){
            case STATUS_NOT_DOWNLOAD:
            case STATUS_CONNECTING:
            case STATUS_CONNECT_ERROR:
            case STATUS_DOWNLOADING:
            case STATUS_PAUSED:
            case STATUS_DOWNLOAD_ERROR:
                flag = false;
                break;
            case STATUS_COMPLETE:
                flag = true;
        }

        return  flag;
    }

    public boolean isDownload() {
        return isDownload;
    }

    public void setDownload(boolean download) {
        isDownload = download;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
