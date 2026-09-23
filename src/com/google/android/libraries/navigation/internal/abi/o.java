package com.google.android.libraries.navigation.internal.abi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends p {
    public o(i iVar) {
        super(iVar);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final void c(j jVar) {
        d dVar = (d) this.a;
        dVar.b = false;
        dVar.a.e();
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final boolean d(j jVar) {
        d dVar = (d) this.a;
        boolean zE = dVar.a.e();
        if (zE) {
            dVar.b = true;
        }
        return zE;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final boolean h(j jVar) {
        return ((d) this.a).a.e();
    }

    @Override // com.google.android.libraries.navigation.internal.abi.p
    protected final float j(float f) {
        return (float) Math.abs(((double) Math.abs(f)) - 1.5707963267948966d);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.p
    protected final float k(g gVar, int i) {
        return gVar.a(i);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.p
    protected final float l(g gVar, int i) {
        return gVar.c(i);
    }
}
