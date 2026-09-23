package com.google.android.libraries.navigation.internal.dh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ay extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.ic.a {
    final String a;

    public ay(String str) {
        this.a = str;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        com.google.android.libraries.navigation.internal.kp.f fVar = new com.google.android.libraries.navigation.internal.kp.f("tiles");
        fVar.m("state", this.a);
        return fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c, com.google.android.libraries.navigation.internal.kp.a
    public final String d() {
        return "tiles";
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c, com.google.android.libraries.navigation.internal.kp.a
    public final boolean e() {
        return true;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("state", this.a);
        return akVarB.toString();
    }
}
