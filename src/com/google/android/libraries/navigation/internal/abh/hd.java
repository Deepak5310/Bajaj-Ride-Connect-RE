package com.google.android.libraries.navigation.internal.abh;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hd {
    public final RelativeLayout a;
    final TextView b;
    final TextView c;
    private final ImageView d;

    public hd(be beVar) {
        RelativeLayout relativeLayout = new RelativeLayout(beVar.i());
        this.a = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setVisibility(8);
        TextView textViewB = b(beVar);
        this.b = textViewB;
        textViewB.setId(ViewCompat.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(21);
        layoutParams.addRule(12);
        layoutParams.setMargins(10, 0, 0, 0);
        layoutParams.setMarginStart(10);
        layoutParams.setMarginEnd(0);
        relativeLayout.addView(textViewB, layoutParams);
        TextView textViewB2 = b(beVar);
        this.c = textViewB2;
        textViewB2.setText(beVar.n(com.google.android.gms.maps.am.q));
        textViewB2.setId(ViewCompat.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(16, textViewB.getId());
        layoutParams2.addRule(12);
        relativeLayout.addView(textViewB2, layoutParams2);
        ImageView imageView = new ImageView(beVar.i());
        this.d = imageView;
        imageView.setImageDrawable(beVar.l(com.google.android.gms.maps.al.w));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(20);
        layoutParams3.addRule(12);
        int iE = beVar.e(com.google.android.gms.maps.ak.j);
        layoutParams3.setMargins(iE, iE, iE, iE);
        imageView.setLayoutParams(layoutParams3);
        imageView.setTag("GoogleWatermark");
        relativeLayout.addView(imageView);
        a("");
        if (com.google.android.libraries.navigation.internal.afu.p.c()) {
            String upperCase = "H".toUpperCase(Locale.getDefault());
            TextView textViewB3 = b(beVar);
            textViewB3.setText(String.format(Locale.getDefault(), "InternalOnly[%s%s%s]", upperCase, upperCase, upperCase));
            textViewB3.setClickable(false);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(16, textViewB2.getId());
            layoutParams4.addRule(12);
            layoutParams4.setMargins(10, 0, 10, 0);
            relativeLayout.addView(textViewB3, layoutParams4);
        }
    }

    private static TextView b(be beVar) {
        TextView textView = new TextView(beVar.i());
        textView.setClickable(true);
        textView.setBackgroundColor(-1862270977);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextSize(10.0f);
        textView.setPadding(5, 0, 5, 0);
        return textView;
    }

    public final void a(String str) {
        this.b.setText(str);
        this.b.setVisibility(true != str.isEmpty() ? 0 : 4);
    }
}
