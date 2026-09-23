package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import java.util.LinkedList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class el extends com.google.android.libraries.navigation.internal.ly.t implements View.OnClickListener {
    public static final /* synthetic */ int f = 0;
    private static final int g = com.google.android.gms.maps.aj.e;
    public final LinearLayout a;
    public boolean b;
    public boolean c;
    public final boolean d;
    public es e;
    private final be h;
    private final ImageView i;
    private final ImageView j;
    private final LinkedList k;
    private boolean l = false;
    private final by m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f117n;
    private CameraPosition o;
    private final int p;
    private final int q;
    private final int r;

    public el(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, be beVar, by byVar, boolean z) {
        com.google.android.libraries.navigation.internal.abf.s.k(beVar, "contextManager");
        this.h = beVar;
        this.a = linearLayout;
        this.i = imageView;
        this.j = imageView2;
        this.m = byVar;
        this.d = z;
        this.p = beVar.e(com.google.android.gms.maps.ak.c);
        this.q = beVar.e(com.google.android.gms.maps.ak.b);
        this.r = beVar.e(com.google.android.gms.maps.ak.a);
        this.k = new LinkedList();
        linearLayout.setOrientation(0);
        linearLayout.setTag("GoogleMapToolbar");
        linearLayout.setVisibility(8);
        imageView.setImageDrawable(beVar.l(com.google.android.gms.maps.al.s));
        imageView.setContentDescription(beVar.n(com.google.android.gms.maps.am.h));
        imageView.setTag("GoogleMapOpenGmmButton");
        imageView2.setImageDrawable(beVar.l(com.google.android.gms.maps.al.r));
        imageView2.setContentDescription(beVar.n(com.google.android.gms.maps.am.c));
        imageView2.setTag("GoogleMapDirectionsButton");
        imageView2.setColorFilter(beVar.d(g));
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        linearLayout.addView(imageView2);
        linearLayout.addView(imageView);
    }

    static void b(View view, boolean z) {
        TranslateAnimation translateAnimation;
        if (z == (view.getVisibility() == 0)) {
            return;
        }
        if (z) {
            translateAnimation = new TranslateAnimation(2, true != g(view) ? 0.8f : -0.2f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setInterpolator(new DecelerateInterpolator());
            translateAnimation.setDuration(300L);
        } else {
            translateAnimation = new TranslateAnimation(1, 0.0f, 2, true != g(view) ? 0.8f : -0.2f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setInterpolator(new AccelerateInterpolator());
            translateAnimation.setDuration(300L);
        }
        view.startAnimation(translateAnimation);
    }

    private final void f(ImageView imageView, int i) {
        imageView.setBackground(this.h.l(i));
        Drawable background = imageView.getBackground();
        imageView.setLayoutParams(new LinearLayout.LayoutParams(background.getIntrinsicWidth(), background.getIntrinsicHeight()));
        if (i == com.google.android.gms.maps.al.f) {
            imageView.setPadding(this.q, 0, this.p, this.r);
        } else if (i == com.google.android.gms.maps.al.b) {
            imageView.setPadding(this.p, 0, this.q, this.r);
        } else {
            imageView.setPadding(0, 0, 0, this.r);
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER);
    }

    private static boolean g(View view) {
        return view.getLayoutDirection() == 1;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.u
    public final void a(CameraPosition cameraPosition) {
        es esVar;
        this.o = cameraPosition;
        if (this.d || (esVar = this.e) == null) {
            return;
        }
        ez ezVar = esVar.b;
        Point pointA = ezVar.i.c().e().a(esVar.g());
        View viewB = ezVar.i.b();
        if (pointA.x < 0 || pointA.x >= viewB.getWidth() || pointA.y < 0 || pointA.y >= viewB.getHeight()) {
            c();
        }
    }

    public final void c() {
        this.e = null;
        if (!this.d) {
            b(this.a, false);
        }
        this.l = false;
        this.a.setVisibility(8);
    }

    public final void d() {
        if (this.l && this.c && this.b) {
            if (!this.d) {
                b(this.a, true);
            }
            this.a.setVisibility(0);
        }
    }

    public final void e(boolean z, es esVar, boolean z2) {
        this.l = true;
        if (this.b) {
            this.j.setVisibility(true != z ? 8 : 0);
            this.i.setVisibility(0);
            this.e = esVar;
            this.f117n = z2;
            this.k.clear();
            if (z) {
                this.k.add(this.j);
            }
            this.k.add(this.i);
            int size = this.k.size();
            if (size == 1) {
                f((ImageView) this.k.get(0), com.google.android.gms.maps.al.g);
            } else {
                for (int i = 0; i < size; i++) {
                    ImageView imageView = (ImageView) this.k.get(i);
                    if (i == 0) {
                        f(imageView, g(this.a) ? com.google.android.gms.maps.al.f : com.google.android.gms.maps.al.b);
                    } else if (i == size - 1) {
                        f(imageView, g(this.a) ? com.google.android.gms.maps.al.b : com.google.android.gms.maps.al.f);
                    } else {
                        f(imageView, com.google.android.gms.maps.al.c);
                    }
                }
            }
            d();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.i) {
            this.m.a(this.o, this.e, this.f117n);
            return;
        }
        if (view == this.j) {
            by byVar = this.m;
            es esVar = this.e;
            byVar.c();
            byVar.a.c(com.google.android.libraries.navigation.internal.abx.b.INTENT_DIRECTIONS);
            LatLng latLngG = esVar == null ? null : esVar.g();
            if (latLngG == null) {
                return;
            }
            byVar.b("https://maps.google.com/maps?saddr=&daddr=" + latLngG.latitude + "," + latLngG.longitude);
        }
    }
}
