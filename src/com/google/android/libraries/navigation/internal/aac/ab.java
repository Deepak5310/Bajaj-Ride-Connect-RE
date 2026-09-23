package com.google.android.libraries.navigation.internal.aac;

import com.google.android.libraries.navigation.internal.yz.ek;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab extends n {
    private aa b;

    public ab(ek ekVar, boolean z, Executor executor, s sVar) {
        super(ekVar, z, false);
        this.b = new y(this, sVar, executor);
        q();
    }

    @Override // com.google.android.libraries.navigation.internal.aac.n
    public final void g(int i, Object obj) {
    }

    @Override // com.google.android.libraries.navigation.internal.aac.n
    public final void i() {
        aa aaVar = this.b;
        if (aaVar != null) {
            aaVar.f();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final void n() {
        aa aaVar = this.b;
        if (aaVar != null) {
            aaVar.h();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.n
    public final void s(m mVar) {
        super.s(mVar);
        if (mVar == m.OUTPUT_FUTURE_DONE) {
            this.b = null;
        }
    }

    public ab(ek ekVar, boolean z, Executor executor, Callable callable) {
        super(ekVar, z, false);
        this.b = new z(this, callable, executor);
        q();
    }
}
