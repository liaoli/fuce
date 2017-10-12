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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewStub viewStub;

    private ViewPager viewPager;

    ArrayList<Fragment> fragments = new ArrayList<>();
    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initfuDatas(53);

        viewStub = (ViewStub) findViewById(R.id.act_test_viewstub_tv_show);


        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager == null) {
                    View layoutView;

                    layoutView = viewStub.inflate();

                    viewPager = (ViewPager) layoutView.findViewById(R.id.fu_list_pager);


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

    private void initfuDatas(int count) {


        int pageCount = 10;

        boolean flag = false;
        int pages = (count / pageCount);
        int lastPageCount = count % pageCount;
        if(lastPageCount != 0){
            pages+=1;
            flag = true;
        }

        ArrayList<FuItemBean> fuItemBeens = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            FuItemBean fuItemBean = new FuItemBean();
            fuItemBeens.add(fuItemBean);
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
