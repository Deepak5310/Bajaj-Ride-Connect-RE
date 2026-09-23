package com.google.android.libraries.navigation.internal.mt;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.bu;
import com.google.android.libraries.navigation.internal.ms.cp;
import com.google.android.libraries.navigation.internal.ms.cq;
import com.google.android.libraries.navigation.internal.ms.cr;
import com.google.android.libraries.navigation.internal.mz.m;
import com.google.android.libraries.navigation.internal.yx.ag;
import com.google.android.libraries.navigation.internal.yx.ah;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.az;
import com.google.android.libraries.navigation.internal.yz.ed;
import com.google.maps.android.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    public final az a;
    public final cr c;
    public int d;
    public m f;
    public m g;
    public final List b = new ArrayList();
    public final Handler e = new Handler(Looper.getMainLooper());

    public g(cr crVar) {
        this.c = crVar;
        this.a = crVar.e;
    }

    public static final void j(View view) {
        cq cqVarA = cp.a(view);
        if (cqVarA != null) {
            cqVarA.e();
        }
    }

    private static String k(bt btVar) {
        return btVar == null ? BuildConfig.TRAVIS : btVar.f().replace("com.google.android.apps", "");
    }

    public final int a() {
        return this.b.size();
    }

    public final int b(int i) {
        bu buVar = (bu) this.b.get(i);
        if (!buVar.a().g()) {
            return (-i) - 1;
        }
        Integer num = (Integer) this.a.get(buVar.a());
        if (num != null) {
            return num.intValue();
        }
        HashMap map = new HashMap();
        for (Map.Entry entry : this.a.entrySet()) {
            map.put(k((bt) entry.getKey()), (Integer) entry.getValue());
        }
        ag agVar = new ag(new ah(","), "=");
        String strA = new ag(agVar.a.b(), agVar.b).a(map);
        if (strA.length() > 100) {
            strA = String.valueOf(strA.substring(0, 100)).concat("...");
        }
        throw new NullPointerException(String.format("Layout %s not in viewTypes. position=%d size=%d [%s]", k(buVar.a()), Integer.valueOf(i), Integer.valueOf(((ed) this.a).c), strA));
    }

    public final View c(ViewGroup viewGroup, int i) {
        return this.c.d(d(i), viewGroup, false).a();
    }

    public final bt d(int i) {
        return i < 0 ? ((bu) this.b.get((-i) - 1)).a() : (bt) this.a.d().get(Integer.valueOf(i));
    }

    public final Object e(int i) {
        return ((bu) this.b.get(i)).d();
    }

    public final void f(bu buVar) {
        ar.r(buVar, "Null layout provided");
        this.b.add(buVar);
        bt btVarA = buVar.a();
        boolean z = true;
        if (this.d != 0 && ((Integer) this.a.get(btVarA)).intValue() >= this.d) {
            z = false;
        }
        ar.b(z, "Cannot add a new layout type once viewTypeCount is evaluated!");
        if (this.a.containsKey(btVarA)) {
            return;
        }
        az azVar = this.a;
        azVar.put(btVarA, Integer.valueOf(azVar.keySet().size()));
    }

    public final void g() {
        this.b.clear();
    }

    public final void h(View view, int i) {
        bu buVar = (bu) this.b.get(i);
        cq cqVarA = cp.a(view);
        if (cqVarA == null) {
            return;
        }
        if (buVar.a().g() || cqVarA.a.j != buVar.d()) {
            cqVarA.c(buVar.d());
        }
    }

    public final void i(int i) {
        ((bu) this.b.get(i)).c();
    }
}
