package livestartv.livestar.com.fu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by Administrator on 2017/10/11 0011.
 */

public class FupageAdapter extends RecyclerView.Adapter<FupageAdapter.FuHolder> {

    private Context mContext;

    private LayoutInflater mInflater;

    private List<FuItemBean> datas;

    public FupageAdapter(Context mContext,List<FuItemBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public FuHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.fu_item, parent, false);

        WindowManager mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        int windowW = mWindowManager.getDefaultDisplay().getWidth();

        view.getLayoutParams().width = windowW / 5;
        view.getLayoutParams().height = windowW / 5;

        return new FuHolder(view);
    }

    @Override
    public void onBindViewHolder(FuHolder holder, int position) {
        holder.bindData(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }


   public  class FuHolder extends RecyclerView.ViewHolder{

        ImageView fuIcon , download;
        ProgressBar downloadPb;



        public FuHolder(View itemView) {
            super(itemView);

            fuIcon = (ImageView) itemView.findViewById(R.id.iv_fu_icon);

            download = (ImageView) itemView.findViewById(R.id.download_iv);

            downloadPb = (ProgressBar) itemView.findViewById(R.id.download_pb);

            //如果本地有的话，不现实下载按钮，

            download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    download.setVisibility(View.GONE);
                   //开启下载 ，显示进度条
                    downloadPb.setVisibility(View.VISIBLE);

                    downloadPb.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            downloadPb.setVisibility(View.GONE);
                        }
                    },2000);

                }
            });

        //    https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1508130039450&di=1ca02bd97a8f344ccb327e836fecc9fc&imgtype=0&src=http%3A%2F%2Fwww.51edu.com%2Fueditor2014%2Fphp%2Fupload%2Fimage%2F20150216%2F1424069121411681.png
        }

        public void bindData(FuItemBean fuItemBean){
            Glide.with(mContext).load(fuItemBean.getIcon()).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.LOW).into(fuIcon);
        }

    }
}
