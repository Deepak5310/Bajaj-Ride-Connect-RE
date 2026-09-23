package com.google.android.libraries.navigation.internal.ms;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.bajajconnect.rideapp.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ck {
    private static final com.google.android.libraries.navigation.internal.yr.ai a = new com.google.android.libraries.navigation.internal.yr.ai() { // from class: com.google.android.libraries.navigation.internal.ms.ci
        @Override // com.google.android.libraries.navigation.internal.yr.ai, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }
    };
    private Map b;
    public final View c;
    final bx d;
    final cc e;
    public final bt f;
    public final ax g;
    int h;
    final boolean i;
    public cs j;

    public ck(View view, ax axVar, bx bxVar, cc ccVar, bt btVar, boolean z) {
        this.c = view;
        this.g = axVar;
        this.d = bxVar;
        this.e = ccVar;
        this.f = btVar;
        this.i = z;
    }

    public static ck h(View view, com.google.android.libraries.navigation.internal.yx.as asVar) {
        ck ckVarJ = j(view);
        if (ckVarJ == null) {
            return i(view, asVar);
        }
        return asVar.a(ckVarJ) ? ckVarJ : i(ckVarJ.c, asVar);
    }

    static ck i(View view, com.google.android.libraries.navigation.internal.yx.as asVar) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ck ckVarH = h(viewGroup.getChildAt(i), asVar);
            if (ckVarH != null) {
                return ckVarH;
            }
        }
        return null;
    }

    public static ck j(View view) {
        return (ck) view.getTag(2131230834);
    }

    public static cs k(View view) {
        ck ckVarJ = j(view);
        if (ckVarJ == null) {
            return null;
        }
        return ckVarJ.j;
    }

    private static void s(View view, cs csVar, int i) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt != null) {
                    ck ckVarJ = j(childAt);
                    if (ckVarJ != null) {
                        View view2 = ckVarJ.c;
                        cs csVar2 = ckVarJ.j;
                        cs csVarB = ckVarJ.b(csVar, view2.getContext());
                        ckVarJ.p(csVarB);
                        int i3 = i - 1;
                        int i4 = (i3 == 0 || i3 == 3 || csVarB == csVar2) ? i : 2;
                        AutoCloseable autoCloseableD = (csVar == csVarB || csVarB == null) ? a : com.google.android.libraries.navigation.internal.yt.d.d("ViewBinding.bindChildViewModel ", csVarB);
                        try {
                            ckVarJ.r(csVarB, i4);
                            autoCloseableD.close();
                            ckVarJ.g.h();
                            if (csVar == null) {
                                bl.a(ckVarJ.a(), ckVarJ.g.p(), i);
                            } else {
                                bl.b(ckVarJ.a(), ckVarJ.g.p(), csVar, i);
                            }
                        } catch (Throwable th) {
                            try {
                                autoCloseableD.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } else {
                        ck ckVarJ2 = j(childAt);
                        if (ckVarJ2 != null) {
                            ckVarJ2.r(csVar, i);
                        } else if (t(childAt, i)) {
                            s(childAt, csVar, i);
                        }
                    }
                }
            }
        }
    }

    private static boolean t(View view, int i) {
        if (i != 3) {
            return true;
        }
        if (view.getTag(R.drawable.abc_ic_search_api_material) == null) {
            return false;
        }
        view.setTag(R.drawable.abc_ic_search_api_material, null);
        return true;
    }

    public bx a() {
        return bx.a;
    }

    public cs b(cs csVar, Context context) {
        return csVar;
    }

    public void c(cs csVar, cs csVar2) {
    }

    public void d(cs csVar) {
    }

    public cq e() {
        return null;
    }

    public void f(cq cqVar) {
    }

    public final View g() {
        return this.c;
    }

    public final Object l(bq bqVar) {
        Map map = this.b;
        if (map != null) {
            return map.get(bqVar);
        }
        return null;
    }

    public final void m() {
        q(this.j, 2);
    }

    public final void n() {
        q(null, 4);
    }

    public final void o(bq bqVar, Object obj) {
        if (obj != null) {
            if (this.b == null) {
                this.b = new HashMap();
            }
            this.b.put(bqVar, obj);
        } else {
            Map map = this.b;
            if (map != null) {
                map.remove(bqVar);
            }
        }
    }

    final void p(cs csVar) {
        cs csVar2 = this.j;
        this.j = csVar;
        if (csVar != csVar2) {
            c(csVar2, csVar);
        }
    }

    public final void q(cs csVar, int i) {
        p(csVar);
        d(csVar);
        r(csVar, i);
    }

    public final void r(cs csVar, int i) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalStateException("Curvular bindings need to be done from the UI Thread. The current thread is ".concat(String.valueOf(String.valueOf(Thread.currentThread()))));
        }
        if (t(this.c, i)) {
            s(this.c, csVar, i);
            ax axVar = this.g;
            View view = this.c;
            axVar.h();
            cs csVar2 = this.j;
            cx cxVarP = this.g.p();
            if (this.j == null) {
                bl.a(this.d, cxVarP, i);
                this.h = 0;
                return;
            }
            com.google.android.libraries.navigation.internal.yx.ar.k(i != 4);
            int i2 = view.getContext().getResources().getConfiguration().orientation;
            if (i2 != this.h) {
                this.h = i2;
                i = 1;
            }
            bl.b(this.d, cxVarP, csVar2, i);
        }
    }
}
