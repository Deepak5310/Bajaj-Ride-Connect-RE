package com.bajajconnect.views;

import android.content.Context;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public class CustomView extends FrameLayout {
    public CustomView(Context context) {
        super(context);
        setPadding(16, 16, 16, 16);
        setBackgroundColor(Color.parseColor("#fcba03"));
        TextView textView = new TextView(context);
        textView.setText("Welcome to Android Fragments with React Native.");
        textView.setTextColor(Color.parseColor("#ffffff"));
        addView(textView);
    }
}
