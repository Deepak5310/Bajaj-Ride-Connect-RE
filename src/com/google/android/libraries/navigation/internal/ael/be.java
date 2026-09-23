package com.google.android.libraries.navigation.internal.ael;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class be extends bi implements bf {
    public av w = av.a;

    final av g() {
        av avVar = this.w;
        if (avVar.c) {
            this.w = avVar.clone();
        }
        return this.w;
    }

    public final void h(bh bhVar) {
        if (bhVar.a != ((bi) aH(6, null))) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bf
    public final Object y(ap apVar) {
        bh bhVarS = bi.s(apVar);
        h(bhVarS);
        Object objK = this.w.k(bhVarS.d);
        return objK == null ? bhVarS.b : bhVarS.c(objK);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bf
    public final boolean z(ap apVar) {
        throw null;
    }
}
