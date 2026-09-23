package com.google.android.libraries.navigation.internal.mq;

import android.content.Context;
import android.os.Looper;
import android.os.NetworkOnMainThreadException;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.ky.av;
import com.google.android.libraries.navigation.internal.lc.al;
import com.google.android.libraries.navigation.internal.mn.e;
import com.google.android.libraries.navigation.internal.mn.g;
import com.google.android.libraries.navigation.internal.mn.h;
import com.google.android.libraries.navigation.internal.mn.k;
import com.google.android.libraries.navigation.internal.mn.l;
import com.google.android.libraries.navigation.internal.mp.d;
import com.google.android.libraries.navigation.internal.xo.ah;
import com.google.android.libraries.navigation.internal.xo.y;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements av {
    private final e a;
    private final l b;

    public b(Context context, l lVar) {
        Context context2;
        ar.q(context);
        Context applicationContext = context.getApplicationContext();
        c cVar = new c();
        com.google.android.libraries.navigation.internal.mn.a aVar = new com.google.android.libraries.navigation.internal.mn.a();
        aVar.a();
        if (applicationContext == null) {
            throw new NullPointerException("Null context");
        }
        aVar.a = applicationContext;
        aVar.c = an.j(cVar);
        aVar.a();
        if (aVar.e == 1 && (context2 = aVar.a) != null) {
            this.a = new com.google.android.libraries.navigation.internal.mn.b(context2, aVar.b, aVar.c, aVar.d);
            this.b = lVar;
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (aVar.a == null) {
            sb.append(" context");
        }
        if (aVar.e == 0) {
            sb.append(" googlerOverridesCheckbox");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0055 A[Catch: all -> 0x0057, DONT_GENERATE, TryCatch #0 {, blocks: (B:8:0x0024, B:10:0x0028, B:12:0x0036, B:14:0x0042, B:16:0x0050, B:18:0x0052, B:19:0x0055), top: B:43:0x0024 }] */
    @Override // com.google.android.libraries.navigation.internal.ky.av
    public final boolean a(x xVar) {
        xVar.B();
        a aVar = h.a;
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            throw new NetworkOnMainThreadException();
        }
        e eVar = this.a;
        a aVar2 = h.a;
        boolean z = d.a;
        Context context = ((com.google.android.libraries.navigation.internal.mn.b) eVar).a;
        if (!z) {
            synchronized (d.b) {
                if (!d.a) {
                    d.a = true;
                    y.e(context);
                    ah.f(context);
                    if (!g.a(context)) {
                        if (!com.google.android.libraries.navigation.internal.aft.a.a.a().b() || al.a(context).b(context.getPackageName())) {
                            d.a(eVar, aVar2);
                        }
                    }
                }
            }
        }
        if (com.google.android.libraries.navigation.internal.aft.a.a.a().a()) {
            if (k.a == null) {
                synchronized (k.class) {
                    if (k.a == null) {
                        k.a = new k();
                    }
                }
            }
            k kVar = k.a;
        }
        com.google.android.libraries.navigation.internal.aft.d.a.a();
        com.google.android.libraries.navigation.internal.aft.a.a.a().c();
        return true;
    }

    public final String toString() {
        return "CollectionBasisLogVerifier{collectionBasisContext=" + this.a + ", basis=" + this.b + "}";
    }
}
