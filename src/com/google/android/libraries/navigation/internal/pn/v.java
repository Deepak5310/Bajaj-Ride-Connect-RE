package com.google.android.libraries.navigation.internal.pn;

import java.util.Deque;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v extends p {
    public v(int i, j jVar, float f, float f2) {
        super(i, jVar, f, f2);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final void c(n nVar) {
        this.a.n(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final boolean d(n nVar) {
        return this.a.x(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    public final /* bridge */ /* synthetic */ boolean e() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final boolean h(n nVar) {
        return this.a.w(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.p, com.google.android.libraries.navigation.internal.pn.b
    public final /* bridge */ /* synthetic */ int i(long j, Deque deque, List list) {
        return super.i(j, deque, list);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.p
    protected final float j(float f) {
        return (float) Math.abs(((double) Math.abs(f)) - 1.5707963267948966d);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.p
    protected final float k(h hVar, int i) {
        return hVar.b(i);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.p
    protected final float l(h hVar, int i) {
        return hVar.c(i);
    }
}
