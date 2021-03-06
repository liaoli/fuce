package com.alpha58.okhttps.https;

import android.content.Context;

import com.alpha58.okhttps.utils.HTTPSUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.InputStream;

import livestartv.livestar.com.fu.SSLSocketClient;
import okhttp3.OkHttpClient;

/**
 * A {@link GlideModule} implementation to replace Glide's default
 * {@link java.net.HttpURLConnection} based {@link com.bumptech.glide.load.model.ModelLoader} with an OkHttp based
 * {@link com.bumptech.glide.load.model.ModelLoader}.
 *
 * <p>
 *     If you're using gradle, you can include this module simply by depending on the aar, the module will be merged
 *     in by manifest merger. For other build systems or for more more information, see
 *     {@link GlideModule}.
 * </p>
 */
public class OkHttpGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        // Do nothing.
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        OkHttpClient mHttpClient = new OkHttpClient().newBuilder().
        addNetworkInterceptor(new StethoInterceptor())
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build();
        glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(mHttpClient));

    }
}
