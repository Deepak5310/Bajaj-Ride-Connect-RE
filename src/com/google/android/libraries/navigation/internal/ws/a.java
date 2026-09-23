package com.google.android.libraries.navigation.internal.ws;

import com.google.android.libraries.navigation.internal.aac.as;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements as {
    final AtomicReference a;

    public a(as asVar) {
        AtomicReference atomicReference = new AtomicReference();
        this.a = atomicReference;
        atomicReference.set(asVar);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        as asVar = (as) this.a.getAndSet(null);
        if (asVar != null) {
            asVar.a(th);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void b(Object obj) {
        as asVar = (as) this.a.getAndSet(null);
        if (asVar != null) {
            asVar.b(obj);
        }
    }

    public final void c() {
        this.a.set(null);
    }
}
