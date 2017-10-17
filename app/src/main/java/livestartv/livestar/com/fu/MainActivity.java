package livestartv.livestar.com.fu;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewStub viewStub;

    private ViewPager viewPager;

    String data = "{\"data\":{\"show\":true,\"refresh\":true,\"ver\":\"81f452114d87b0065de080fd479a540c\",\"info\":[{\"name\":\"EatRabbi\",\"id\":\"1001\",\"icon\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/EatRabbi.png\",\"bundle\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/EatRabbi.bundle\"},{\"name\":\"lixiaolong\",\"id\":\"1002\",\"icon\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/lixiaolong.png\",\"bundle\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/lixiaolong.bundle\"},{\"name\":\"mask_matianyu\",\"id\":\"1003\",\"icon\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/mask_matianyu.png\",\"bundle\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/mask_matianyu.bundle\"},{\"name\":\"Mood\",\"id\":\"1004\",\"icon\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/Mood.png\",\"bundle\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/Mood.bundle\"},{\"name\":\"yazui\",\"id\":\"1005\",\"icon\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/yazui.png\",\"bundle\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/yazui.bundle\"},{\"name\":\"yuguan\",\"id\":\"1006\",\"icon\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/yuguan.png\",\"bundle\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/yuguan.bundle\"},{\"name\":\"banana\",\"id\":\"1007\",\"icon\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/banana.png\",\"bundle\":\"https:\\/\\/lscdn.r2games.com\\/res\\/paster\\/test\\/sticker\\/banana.bundle\"}]}}";

    ArrayList<Fragment> fragments = new ArrayList<>();
    private FragmentPagerAdapter fragmentPagerAdapter;
    private CirclePageIndicator fuIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Gson gson = new Gson();

        Data datas =gson.fromJson(data,Data.class);



        initfuDatas(datas.getData().getInfo());

        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (viewPager == null) {

                    viewStub = (ViewStub) findViewById(R.id.act_test_viewstub_tv_show);

                    View layoutView;

                    layoutView = viewStub.inflate();

                    viewPager = (ViewPager) layoutView.findViewById(R.id.fu_list_pager);

                    fuIndicator = (CirclePageIndicator) layoutView.findViewById(R.id.fu_inidcator);

                    fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
                        @Override
                        public Fragment getItem(int position) {
                            return fragments.get(position);
                        }

                        @Override
                        public Object instantiateItem(ViewGroup container, int position) {

                            return super.instantiateItem(container, position);
                        }

                        @Override
                        public void destroyItem(ViewGroup container, int position, Object object) {

                            super.destroyItem(container, position, object);
                        }

                        @Override
                        public int getCount() {
                            return fragments == null ? 0 : fragments.size();
                        }
                    };

                    viewPager.setAdapter(fragmentPagerAdapter);
                    fuIndicator.setViewPager(viewPager);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            viewPager.requestLayout();
                        }
                    }, 500);
                }
            }

        });

    }

    private void initfuDatas(List<FuItemBean> fuItemBeens) {


        int pageCount = 10;
        int count = fuItemBeens.size();
        boolean flag = false;
        int pages = (count / pageCount);
        int lastPageCount = count % pageCount;
        if(lastPageCount != 0){
            pages+=1;
            flag = true;
        }

        for (int i = 0; i < pages; i++) {

            int start = i * pageCount,end =  ((i + 1) * pageCount) ;

            if(end >=fuItemBeens.size()  &&  flag){
                end = start + lastPageCount;
            }

            fragments.add(FupageFragment.newInstance(fuItemBeens.subList(start,end)));
        }


    }
}
