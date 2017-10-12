package livestartv.livestar.com.fu;

/**
 * Created by Administrator on 2017/10/12 0012.
 */

public class FuItemBean {

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
}
