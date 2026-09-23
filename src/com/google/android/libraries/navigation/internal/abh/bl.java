package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.facebook.react.devsupport.StackTraceHelper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bl {
    private static final int b = com.google.android.gms.maps.al.u;
    public final RelativeLayout a;
    private final RelativeLayout c;
    private final ImageView d;
    private final TextView e;

    public bl(be beVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(beVar, "contextManager");
        Context contextI = beVar.i();
        RelativeLayout relativeLayout = new RelativeLayout(contextI);
        this.a = relativeLayout;
        RelativeLayout relativeLayout2 = new RelativeLayout(contextI);
        this.c = relativeLayout2;
        ImageView imageView = new ImageView(contextI);
        this.d = imageView;
        TextView textView = new TextView(contextI);
        this.e = textView;
        Drawable drawableL = beVar.l(b);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setVisibility(0);
        relativeLayout.setClickable(false);
        relativeLayout.setBackgroundColor(-2039584);
        relativeLayout.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        relativeLayout2.setVisibility(0);
        relativeLayout2.setClickable(false);
        relativeLayout2.setBackgroundColor(-2039584);
        relativeLayout2.setLayoutParams(layoutParams2);
        relativeLayout.addView(relativeLayout2, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(10);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(10, 10, 10, 10);
        imageView.setId(ViewCompat.generateViewId());
        imageView.setVisibility(0);
        imageView.setTag("AlertIcon");
        imageView.setClickable(false);
        imageView.setBackgroundColor(-2039584);
        imageView.setImageDrawable(drawableL);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        relativeLayout2.addView(imageView, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(13);
        layoutParams4.addRule(3, imageView.getId());
        layoutParams4.setMargins(10, 10, 10, 10);
        textView.setId(ViewCompat.generateViewId());
        textView.setVisibility(0);
        textView.setTag("ErrorMessage");
        textView.setClickable(false);
        textView.setBackgroundColor(-2039584);
        textView.setTextColor(-10395295);
        textView.setTextSize(20.0f);
        textView.setGravity(17);
        relativeLayout2.addView(textView, layoutParams4);
    }

    public final void a(String str) {
        com.google.android.libraries.navigation.internal.abf.s.k(str, StackTraceHelper.MESSAGE_KEY);
        this.e.setText(str);
    }
}
