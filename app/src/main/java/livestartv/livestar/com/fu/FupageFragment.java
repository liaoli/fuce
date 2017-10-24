package livestartv.livestar.com.fu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.functions.Action1;


public class FupageFragment extends Fragment {


    List<FuItemBean> datas;
    private Subscription subscription;
    FuItemBean selectedFuItem;
    private FupageAdapter adapter;

    public FupageFragment() {
        // Required empty public constructor
    }


    public static FupageFragment newInstance(List<FuItemBean> datas) {
        FupageFragment fragment = new FupageFragment();
        fragment.datas = datas;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RecyclerView rv = (RecyclerView) getView().findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        rv.setLayoutManager(new GridLayoutManager(getContext(), 5));

        adapter = new FupageAdapter(getContext(), datas);

        rv.setAdapter(adapter);

        subscription = RxBus.getInstance().toObservable(FuItemBean.class).subscribe(new Action1<FuItemBean>() {
            @Override
            public void call(FuItemBean fuItemBean) {

                if (selectedFuItem != null) {
                    selectedFuItem.setSelected(false);
                }
                if (datas.contains(fuItemBean)) {
                    if (fuItemBean.equals(selectedFuItem)) {
                        selectedFuItem = null;
                        return;
                    } else {
                        selectedFuItem = fuItemBean;
                    }
                } else {
                    selectedFuItem = null;
                }
                adapter.notifyDataSetChanged();
            }


        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {


            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fupage, container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }
}
