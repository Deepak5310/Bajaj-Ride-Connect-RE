package com.google.android.libraries.navigation.internal.pn;

import java.util.Deque;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t extends p {
    public t(j jVar, float f, float f2) {
        super(2, jVar, f, f2);
        this.g = 0.05f;
        this.h = (float) Math.tan(Math.toRadians(20.0d));
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final void c(n nVar) {
        this.a.m(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final boolean d(n nVar) {
        return this.a.v(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    public final /* bridge */ /* synthetic */ boolean e() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pn.b
    protected final boolean h(n nVar) {
        return this.a.u(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.p, com.google.android.libraries.navigation.internal.pn.b
    public final /* bridge */ /* synthetic */ int i(long j, Deque deque, List list) {
        return super.i(j, deque, list);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.p
    protected final float j(float f) {
        return Math.min(Math.abs(f), (float) Math.abs(((double) Math.abs(f)) - 3.141592653589793d));
    }

    @Override // com.google.android.libraries.navigation.internal.pn.p
    protected final float k(h hVar, int i) {
        return hVar.c(i);
    }

    @Override // com.google.android.libraries.navigation.internal.pn.p
    protected final float l(h hVar, int i) {
        return hVar.b(i);
    }
}
