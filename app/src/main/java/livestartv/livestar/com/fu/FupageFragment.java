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


public class FupageFragment extends Fragment {


    List<FuItemBean> datas;

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

        rv.setLayoutManager(new GridLayoutManager(getContext(),5));

        FupageAdapter adapter = new FupageAdapter(getContext(),datas);

        rv.setAdapter(adapter);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fupage, container, false);
    }


}
