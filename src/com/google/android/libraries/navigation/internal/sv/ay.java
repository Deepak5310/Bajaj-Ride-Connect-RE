package com.google.android.libraries.navigation.internal.sv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ay extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public ay(int i, Class cls, aw awVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, awVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        if (this.f != 0) {
            ((aw) this.c).f((com.google.android.libraries.navigation.internal.sm.a) aVar);
        } else {
            ((aw) this.c).h((com.google.android.libraries.navigation.internal.sr.o) aVar);
        }
    }
}
