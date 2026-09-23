package com.google.android.libraries.geo.mapcore.internal.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.po.gr;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class CompassButtonView extends FrameLayout implements b {
    public static final /* synthetic */ int g = 0;
    public a a;
    public boolean b;
    public h c;
    public int d;
    public int e;
    public gr f;
    private ImageView h;
    private float i;
    private float j;
    private final float k;
    private final float l;
    private final Matrix m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Matrix f71n;
    private boolean o;
    private int p;
    private int q;
    private Drawable r;
    private Drawable s;
    private Drawable t;
    private int u;
    private int v;
    private int w;
    private com.google.android.libraries.navigation.internal.kj.a x;

    static {
        com.google.android.libraries.navigation.internal.nc.a.f(2.5d);
        com.google.android.libraries.navigation.internal.nc.a.f(0.8d);
    }

    public CompassButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 1;
        this.a = a.OFF_IF_NORTH_UP_TOP_DOWN;
        this.b = true;
        this.e = 3;
        this.k = 0.01f;
        this.l = 0.01f;
        this.m = new Matrix();
        this.f71n = new Matrix();
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = com.google.android.libraries.navigation.internal.kj.a.SMALL;
    }

    private final void l() {
        int i = this.d;
        if (i == 2) {
            return;
        }
        if (i == 1 && getVisibility() == 0) {
            return;
        }
        if (this.d != 3) {
            animate().setDuration(true != this.b ? 0L : 100L).setStartDelay(0L).alpha(1.0f).setInterpolator(com.google.android.libraries.navigation.internal.k.a.b).withStartAction(new Runnable() { // from class: com.google.android.libraries.geo.mapcore.internal.ui.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.setVisibility(0);
                }
            }).withEndAction(new Runnable() { // from class: com.google.android.libraries.geo.mapcore.internal.ui.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.d = 1;
                }
            });
            this.d = 2;
        } else {
            animate().cancel();
            setVisibility(0);
            setAlpha(1.0f);
            this.d = 1;
        }
    }

    private final void m(boolean z) {
        int i;
        if (getVisibility() != 0 || (i = this.d) == 4) {
            return;
        }
        if (z && i == 3) {
            return;
        }
        animate().setDuration(true != this.b ? 0L : 500L).setStartDelay(true == z ? 1600L : 0L).alpha(0.0f).setInterpolator(com.google.android.libraries.navigation.internal.k.a.c).withStartAction(new Runnable() { // from class: com.google.android.libraries.geo.mapcore.internal.ui.c
            @Override // java.lang.Runnable
            public final void run() {
                this.a.d = 4;
            }
        }).withEndAction(new Runnable() { // from class: com.google.android.libraries.geo.mapcore.internal.ui.d
            @Override // java.lang.Runnable
            public final void run() {
                CompassButtonView compassButtonView = this.a;
                compassButtonView.setVisibility(4);
                compassButtonView.d = 1;
            }
        });
        this.d = 3;
    }

    private static final boolean n(float f) {
        return f < 0.5f || f > 359.5f;
    }

    public final void a(float f, float f2) {
        if (n(f)) {
            this.i = 0.0f;
            this.j = f2;
            b();
            return;
        }
        float f3 = this.i;
        if (Math.abs(f - f3) < this.k) {
            float f4 = f2 - this.j;
            if (Math.abs(f4) < this.l && f3 != 0.0f) {
                return;
            }
        }
        this.i = f;
        this.j = f2;
        b();
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00c5  */
    public final void b() {
        Drawable drawable;
        com.google.android.libraries.navigation.internal.ra.c.b.f();
        int iOrdinal = this.a.ordinal();
        if (iOrdinal == 0) {
            m(false);
        } else if (iOrdinal == 1) {
            l();
        } else if (iOrdinal == 2) {
            float f = this.j;
            if (!n(this.i) || f >= 0.5f) {
                l();
            } else {
                m(true);
            }
        }
        if (this.h == null) {
            if (this.d == 1 && getVisibility() != 0) {
                return;
            }
            ImageView imageView = new ImageView(getContext());
            this.h = imageView;
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            addView(this.h, new FrameLayout.LayoutParams(-1, -1));
        }
        ImageView imageView2 = this.h;
        ar.q(imageView2);
        int i = this.u;
        if (i != -1) {
            if (i != 0) {
                this.r = getContext().getResources().getDrawable(this.u);
            } else {
                this.r = null;
            }
            this.u = -1;
        }
        int i2 = this.v;
        if (i2 != -1) {
            if (i2 != 0) {
                this.s = getContext().getResources().getDrawable(this.v);
            } else {
                this.s = null;
            }
            this.v = -1;
        }
        int i3 = this.w;
        if (i3 != -1) {
            if (i3 != 0) {
                setBackgroundResource(i3);
            } else {
                setBackground(null);
            }
            this.w = -1;
        }
        boolean zN = n(this.i);
        int i4 = this.e;
        int i5 = i4 - 1;
        if (i4 == 0) {
            throw null;
        }
        if (i5 == 0) {
            drawable = this.r;
        } else if (i5 == 1) {
            drawable = this.s;
        } else {
            if (i5 != 2) {
                throw new IllegalStateException();
            }
            if (zN) {
                drawable = this.r;
            } else {
                drawable = this.s;
            }
        }
        imageView2.setImageDrawable(drawable);
        if (drawable == null) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (this.p != width || this.q != height) {
            this.m.reset();
            this.m.setRectToRect(new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()), new RectF(0.0f, 0.0f, width, height), Matrix.ScaleToFit.CENTER);
            this.p = width;
            this.q = height;
        }
        this.f71n.set(this.m);
        if (this.o) {
            imageView2.setRotation(-this.i);
        } else {
            this.f71n.postRotate(-this.i, width / 2.0f, height / 2.0f);
        }
        imageView2.setImageMatrix(this.f71n);
    }

    public final void c(Float f) {
        if (f != null) {
            this.i = f.floatValue();
        }
    }

    public final void d(ah ahVar) {
        this.s = ahVar == null ? null : ahVar.a(getContext());
        b();
    }

    public final void e(ah ahVar) {
        this.r = ahVar == null ? null : ahVar.a(getContext());
        b();
    }

    public final void f(ah ahVar) {
        this.t = ahVar == null ? null : ahVar.a(getContext());
        b();
    }

    public final void g(com.google.android.libraries.navigation.internal.kj.a aVar) {
        if (aVar != null) {
            ar.k(false);
            if (this.x == aVar) {
                return;
            }
            this.x = aVar;
            b();
        }
    }

    public final void h() {
        b();
    }

    public final void i(Boolean bool) {
        if (bool != null) {
            bool.booleanValue();
        }
    }

    public final void j(boolean z) {
        if (this.o == z) {
            return;
        }
        this.o = z;
        b();
    }

    public final void k(a aVar) {
        if (aVar != null) {
            setVisibilityMode(aVar);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
        accessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK.getId(), getContext().getString(com.google.android.libraries.navigation.internal.qr.e.a)));
        Resources resources = getContext().getResources();
        int i = com.google.android.libraries.navigation.internal.qr.d.a;
        int i2 = (int) this.i;
        accessibilityNodeInfo.setContentDescription(resources.getQuantityString(i, i2, Integer.valueOf(i2)));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            b();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.ui.b
    public final void setBackgroundDrawableId(int i) {
        this.w = i;
        if (i != -1) {
            b();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.ui.b
    public final void setNeedleDrawableId(int i) {
        this.v = i;
        if (i != -1) {
            b();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.ui.b
    public final void setNorthDrawableId(int i) {
        this.u = i;
        if (i != -1) {
            b();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.ui.b
    public final void setVisibilityMode(a aVar) {
        this.a = aVar;
        this.b = true;
        b();
    }
}
