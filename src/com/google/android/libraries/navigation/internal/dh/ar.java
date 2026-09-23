package com.google.android.libraries.navigation.internal.dh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ar extends com.google.android.libraries.navigation.internal.kp.c implements com.google.android.libraries.navigation.internal.ic.a {
    private final String a;

    public ar(String str) {
        this.a = str;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.c
    public final com.google.android.libraries.navigation.internal.kp.f c() {
        com.google.android.libraries.navigation.internal.kp.f fVar = new com.google.android.libraries.navigation.internal.kp.f("restart");
        fVar.m("type", this.a);
        return fVar;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("type", this.a);
        return akVarB.toString();
    }
}
