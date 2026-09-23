package com.google.android.libraries.navigation.internal.oq;

import com.google.android.libraries.navigation.internal.oe.r;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class e {
    public abstract float a();

    public abstract float b();

    public abstract float c();

    public abstract r d();

    public abstract e e(r rVar);

    public abstract f f();

    public abstract j g();

    public abstract void h(float f);

    public abstract void i(j jVar);

    public abstract void j(float f);

    public abstract void k(float f);

    public final f l() {
        float fA = a() % 360.0f;
        if (fA < 0.0f) {
            fA += 360.0f;
        }
        h(fA);
        j(Math.max(0.0f, Math.min(90.0f, b())));
        k(Math.max(2.0f, Math.min(c(), 21.0f)));
        return f();
    }

    public final void m(f fVar) {
        e eVarE = e(fVar.d());
        eVarE.h(fVar.a());
        eVarE.j(fVar.b());
        eVarE.i(fVar.f());
        eVarE.k(fVar.c());
    }
}
