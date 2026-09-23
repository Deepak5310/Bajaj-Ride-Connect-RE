package com.google.android.libraries.navigation.internal.gm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends com.google.android.libraries.navigation.internal.ia.k {
    public m(Class cls, j jVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, jVar, apVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        final j jVar = (j) this.c;
        jVar.b.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.gm.h
            @Override // java.lang.Runnable
            public final void run() {
                jVar.e();
            }
        });
    }
}
