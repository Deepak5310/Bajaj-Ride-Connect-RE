package com.google.android.libraries.navigation.internal.adg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public static final e a = new e();
    private final c b;

    public f(c cVar) {
        this.b = cVar;
    }

    public final /* synthetic */ d a() {
        com.google.android.libraries.navigation.internal.ael.bi biVarT = this.b.t();
        Intrinsics.checkNotNullExpressionValue(biVarT, "build(...)");
        return (d) biVarT;
    }

    public final void b(b value) {
        Intrinsics.checkNotNullParameter(value, "value");
        c cVar = this.b;
        if (!cVar.b.H()) {
            cVar.v();
        }
        d dVar = (d) cVar.b;
        d dVar2 = d.a;
        dVar.d = value.j;
        dVar.b |= 2;
    }

    public final void c(h value) {
        Intrinsics.checkNotNullParameter(value, "value");
        c cVar = this.b;
        if (!cVar.b.H()) {
            cVar.v();
        }
        d dVar = (d) cVar.b;
        d dVar2 = d.a;
        value.getClass();
        dVar.c = value;
        dVar.b |= 1;
    }
}
