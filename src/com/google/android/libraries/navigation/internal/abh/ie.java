package com.google.android.libraries.navigation.internal.abh;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ie {
    public final RelativeLayout a;
    public TextView b;
    public final boolean c;
    private final be d;
    private ImageView e;
    private final boolean f;

    public ie(be beVar, String str, boolean z, boolean z2) {
        RelativeLayout relativeLayout = new RelativeLayout(beVar.i());
        this.a = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.d = beVar;
        this.c = z;
        this.f = z2;
        ImageView imageView = new ImageView(beVar.i());
        this.e = imageView;
        imageView.setImageDrawable(beVar.l(com.google.android.gms.maps.al.v));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(20);
        layoutParams.addRule(12);
        int iE = beVar.e(com.google.android.gms.maps.ak.j);
        layoutParams.setMargins(iE, iE, iE, iE);
        this.e.setLayoutParams(layoutParams);
        this.e.setTag("GoogleWatermark");
        this.e.setVisibility(true != z2 ? 8 : 0);
        relativeLayout.addView(this.e);
        this.b = new TextView(beVar.i());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(21);
        layoutParams2.addRule(12);
        this.b.setLayoutParams(layoutParams2);
        this.b.setTextSize(0, beVar.e(com.google.android.gms.maps.ak.g));
        this.b.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.b.setSingleLine(true);
        this.b.setTag("GoogleCopyrights");
        this.b.setVisibility(true == z ? 0 : 8);
        relativeLayout.addView(this.b);
        String strConcat = com.google.android.libraries.navigation.internal.afu.p.c() ? "".concat(String.valueOf(String.format("InternalOnly[%s%s%s]", str, str, str))) : "";
        if (com.google.android.libraries.navigation.internal.afu.p.a.a().d()) {
            strConcat = (strConcat.isEmpty() ? strConcat : strConcat.concat(String.valueOf(com.google.android.libraries.navigation.internal.yx.bk.LINE_SEPARATOR.a()))).concat(String.valueOf(String.format(Locale.US, "[%s] Renderer version: %d", "CONFIDENTIAL", 0)));
        }
        if (strConcat.isEmpty()) {
            return;
        }
        TextView textView = new TextView(beVar.i());
        textView.setClickable(false);
        textView.setBackgroundColor(-1862270977);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(10.0f);
        textView.setPadding(5, 0, 5, 0);
        textView.setText(strConcat);
        textView.setTag("MapViewDebugWatermark");
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(12);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(10, 0, 10, 0);
        relativeLayout.addView(textView, layoutParams3);
    }

    public final void a(boolean z) {
        this.e.setImageDrawable(this.d.l(z ? com.google.android.gms.maps.al.w : com.google.android.gms.maps.al.v));
    }
}
