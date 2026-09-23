package com.bumptech.glide.integration.okhttp;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class OkHttpStreamFetcher implements DataFetcher<InputStream> {
    private static final String TAG = "OkHttpFetcher";
    private final OkHttpClient client;
    ResponseBody responseBody;
    InputStream stream;
    private final GlideUrl url;

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
    }

    public OkHttpStreamFetcher(OkHttpClient okHttpClient, GlideUrl glideUrl) {
        this.client = okHttpClient;
        this.url = glideUrl;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority priority, final DataFetcher.DataCallback<? super InputStream> dataCallback) {
        Request.Builder builderUrl = new Request.Builder().url(this.url.toStringUrl());
        for (Map.Entry<String, String> entry : this.url.getHeaders().entrySet()) {
            builderUrl.addHeader(entry.getKey(), entry.getValue());
        }
        this.client.newCall(builderUrl.build()).enqueue(new Callback() { // from class: com.bumptech.glide.integration.okhttp.OkHttpStreamFetcher.1
            @Override // com.squareup.okhttp.Callback
            public void onFailure(Request request, IOException iOException) {
                if (Log.isLoggable(OkHttpStreamFetcher.TAG, 3)) {
                    Log.d(OkHttpStreamFetcher.TAG, "OkHttp failed to obtain result", iOException);
                }
                dataCallback.onLoadFailed(iOException);
            }

            @Override // com.squareup.okhttp.Callback
            public void onResponse(Response response) throws IOException {
                OkHttpStreamFetcher.this.responseBody = response.body();
                if (response.isSuccessful()) {
                    long jContentLength = OkHttpStreamFetcher.this.responseBody.contentLength();
                    OkHttpStreamFetcher okHttpStreamFetcher = OkHttpStreamFetcher.this;
                    okHttpStreamFetcher.stream = ContentLengthInputStream.obtain(okHttpStreamFetcher.responseBody.byteStream(), jContentLength);
                    dataCallback.onDataReady(OkHttpStreamFetcher.this.stream);
                    return;
                }
                dataCallback.onLoadFailed(new HttpException(response.message(), response.code()));
            }
        });
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        try {
            InputStream inputStream = this.stream;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        ResponseBody responseBody = this.responseBody;
        if (responseBody != null) {
            try {
                responseBody.close();
            } catch (IOException unused2) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }
}
