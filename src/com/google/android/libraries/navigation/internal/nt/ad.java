package com.google.android.libraries.navigation.internal.nt;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad implements t {
    final WeakReference a;

    public ad(WeakReference weakReference) {
        u uVar = (u) weakReference.get();
        boolean z = true;
        if (uVar != null && !(uVar instanceof t)) {
            z = false;
        }
        ar.k(z);
        this.a = weakReference;
    }

    public static final t b(u uVar) {
        ar.k(uVar instanceof t);
        return (t) uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(m mVar) {
        u uVar = (u) this.a.get();
        if (uVar != null) {
            b(uVar).a(mVar);
        }
    }
}
