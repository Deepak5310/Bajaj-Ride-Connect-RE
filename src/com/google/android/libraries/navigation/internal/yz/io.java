package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class io implements ii {
    public static final io a = new io();

    public static final iq g(Object obj, int i, iq iqVar) {
        return iqVar == null ? new iq(obj, i) : new ip(obj, i, iqVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* bridge */ /* synthetic */ ih a(il ilVar, ih ihVar, ih ihVar2) {
        iq iqVar = (iq) ihVar;
        iq iqVarG = g(iqVar.a, iqVar.b, (iq) ihVar2);
        iqVarG.c = iqVar.c;
        return iqVarG;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* bridge */ /* synthetic */ ih b(il ilVar, Object obj, int i, ih ihVar) {
        return g(obj, i, (iq) ihVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* synthetic */ il c(jk jkVar, int i) {
        return new ir(jkVar, i);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final in d() {
        return in.STRONG;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final in e() {
        return in.STRONG;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* synthetic */ void f(il ilVar, ih ihVar, Object obj) {
        ((iq) ihVar).c = obj;
    }
}
