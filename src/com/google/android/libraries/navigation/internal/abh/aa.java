package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa {
    public static final int a = ViewCompat.generateViewId();
    public static final int b = ViewCompat.generateViewId();
    public static final int c = ViewCompat.generateViewId();
    public static final int d = ViewCompat.generateViewId();
    public static final int e = ViewCompat.generateViewId();
    public final RelativeLayout f;
    public Cif g;
    public fc h;
    public df i;
    public final el j;
    public av k;
    private final be l;

    public aa(be beVar, el elVar) {
        int i;
        RelativeLayout relativeLayout = new RelativeLayout(beVar.i());
        this.f = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.l = beVar;
        this.j = elVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (com.google.android.libraries.navigation.internal.abf.e.b) {
            b(layoutParams);
            layoutParams.addRule(15);
        } else {
            a(layoutParams);
            layoutParams.addRule(10);
        }
        d(layoutParams, 0, beVar.e(com.google.android.gms.maps.ak.d), beVar.e(com.google.android.gms.maps.ak.d), 0);
        ImageView imageView = new ImageView(beVar.i());
        imageView.setImageDrawable(beVar.l(com.google.android.libraries.navigation.internal.abf.e.b ? com.google.android.gms.maps.al.e : com.google.android.gms.maps.al.d));
        imageView.setVisibility(8);
        imageView.setContentDescription(beVar.n(com.google.android.gms.maps.am.f));
        imageView.setTag("GoogleMapMyLocationButton");
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new fb(imageView));
        fc fcVar = new fc(imageView);
        this.h = fcVar;
        ImageView imageView2 = fcVar.a;
        int i2 = b;
        c(imageView2, i2, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        a(layoutParams2);
        int i3 = a;
        layoutParams2.addRule(2, i3);
        layoutParams2.addRule(3, i2);
        d(layoutParams2, 0, beVar.e(com.google.android.gms.maps.ak.d), beVar.e(com.google.android.gms.maps.ak.d), beVar.e(com.google.android.gms.maps.ak.d));
        dn dnVar = new dn(beVar);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(beVar.e(com.google.android.gms.maps.ak.e), -2);
        layoutParams3.addRule(15);
        dnVar.setLayoutParams(layoutParams3);
        dnVar.setBackgroundDrawable(beVar.l(com.google.android.gms.maps.al.o));
        dnVar.setCacheColorHint(0);
        dnVar.setChoiceMode(1);
        dnVar.setDivider(new ColorDrawable(0));
        dnVar.setVerticalScrollBarEnabled(false);
        dnVar.setScrollingCacheEnabled(true);
        dnVar.setSmoothScrollbarEnabled(true);
        dnVar.setVisibility(8);
        RelativeLayout relativeLayout2 = new RelativeLayout(beVar.a);
        relativeLayout2.addView(dnVar);
        relativeLayout2.setVisibility(8);
        df dfVar = new df(dnVar, relativeLayout2);
        dfVar.a.setOnItemClickListener(new de(dfVar));
        this.i = dfVar;
        c(dfVar.b, c, layoutParams2);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        if (com.google.android.libraries.navigation.internal.abf.e.b) {
            layoutParams4.addRule(14);
            layoutParams4.addRule(10);
        } else {
            a(layoutParams4);
            layoutParams4.addRule(12);
        }
        d(layoutParams4, 0, 0, beVar.e(com.google.android.gms.maps.ak.d), beVar.e(com.google.android.gms.maps.ak.f));
        Context contextI = beVar.i();
        int i4 = com.google.android.gms.maps.al.j;
        int i5 = com.google.android.gms.maps.al.h;
        if (com.google.android.libraries.navigation.internal.abf.e.b) {
            i4 = com.google.android.gms.maps.al.k;
            i5 = com.google.android.gms.maps.al.i;
            i = 1;
        } else {
            i = 0;
        }
        LinearLayout linearLayout = new LinearLayout(contextI);
        linearLayout.setOrientation(i ^ 1);
        ImageView imageView3 = new ImageView(contextI);
        imageView3.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        imageView3.setImageDrawable(beVar.l(i4));
        imageView3.setContentDescription(beVar.n(com.google.android.gms.maps.am.j));
        imageView3.setTag("GoogleMapZoomInButton");
        ImageView imageView4 = new ImageView(contextI);
        imageView4.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        imageView4.setImageDrawable(beVar.l(i5));
        imageView4.setContentDescription(beVar.n(com.google.android.gms.maps.am.k));
        imageView4.setTag("GoogleMapZoomOutButton");
        if (i != 0) {
            linearLayout.addView(imageView4);
            linearLayout.addView(imageView3);
        } else {
            linearLayout.addView(imageView3);
            linearLayout.addView(imageView4);
        }
        Cif cif = new Cif(linearLayout, imageView3, imageView4);
        imageView3.setOnClickListener(cif);
        imageView4.setOnClickListener(cif);
        this.g = cif;
        c(cif.c, i3, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(16, i3);
        layoutParams5.alignWithParent = true;
        layoutParams5.addRule(12);
        d(layoutParams5, 0, 0, beVar.e(com.google.android.gms.maps.ak.d), beVar.e(com.google.android.gms.maps.ak.f));
        c(elVar.a, d, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        if (com.google.android.libraries.navigation.internal.abf.e.b) {
            a(layoutParams6);
            layoutParams6.addRule(15);
        } else {
            b(layoutParams6);
            layoutParams6.addRule(10);
        }
        d(layoutParams6, beVar.e(com.google.android.gms.maps.ak.d), beVar.e(com.google.android.gms.maps.ak.d), 0, 0);
        av avVar = new av(beVar);
        this.k = avVar;
        avVar.setTag("GoogleMapCompass");
        this.k.setContentDescription(beVar.n(com.google.android.gms.maps.am.b));
        c(this.k, e, layoutParams6);
    }

    private static void a(RelativeLayout.LayoutParams layoutParams) {
        layoutParams.addRule(21);
    }

    private static void b(RelativeLayout.LayoutParams layoutParams) {
        layoutParams.addRule(20);
    }

    private final void c(View view, int i, RelativeLayout.LayoutParams layoutParams) {
        view.setVisibility(8);
        view.setId(i);
        this.f.addView(view, layoutParams);
    }

    private static void d(RelativeLayout.LayoutParams layoutParams, int i, int i2, int i3, int i4) {
        layoutParams.setMargins(i, i2, i3, i4);
        layoutParams.setMarginStart(i);
        layoutParams.setMarginEnd(i3);
    }
}
