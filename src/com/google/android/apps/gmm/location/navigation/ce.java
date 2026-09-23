package com.google.android.apps.gmm.location.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class ce extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public ce(int i, Class cls, cd cdVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, cdVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        if (this.f != 0) {
            throw null;
        }
        cd cdVar = (cd) this.c;
        boolean z = cdVar.f;
        ao aoVar = cdVar.h;
        if (aoVar != null) {
            aoVar.b();
        }
        long jA = cdVar.a.a();
        long j = cdVar.d;
        cdVar.d = jA;
        throw null;
    }
}
