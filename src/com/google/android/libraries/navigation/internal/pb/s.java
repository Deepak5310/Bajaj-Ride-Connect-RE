package com.google.android.libraries.navigation.internal.pb;

import android.animation.TypeEvaluator;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s implements TypeEvaluator {
    public final t a;
    public final aa b = new aa();
    final ab c;
    public float d;
    public int e;
    public com.google.android.libraries.navigation.internal.pd.d f;
    public com.google.android.libraries.navigation.internal.pd.d g;
    public long h;
    float i;
    float j;

    public s(ab abVar, t tVar) {
        this.c = abVar;
        ar.q(tVar);
        this.a = tVar;
        this.d = tVar.i();
        this.e = tVar.r();
    }

    final float a(float f) {
        float fN = this.e / this.a.n();
        com.google.android.libraries.navigation.internal.pd.d dVar = this.f;
        ar.q(dVar);
        return (float) com.google.android.libraries.navigation.internal.oe.p.c(f, dVar.i.a, this.d, (int) fN);
    }

    @Override // android.animation.TypeEvaluator
    public final /* bridge */ /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
        if (f <= 0.0f) {
            com.google.android.libraries.navigation.internal.pd.d dVar = this.f;
            ar.q(dVar);
            return Float.valueOf(dVar.k);
        }
        if (f >= 1.0f) {
            com.google.android.libraries.navigation.internal.pd.d dVar2 = this.g;
            ar.q(dVar2);
            return Float.valueOf(dVar2.k);
        }
        float fC = this.j + (this.i * this.c.c(f));
        float fN = this.e / this.a.n();
        com.google.android.libraries.navigation.internal.pd.d dVar3 = this.f;
        ar.q(dVar3);
        return Float.valueOf((float) com.google.android.libraries.navigation.internal.oe.p.a(fC, dVar3.i.a, this.d, (int) fN));
    }
}
