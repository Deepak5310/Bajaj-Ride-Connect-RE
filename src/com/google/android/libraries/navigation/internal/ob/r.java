package com.google.android.libraries.navigation.internal.ob;

import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class r {
    public static final r f;
    public static final int g;

    static {
        p pVarR = r();
        pVarR.i(new com.google.android.libraries.navigation.internal.oe.r(0.0d, 0.0d));
        f = pVarR.j();
        g = ex.LEGEND_STYLE_UNDEFINED.CG;
    }

    public static p r() {
        a aVar = new a();
        aVar.b(0L);
        aVar.g(Integer.MIN_VALUE);
        q qVar = q.PLACEMARK;
        Objects.requireNonNull(qVar);
        aVar.b = qVar;
        aVar.c(ex.LEGEND_STYLE_UNDEFINED.CG);
        aVar.f(ex.LEGEND_STYLE_UNDEFINED.CG);
        int i = ev.d;
        ev evVar = lv.a;
        Objects.requireNonNull(evVar);
        aVar.c = evVar;
        aVar.d(0);
        aVar.e(ex.LEGEND_STYLE_UNDEFINED.CG);
        aVar.d = (short) (aVar.d | 96);
        aVar.h(u.NORMAL);
        aVar.a = true;
        aVar.d = (short) (aVar.d | 4);
        return aVar;
    }

    public abstract int a();

    public abstract int b();

    public abstract int c();

    public abstract int d();

    public abstract int e();

    public abstract long f();

    public abstract q g();

    public abstract u h();

    public abstract com.google.android.libraries.navigation.internal.oe.r i();

    public abstract an j();

    public abstract an k();

    public abstract ev l();

    public abstract boolean m();

    public abstract void n();

    public abstract void o();

    public abstract void p();

    public abstract void q();
}
