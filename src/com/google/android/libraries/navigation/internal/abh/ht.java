package com.google.android.libraries.navigation.internal.abh;

import android.content.Context;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ht {
    public static final String a = "ht";
    public static final AtomicReference b = new AtomicReference(null);
    private static final AtomicReference c = new AtomicReference(null);
    private final hw d;

    public ht(hw hwVar) {
        this.d = hwVar;
        com.google.android.libraries.navigation.internal.afu.d.n();
    }

    public static com.google.android.libraries.navigation.internal.me.w a() {
        return (com.google.android.libraries.navigation.internal.me.w) b.get();
    }

    public static ht b(Context context, id idVar, String str, com.google.android.libraries.navigation.internal.wx.c cVar, ea eaVar) {
        hw hwVar;
        e(context);
        com.google.android.libraries.navigation.internal.ky.o oVarA = ds.a(context, "MAPS_API");
        if (oVarA != null) {
            com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
            hwVar = new hw(new hq(context, str, idVar, cVar, eaVar), new hr(context, oVarA), com.google.android.libraries.navigation.internal.abf.ah.d("ula"), new hv());
        } else {
            hwVar = null;
        }
        return new ht(hwVar);
    }

    static void e(Context context) {
        AtomicReference atomicReference = c;
        com.google.android.libraries.navigation.internal.mf.n nVar = new com.google.android.libraries.navigation.internal.mf.n(context, new com.google.android.libraries.navigation.internal.mf.t());
        while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, nVar)) {
            if (atomicReference.get() != null) {
                return;
            }
        }
        final com.google.android.libraries.navigation.internal.mf.w wVar = (com.google.android.libraries.navigation.internal.mf.w) c.get();
        b.set(wVar.a());
        wVar.b(new com.google.android.libraries.navigation.internal.mf.v() { // from class: com.google.android.libraries.navigation.internal.abh.hs
            @Override // com.google.android.libraries.navigation.internal.mf.v
            public final void a() {
                ht.b.set(wVar.a());
            }
        });
    }

    public final synchronized void c(com.google.android.libraries.navigation.internal.abx.b bVar) {
        com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
        com.google.android.libraries.navigation.internal.afu.d.n();
        hw hwVar = this.d;
        if (hwVar != null) {
            synchronized (hwVar) {
                hwVar.a.add(bVar);
                if (!hwVar.b) {
                    hwVar.b = true;
                    hwVar.c.execute(hwVar);
                }
            }
        }
    }

    public final synchronized void d() {
        if (this.d != null) {
            com.google.android.libraries.navigation.internal.afu.d.q();
        }
    }

    public final synchronized void f(int i) {
        hw hwVar = this.d;
        if (hwVar != null) {
            synchronized (hwVar) {
                hwVar.d = i;
            }
        }
    }
}
