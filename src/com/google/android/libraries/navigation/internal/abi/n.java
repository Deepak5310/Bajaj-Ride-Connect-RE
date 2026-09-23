package com.google.android.libraries.navigation.internal.abi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends p {
    public n(i iVar) {
        super(iVar);
        this.e = 0.05f;
        this.f = (float) Math.tan(0.3490658503988659d);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final void c(j jVar) {
        ((d) this.a).a.d();
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final boolean d(j jVar) {
        return ((d) this.a).a.d();
    }

    @Override // com.google.android.libraries.navigation.internal.abi.c
    protected final boolean h(j jVar) {
        return ((d) this.a).a.d();
    }

    @Override // com.google.android.libraries.navigation.internal.abi.p
    protected final float j(float f) {
        return Math.min(Math.abs(f), (float) Math.abs(((double) Math.abs(f)) - 3.141592653589793d));
    }

    @Override // com.google.android.libraries.navigation.internal.abi.p
    protected final float k(g gVar, int i) {
        return gVar.c(i);
    }

    @Override // com.google.android.libraries.navigation.internal.abi.p
    protected final float l(g gVar, int i) {
        return gVar.a(i);
    }
}
