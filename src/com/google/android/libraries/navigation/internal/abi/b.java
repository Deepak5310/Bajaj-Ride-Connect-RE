package com.google.android.libraries.navigation.internal.abi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends l {
    public final j a;

    public b(int i, j jVar) {
        super(i);
        this.a = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.l
    public final float a() {
        j jVar = this.a;
        float f = jVar.k;
        if (f != -1.0f) {
            return f;
        }
        float f2 = jVar.i;
        float f3 = jVar.j;
        float fSqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
        jVar.k = fSqrt;
        return fSqrt;
    }

    @Override // com.google.android.libraries.navigation.internal.abi.l
    public final float b() {
        j jVar = this.a;
        float f = jVar.l;
        if (f != -1.0f) {
            return f;
        }
        float f2 = jVar.g;
        float f3 = jVar.h;
        float fSqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
        jVar.l = fSqrt;
        return fSqrt;
    }
}
