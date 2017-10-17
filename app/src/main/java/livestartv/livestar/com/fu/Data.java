package livestartv.livestar.com.fu;

import java.util.List;

/**
 * Created by Administrator on 2017/10/17 0017.
 */

public class Data {


    /**
     * data : {"show":true,"refresh":true,"ver":"81f452114d87b0065de080fd479a540c","info":[{"name":"EatRabbi","id":"1001","icon":"https://lscdn.r2games.com/res/paster/test/sticker/EatRabbi.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/EatRabbi.bundle"},{"name":"lixiaolong","id":"1002","icon":"https://lscdn.r2games.com/res/paster/test/sticker/lixiaolong.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/lixiaolong.bundle"},{"name":"mask_matianyu","id":"1003","icon":"https://lscdn.r2games.com/res/paster/test/sticker/mask_matianyu.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/mask_matianyu.bundle"},{"name":"Mood","id":"1004","icon":"https://lscdn.r2games.com/res/paster/test/sticker/Mood.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/Mood.bundle"},{"name":"yazui","id":"1005","icon":"https://lscdn.r2games.com/res/paster/test/sticker/yazui.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/yazui.bundle"},{"name":"yuguan","id":"1006","icon":"https://lscdn.r2games.com/res/paster/test/sticker/yuguan.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/yuguan.bundle"},{"name":"banana","id":"1007","icon":"https://lscdn.r2games.com/res/paster/test/sticker/banana.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/banana.bundle"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * show : true
         * refresh : true
         * ver : 81f452114d87b0065de080fd479a540c
         * info : [{"name":"EatRabbi","id":"1001","icon":"https://lscdn.r2games.com/res/paster/test/sticker/EatRabbi.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/EatRabbi.bundle"},{"name":"lixiaolong","id":"1002","icon":"https://lscdn.r2games.com/res/paster/test/sticker/lixiaolong.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/lixiaolong.bundle"},{"name":"mask_matianyu","id":"1003","icon":"https://lscdn.r2games.com/res/paster/test/sticker/mask_matianyu.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/mask_matianyu.bundle"},{"name":"Mood","id":"1004","icon":"https://lscdn.r2games.com/res/paster/test/sticker/Mood.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/Mood.bundle"},{"name":"yazui","id":"1005","icon":"https://lscdn.r2games.com/res/paster/test/sticker/yazui.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/yazui.bundle"},{"name":"yuguan","id":"1006","icon":"https://lscdn.r2games.com/res/paster/test/sticker/yuguan.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/yuguan.bundle"},{"name":"banana","id":"1007","icon":"https://lscdn.r2games.com/res/paster/test/sticker/banana.png","bundle":"https://lscdn.r2games.com/res/paster/test/sticker/banana.bundle"}]
         */

        private boolean show;
        private boolean refresh;
        private String ver;
        private List<FuItemBean> info;

        public boolean isShow() {
            return show;
        }

        public void setShow(boolean show) {
            this.show = show;
        }

        public boolean isRefresh() {
            return refresh;
        }

        public void setRefresh(boolean refresh) {
            this.refresh = refresh;
        }

        public String getVer() {
            return ver;
        }

        public void setVer(String ver) {
            this.ver = ver;
        }

        public List<FuItemBean> getInfo() {
            return info;
        }

        public void setInfo(List<FuItemBean> info) {
            this.info = info;
        }
    }
}
