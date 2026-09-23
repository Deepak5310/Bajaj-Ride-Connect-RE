package com.google.android.libraries.navigation.internal.ab;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.m;
import com.google.android.libraries.navigation.internal.jy.r;
import com.google.android.libraries.navigation.internal.jy.t;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.zp.ca;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements ViewTreeObserver.OnPreDrawListener, ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
    public static final int a = com.google.android.libraries.navigation.internal.f.e.e;
    public boolean b;
    private final View c;
    private final t d;
    private final b e = new b();
    private WeakReference f = new WeakReference(null);
    private an g = com.google.android.libraries.navigation.internal.yx.a.a;

    public c(View view, t tVar) {
        this.c = view;
        this.d = tVar;
    }

    public static void a(View view) {
        com.google.android.libraries.navigation.internal.jw.e.d(view, null);
    }

    public final void b() {
        r rVar = (r) this.f.get();
        m mVar = (m) this.g.f();
        if (rVar == null || mVar == null) {
            return;
        }
        this.f.clear();
        this.g = com.google.android.libraries.navigation.internal.yx.a.a;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        aa aaVarC;
        if (!this.b && (aaVarC = com.google.android.libraries.navigation.internal.jw.e.c(this.c)) != null && !aaVarC.equals(aa.c)) {
            View view = this.c;
            int width = view.getWidth();
            int height = view.getHeight();
            if (aaVarC.g() != ca.VISIBILITY_VISIBLE || (width != 0 && height != 0)) {
                b bVar = this.e;
                View view2 = this.c;
                view2.getLocationOnScreen(bVar.a);
                int[] iArr = bVar.a;
                int i = iArr[0];
                bVar.b.set(i, iArr[1], view2.getWidth() + i, bVar.a[1] + view2.getHeight());
                b bVar2 = this.e;
                Rect rect = bVar2.b;
                int i2 = rect.left == rect.right ? bVar2.b.right : bVar2.b.right - 1;
                Rect rect2 = bVar2.b;
                int i3 = rect2.bottom == rect2.top ? bVar2.b.bottom : bVar2.b.bottom - 1;
                Rect rect3 = bVar2.b;
                Rect rect4 = bVar2.d;
                int i4 = rect3.left;
                int i5 = rect3.top;
                if (i2 >= rect4.left && i4 < bVar2.d.right && i3 >= bVar2.d.top && i5 < bVar2.d.bottom) {
                    t tVar = this.d;
                    View view3 = this.c;
                    r rVarC = tVar.c(view3);
                    com.google.android.libraries.navigation.internal.jw.e.d(this.c, rVarC.a(view3));
                    this.b = true;
                    rVarC.c();
                }
            }
        }
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.b = false;
        Display defaultDisplay = ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        this.e.d.set(0, 0, point.x, point.y);
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        b();
        a(this.c);
    }
}
