package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aq {
    private final aw a;

    public aq(aw awVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(awVar);
        this.a = awVar;
    }

    public final ap a(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return new ap(this.a.e(anVar), anVar);
    }

    public final ap b(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return c(anVar, "");
    }

    public final ap c(com.google.android.libraries.navigation.internal.adi.an anVar, String str) {
        String str2;
        String strE = this.a.e(anVar);
        if (str.isEmpty()) {
            str2 = strE;
        } else {
            str2 = strE + "." + str;
        }
        return new ap(str2, strE, anVar);
    }
}
