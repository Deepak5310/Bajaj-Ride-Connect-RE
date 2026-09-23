package com.google.android.libraries.navigation.internal.px;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class t extends ea {
    private ek a;
    private dv b;
    private dz c;
    private com.google.android.libraries.navigation.internal.yx.an d;

    public t() {
        this.d = com.google.android.libraries.navigation.internal.yx.a.a;
    }

    public t(eb ebVar) {
        this.d = com.google.android.libraries.navigation.internal.yx.a.a;
        u uVar = (u) ebVar;
        this.a = uVar.a;
        this.b = uVar.b;
        this.c = uVar.c;
        this.d = uVar.d;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ea
    public final eb a() {
        dv dvVar;
        dz dzVar;
        ek ekVar = this.a;
        if (ekVar == null || (dvVar = this.b) == null || (dzVar = this.c) == null) {
            throw new IllegalStateException();
        }
        return new u(ekVar, dvVar, dzVar, this.d);
    }

    @Override // com.google.android.libraries.navigation.internal.px.ea
    public final void b(com.google.android.libraries.navigation.internal.yx.an anVar) {
        Objects.requireNonNull(anVar);
        this.d = anVar;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ea
    public final void c(ek ekVar) {
        Objects.requireNonNull(ekVar);
        this.a = ekVar;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ea
    public final void d(dz dzVar) {
        Objects.requireNonNull(dzVar);
        this.c = dzVar;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ea
    public final void e(dv dvVar) {
        Objects.requireNonNull(dvVar);
        this.b = dvVar;
    }
}
