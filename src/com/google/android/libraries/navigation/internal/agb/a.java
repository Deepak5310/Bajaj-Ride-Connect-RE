package com.google.android.libraries.navigation.internal.agb;

import com.google.android.libraries.navigation.internal.afx.ao;
import com.google.android.libraries.navigation.internal.afx.ar;
import com.google.android.libraries.navigation.internal.afx.aw;
import com.google.android.libraries.navigation.internal.afx.ax;
import com.google.android.libraries.navigation.internal.afx.cq;
import com.google.android.libraries.navigation.internal.afx.r;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends ar {
    @Override // com.google.android.libraries.navigation.internal.afx.ar
    public final aw b(ao aoVar) {
        return g().b(aoVar);
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ar
    public final cq c() {
        return g().c();
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ar
    public final ScheduledExecutorService d() {
        return g().d();
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ar
    public final void e() {
        g().e();
    }

    @Override // com.google.android.libraries.navigation.internal.afx.ar
    public void f(r rVar, ax axVar) {
        throw null;
    }

    protected abstract ar g();

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.g("delegate", g());
        return akVarB.toString();
    }
}
