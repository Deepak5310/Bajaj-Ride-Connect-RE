package com.google.android.libraries.navigation.internal.km;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac extends z {
    ab a;
    private final com.google.android.libraries.navigation.internal.ky.ab d;

    public ac(String str, w wVar) {
        this(str, wVar, 12, 2300, b.a);
    }

    @Override // com.google.android.libraries.navigation.internal.km.z
    public final /* bridge */ /* synthetic */ Object a(com.google.android.libraries.navigation.internal.kk.o oVar) {
        return b();
    }

    public final synchronized ab b() {
        if (this.a == null) {
            this.a = new ab(new com.google.android.libraries.navigation.internal.kk.n());
        }
        return this.a;
    }

    @Deprecated
    public ac(String str, w wVar, int i, int i2) {
        this(str, wVar, i, i2, b.a);
    }

    @Deprecated
    public ac(String str, w wVar, int i, int i2, com.google.android.libraries.navigation.internal.ky.ab abVar) {
        super(str, wVar);
        this.a = null;
        this.d = abVar;
    }
}
