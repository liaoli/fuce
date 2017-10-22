package livestartv.livestar.com.fu;

import android.content.Context;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.aspsine.multithreaddownload.CallBack;
import com.aspsine.multithreaddownload.DownloadException;
import com.aspsine.multithreaddownload.DownloadManager;
import com.aspsine.multithreaddownload.DownloadRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2017/10/11 0011.
 */

public class FupageAdapter extends RecyclerView.Adapter<FupageAdapter.FuHolder> {

    private Context mContext;

    private LayoutInflater mInflater;

    private List<FuItemBean> datas;

    private final File mDownloadDir = new File(Environment.getExternalStorageDirectory(), "Download");

    public FupageAdapter(Context mContext, List<FuItemBean> datas) {
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


    public class FuHolder extends RecyclerView.ViewHolder {

        ImageView fuIcon, download;
        ProgressBar downloadPb;
        FuItemBean fuItemBean;


        public FuHolder(final View itemView) {
            super(itemView);

            fuIcon = (ImageView) itemView.findViewById(R.id.iv_fu_icon);

            download = (ImageView) itemView.findViewById(R.id.download_iv);

            downloadPb = (ProgressBar) itemView.findViewById(R.id.download_pb);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!fuItemBean.isDownload()) {
                        DownloadRequest request = new DownloadRequest.Builder()
                                .setName(fuItemBean.getName() + ".bundle")
                                .setUri(fuItemBean.getBundle())
                                .setFolder(mDownloadDir)
                                .build();


                        DownloadManager.getInstance().download(request, fuItemBean.getBundle(), new CallBack() {
                            public static final String TAG = "DownloadCallBack";

                            @Override
                            public void onStarted() {
                                downloadPb.setVisibility(View.VISIBLE);
                                download.setVisibility(View.GONE);
                                Log.e(TAG, "onStarted()");
                            }

                            @Override
                            public void onConnecting() {
                                Log.e(TAG, "onConnecting()");
                            }

                            @Override
                            public void onConnected(long total, boolean isRangeSupport) {
                                Log.e(TAG, "onConnected() , total = " + total + ",isRangeSupport = " + isRangeSupport);
                            }

                            @Override
                            public void onProgress(long finished, long total, int progress) {
                                Log.e(TAG, "onProgress() ,finished=" + finished + ", total = " + total + ",progress = " + progress);
                            }

                            @Override
                            public void onCompleted() {
                                Log.e(TAG, "onCompleted()");
                                downloadPb.setVisibility(View.GONE);
                                fuItemBean.setDownload(true);
                            }

                            @Override
                            public void onDownloadPaused() {
                                Log.e(TAG, "onDownloadPaused()");
                            }

                            @Override
                            public void onDownloadCanceled() {
                                Log.e(TAG, "onDownloadCanceled()");
                            }

                            @Override
                            public void onFailed(DownloadException e) {

                                Log.e(TAG, "onFailed()" + e);
                                downloadPb.setVisibility(View.GONE);
                                download.setVisibility(View.VISIBLE);
                            }
                        });
                    } else {
                        if(fuItemBean.isSelected()){

                            itemView.setBackgroundResource(0);
                            fuItemBean.setSelected(false);

                        }else{

                            itemView.setBackgroundResource(R.drawable.fu_item_selected_bg);
                            fuItemBean.setSelected(true);
                        }
                    }


                }
            });

        }

        public void bindData(FuItemBean fuItemBean) {

            //如果本地有的话，不现实下载按钮，
            this.fuItemBean = fuItemBean;

            if (fuItemBean.isSelected()) {
                itemView.setBackgroundResource(R.drawable.fu_item_selected_bg);
            }else{
                itemView.setBackgroundResource(0);
            }

            if(fuItemBean.isDownload()) {
                download.setVisibility(View.GONE);
            }else{
                download.setVisibility(View.VISIBLE);
            }

            Glide.with(mContext).load(fuItemBean.getIcon()).diskCacheStrategy(DiskCacheStrategy.ALL).priority(Priority.LOW).into(fuIcon);
        }

    }
}
