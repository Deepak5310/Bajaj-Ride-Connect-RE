package com.google.android.libraries.navigation.internal.xe;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.abh.fi {
    private final WeakReference b;
    private final WeakReference c;

    public a(ds dsVar, com.google.android.libraries.navigation.internal.xd.a aVar) {
        this.b = new WeakReference(dsVar);
        this.c = new WeakReference(aVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fi
    public final void a(boolean z) {
        ds dsVar = (ds) this.b.get();
        com.google.android.libraries.navigation.internal.xd.a aVar = (com.google.android.libraries.navigation.internal.xd.a) this.c.get();
        if (dsVar == null || aVar == null) {
            return;
        }
        dsVar.L(z);
        aVar.a(com.google.android.libraries.navigation.internal.zp.n.S);
    }
}
