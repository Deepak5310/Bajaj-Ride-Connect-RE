package com.google.android.libraries.navigation.internal.km;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u extends z {
    t a;
    private final com.google.android.libraries.navigation.internal.ky.ab d;

    @Deprecated
    public u(String str, w wVar) {
        this(str, wVar, 4, 2025, b.a);
    }

    @Override // com.google.android.libraries.navigation.internal.km.z
    public final /* bridge */ /* synthetic */ Object a(com.google.android.libraries.navigation.internal.kk.o oVar) {
        return b();
    }

    public final synchronized t b() {
        if (this.a == null) {
            this.a = new t(new com.google.android.libraries.navigation.internal.kk.l(), ae.a);
        }
        return this.a;
    }

    @Deprecated
    public u(String str, w wVar, int i, int i2, com.google.android.libraries.navigation.internal.ky.ab abVar) {
        super(str, wVar);
        this.a = null;
        this.d = abVar;
    }
}
