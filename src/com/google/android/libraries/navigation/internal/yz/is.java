package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class is implements ii {
    public static final is a = new is();

    public static final iu g(Object obj, int i, iu iuVar) {
        return iuVar == null ? new iu(obj, i) : new it(obj, i, iuVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* bridge */ /* synthetic */ ih a(il ilVar, ih ihVar, ih ihVar2) {
        iv ivVar = (iv) ilVar;
        iu iuVar = (iu) ihVar;
        iu iuVar2 = (iu) ihVar2;
        if (il.n(iuVar)) {
            return null;
        }
        iu iuVarG = g(iuVar.a, iuVar.b, iuVar2);
        iuVarG.c = iuVar.c.b(ivVar.g, iuVarG);
        return iuVarG;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* bridge */ /* synthetic */ ih b(il ilVar, Object obj, int i, ih ihVar) {
        return g(obj, i, (iu) ihVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* synthetic */ il c(jk jkVar, int i) {
        return new iv(jkVar, i);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final in d() {
        return in.STRONG;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final in e() {
        return in.WEAK;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* bridge */ /* synthetic */ void f(il ilVar, ih ihVar, Object obj) {
        iu iuVar = (iu) ihVar;
        jh jhVar = iuVar.c;
        iuVar.c = new ji(((iv) ilVar).g, obj, iuVar);
        jhVar.clear();
    }
}
