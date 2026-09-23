package com.google.android.libraries.navigation.internal.yz;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class iy implements ii {
    public static final iy a = new iy();

    public static final ja g(jb jbVar, Object obj, int i, ja jaVar) {
        ReferenceQueue referenceQueue = jbVar.g;
        return jaVar == null ? new ja(referenceQueue, obj, i) : new iz(referenceQueue, obj, i, jaVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* bridge */ /* synthetic */ ih a(il ilVar, ih ihVar, ih ihVar2) {
        jb jbVar = (jb) ilVar;
        ja jaVar = (ja) ihVar;
        ja jaVar2 = (ja) ihVar2;
        Object obj = jaVar.get();
        if (obj == null) {
            return null;
        }
        ja jaVarG = g(jbVar, obj, jaVar.a, jaVar2);
        jaVarG.b = jaVar.b;
        return jaVarG;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* bridge */ /* synthetic */ ih b(il ilVar, Object obj, int i, ih ihVar) {
        return g((jb) ilVar, obj, i, (ja) ihVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* synthetic */ il c(jk jkVar, int i) {
        return new jb(jkVar, i);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final in d() {
        return in.WEAK;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final in e() {
        return in.STRONG;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ii
    public final /* synthetic */ void f(il ilVar, ih ihVar, Object obj) {
        ((ja) ihVar).b = obj;
    }
}
