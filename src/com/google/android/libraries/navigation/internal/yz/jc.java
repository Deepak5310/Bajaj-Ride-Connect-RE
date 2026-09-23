package com.google.android.libraries.navigation.internal.yz;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class jc implements ii {
    public static final jc a = new jc();

    public static final je g(jf jfVar, Object obj, int i, je jeVar) {
        ReferenceQueue referenceQueue = jfVar.g;
        return jeVar == null ? new je(referenceQueue, obj, i) : new jd(referenceQueue, obj, i, jeVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* bridge */ /* synthetic */ ih a(il ilVar, ih ihVar, ih ihVar2) {
        jf jfVar = (jf) ilVar;
        je jeVar = (je) ihVar;
        je jeVar2 = (je) ihVar2;
        Object obj = jeVar.get();
        if (obj == null || il.n(jeVar)) {
            return null;
        }
        je jeVarG = g(jfVar, obj, jeVar.a, jeVar2);
        jeVarG.b = jeVar.b.b(jfVar.h, jeVarG);
        return jeVarG;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* bridge */ /* synthetic */ ih b(il ilVar, Object obj, int i, ih ihVar) {
        return g((jf) ilVar, obj, i, (je) ihVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* synthetic */ il c(jk jkVar, int i) {
        return new jf(jkVar, i);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final in d() {
        return in.WEAK;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final in e() {
        return in.WEAK;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* bridge */ /* synthetic */ void f(il ilVar, ih ihVar, Object obj) {
        je jeVar = (je) ihVar;
        jh jhVar = jeVar.b;
        jeVar.b = new ji(((jf) ilVar).h, obj, jeVar);
        jhVar.clear();
    }
}
