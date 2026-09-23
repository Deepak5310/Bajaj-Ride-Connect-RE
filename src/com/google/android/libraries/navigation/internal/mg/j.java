package com.google.android.libraries.navigation.internal.mg;

import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.ld.ab;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j extends h {
    private final f a;
    private final com.google.android.libraries.navigation.internal.le.m b;
    private final l c;

    public j(f fVar, com.google.android.libraries.navigation.internal.le.m mVar, l lVar) {
        this.a = fVar;
        this.b = mVar;
        this.c = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.mg.h, com.google.android.libraries.navigation.internal.mg.b
    public final void c(ab abVar) {
        if (abVar.b()) {
            this.b.f();
        } else {
            this.b.f();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.mg.h, com.google.android.libraries.navigation.internal.mg.b
    public final void d(ab abVar) throws RemoteException {
        if (!abVar.b()) {
            this.b.f();
            return;
        }
        l lVar = this.c;
        if (lVar == null) {
            this.b.f();
        } else {
            this.a.f(lVar, this);
        }
    }
}
