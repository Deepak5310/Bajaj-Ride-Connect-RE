package com.google.android.libraries.navigation.internal.og;

import android.animation.TypeEvaluator;
import com.google.android.libraries.navigation.internal.pb.aa;
import com.google.android.libraries.navigation.internal.pb.ab;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements TypeEvaluator {
    public final com.google.android.libraries.navigation.internal.oq.d a;
    public final com.google.android.libraries.navigation.internal.oq.h b;
    public final aa c = new aa();
    final ab d;
    public float e;
    public int f;
    public com.google.android.libraries.navigation.internal.oq.f g;
    public com.google.android.libraries.navigation.internal.oq.f h;
    public long i;
    float j;
    float k;

    public j(ab abVar, com.google.android.libraries.navigation.internal.oq.d dVar) {
        this.d = abVar;
        this.a = dVar;
        this.b = dVar.b();
        com.google.android.libraries.navigation.internal.rf.g gVarC = dVar.c();
        this.e = gVarC.a();
        this.f = gVarC.c();
    }

    final float a(float f) {
        float fB = this.f / this.a.c().b();
        com.google.android.libraries.navigation.internal.oq.f fVar = this.g;
        ar.q(fVar);
        return (float) com.google.android.libraries.navigation.internal.oe.p.c(f, ((com.google.android.libraries.navigation.internal.oq.b) fVar).a.a, this.e, (int) fB);
    }

    @Override // android.animation.TypeEvaluator
    public final /* bridge */ /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
        if (f <= 0.0f) {
            com.google.android.libraries.navigation.internal.oq.f fVar = this.g;
            ar.q(fVar);
            return Float.valueOf(((com.google.android.libraries.navigation.internal.oq.b) fVar).e);
        }
        if (f >= 1.0f) {
            com.google.android.libraries.navigation.internal.oq.f fVar2 = this.h;
            ar.q(fVar2);
            return Float.valueOf(((com.google.android.libraries.navigation.internal.oq.b) fVar2).e);
        }
        float fC = this.k + (this.j * this.d.c(f));
        float fB = this.f / this.a.c().b();
        com.google.android.libraries.navigation.internal.oq.f fVar3 = this.g;
        ar.q(fVar3);
        return Float.valueOf((float) com.google.android.libraries.navigation.internal.oe.p.a(fC, ((com.google.android.libraries.navigation.internal.oq.b) fVar3).a.a, this.e, (int) fB));
    }
}
