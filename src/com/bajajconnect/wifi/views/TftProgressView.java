package com.bajajconnect.wifi.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bajajconnect.R;
import com.bajajconnect.wifi.StreamingImageHandler;

/* JADX INFO: loaded from: classes3.dex */
public class TftProgressView {
    final Context context;
    private final View view;

    public void iniVariables() {
    }

    public TftProgressView(Context context) {
        this.context = context;
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.tft_loading_screen, (ViewGroup) null);
        this.view = viewInflate;
        viewInflate.measure(View.MeasureSpec.getSize(viewInflate.getMeasuredWidth()), View.MeasureSpec.getSize(viewInflate.getMeasuredHeight()));
        viewInflate.layout(0, 0, 800, StreamingImageHandler.TFT_HEIGHT);
        iniVariables();
    }

    public View getView() {
        return this.view;
    }
}
