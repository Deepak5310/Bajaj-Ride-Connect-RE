package com.google.android.libraries.navigation.internal.zb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ah {
    public static final ah c = new ad();
    public static final ah d = new ad();

    protected ah() {
    }

    static ah c(ah ahVar, ah ahVar2) {
        ah ahVar3;
        ah ahVar4;
        if (ahVar == null) {
            return ahVar2;
        }
        if (ahVar2 == null || ahVar == (ahVar3 = c) || ahVar2 == (ahVar4 = d)) {
            return ahVar;
        }
        return (ahVar2 == ahVar3 || ahVar == ahVar4) ? ahVar2 : new ae(ahVar, ahVar2);
    }

    protected abstract void a();
}
