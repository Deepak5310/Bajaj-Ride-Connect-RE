package com.google.android.apps.gmm.base.components.gmmrecyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.navigation.internal.ms.ah;
import com.google.android.libraries.navigation.internal.ms.by;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.mx.f;
import com.google.android.libraries.navigation.internal.mx.g;
import com.google.android.libraries.navigation.internal.mx.m;
import com.google.android.libraries.navigation.internal.mz.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public class GmmRecyclerView extends RecyclerView {
    private float a;
    private float b;
    private final List c;

    public GmmRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new ArrayList();
    }

    @SafeVarargs
    public static g a(final dd ddVar, m... mVarArr) {
        f fVar = new f(com.google.android.libraries.navigation.internal.l.a.a, com.google.android.libraries.navigation.internal.mz.g.c(new e(1)), ah.ah(new by() { // from class: com.google.android.libraries.navigation.internal.ms.u
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                bs bsVar = new bs();
                Iterator it2 = ((Iterable) ddVar.a(csVar)).iterator();
                while (it2.hasNext()) {
                    bsVar.a((bu) it2.next());
                }
                return bsVar;
            }
        }));
        fVar.e(mVarArr);
        return fVar;
    }

    private final void d(int i, int i2, c cVar) {
        boolean z = false;
        if (!ViewCompat.hasNestedScrollingParent(this)) {
            if (ViewCompat.startNestedScroll(this, (i != 0 ? 1 : 0) | (i2 != 0 ? 2 : 0))) {
                int[] iArr = new int[2];
                ViewCompat.dispatchNestedPreScroll(this, i, i2, iArr, null);
                i -= iArr[0];
                i2 -= iArr[1];
                z = true;
            }
        }
        cVar.a(i, i2);
        if (z) {
            ViewCompat.stopNestedScroll(this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void addOnItemTouchListener(RecyclerView.OnItemTouchListener onItemTouchListener) {
        super.addOnItemTouchListener(onItemTouchListener);
        this.c.add(onItemTouchListener);
    }

    public final /* synthetic */ void b(int i, int i2) {
        super.scrollBy(i, i2);
    }

    public final /* synthetic */ void c(int i, int i2) {
        super.smoothScrollBy(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.c.isEmpty()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = motionEvent.getX();
            this.b = motionEvent.getY();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (action != 2) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        boolean z = getLayoutManager().canScrollHorizontally() && !getLayoutManager().canScrollVertically();
        boolean z2 = !getLayoutManager().canScrollHorizontally() && getLayoutManager().canScrollVertically();
        float fAbs = Math.abs(this.a - motionEvent.getX());
        float fAbs2 = Math.abs(this.b - motionEvent.getY());
        if ((!z || fAbs >= fAbs2) && (!z2 || fAbs <= fAbs2)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void removeOnItemTouchListener(RecyclerView.OnItemTouchListener onItemTouchListener) {
        this.c.remove(onItemTouchListener);
        super.removeOnItemTouchListener(onItemTouchListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void scrollBy(int i, int i2) {
        d(i, i2, new c() { // from class: com.google.android.apps.gmm.base.components.gmmrecyclerview.a
            @Override // com.google.android.apps.gmm.base.components.gmmrecyclerview.c
            public final void a(int i3, int i4) {
                this.a.b(i3, i4);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void smoothScrollBy(int i, int i2) {
        d(i, i2, new c() { // from class: com.google.android.apps.gmm.base.components.gmmrecyclerview.b
            @Override // com.google.android.apps.gmm.base.components.gmmrecyclerview.c
            public final void a(int i3, int i4) {
                this.a.c(i3, i4);
            }
        });
    }
}
