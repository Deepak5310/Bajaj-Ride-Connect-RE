package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ax {
    final /* synthetic */ ay a;
    private final com.google.android.libraries.navigation.internal.oe.o b;

    public ax(ay ayVar, com.google.android.libraries.navigation.internal.oe.o oVar) {
        this.a = ayVar;
        this.b = oVar;
    }

    public final gw a(com.google.android.libraries.navigation.internal.pp.h hVar) {
        ay ayVar = this.a;
        gv auVar = ayVar.f520n ? new au(ayVar) : new av(ayVar);
        int i = this.a.m ? 2 : 1;
        com.google.android.libraries.navigation.internal.oe.o oVar = this.b;
        ay ayVar2 = this.a;
        int i2 = ay.c;
        ay.c = i2 + 1;
        return new gw(hVar, auVar, oVar, i, ayVar2.g, i2, new com.google.android.libraries.navigation.internal.qq.d(ayVar2.o, gw.b(i2)));
    }
}
