package com.google.android.libraries.geo.mapcore.internal.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ch {
    public static com.google.android.libraries.navigation.internal.dm.o a(com.google.android.libraries.navigation.internal.oe.ap apVar, cg cgVar, cd cdVar, String str, String str2) {
        com.google.android.libraries.navigation.internal.dm.n nVar = (com.google.android.libraries.navigation.internal.dm.n) com.google.android.libraries.navigation.internal.dm.o.a.q();
        if (!nVar.b.H()) {
            nVar.v();
        }
        String str3 = apVar.a;
        com.google.android.libraries.navigation.internal.dm.o oVar = (com.google.android.libraries.navigation.internal.dm.o) nVar.b;
        str3.getClass();
        oVar.b |= 1;
        oVar.c = str3;
        com.google.android.libraries.navigation.internal.aeg.c cVar = (com.google.android.libraries.navigation.internal.aeg.c) com.google.android.libraries.navigation.internal.aeg.d.a.q();
        int i = cdVar.b;
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.aeg.d dVar = (com.google.android.libraries.navigation.internal.aeg.d) cVar.b;
        dVar.b |= 2;
        dVar.d = i;
        int i2 = cdVar.c;
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.aeg.d dVar2 = (com.google.android.libraries.navigation.internal.aeg.d) cVar.b;
        dVar2.b |= 4;
        dVar2.e = i2;
        int i3 = cdVar.a;
        if (!cVar.b.H()) {
            cVar.v();
        }
        com.google.android.libraries.navigation.internal.aeg.d dVar3 = (com.google.android.libraries.navigation.internal.aeg.d) cVar.b;
        dVar3.b |= 1;
        dVar3.c = i3;
        com.google.android.libraries.navigation.internal.aeg.d dVar4 = (com.google.android.libraries.navigation.internal.aeg.d) cVar.t();
        if (!nVar.b.H()) {
            nVar.v();
        }
        com.google.android.libraries.navigation.internal.dm.o oVar2 = (com.google.android.libraries.navigation.internal.dm.o) nVar.b;
        dVar4.getClass();
        oVar2.f = dVar4;
        oVar2.b |= 16;
        if (!apVar.d) {
            String str4 = apVar.b;
            if (!nVar.b.H()) {
                nVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.o oVar3 = (com.google.android.libraries.navigation.internal.dm.o) nVar.b;
            str4.getClass();
            oVar3.b |= 512;
            oVar3.j = str4;
        }
        com.google.android.libraries.navigation.internal.pt.d dVar5 = cdVar.d;
        if (dVar5 != null) {
            String strF = dVar5.b.f();
            if (!nVar.b.H()) {
                nVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.o oVar4 = (com.google.android.libraries.navigation.internal.dm.o) nVar.b;
            oVar4.b |= 32;
            oVar4.g = strF;
        }
        b bVar = (b) cgVar;
        String str5 = bVar.m;
        if (str5 != null) {
            if (!nVar.b.H()) {
                nVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.o oVar5 = (com.google.android.libraries.navigation.internal.dm.o) nVar.b;
            oVar5.b |= 8;
            oVar5.e = str5;
        }
        String str6 = bVar.f61n;
        if (str6 != null) {
            if (!nVar.b.H()) {
                nVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.o oVar6 = (com.google.android.libraries.navigation.internal.dm.o) nVar.b;
            oVar6.b |= 1024;
            oVar6.k = str6;
        }
        String str7 = bVar.o;
        if (str7 != null) {
            if (!nVar.b.H()) {
                nVar.v();
            }
            com.google.android.libraries.navigation.internal.dm.o oVar7 = (com.google.android.libraries.navigation.internal.dm.o) nVar.b;
            oVar7.b |= 2048;
            oVar7.l = str7;
        }
        String str8 = bVar.l;
        if (!nVar.b.H()) {
            nVar.v();
        }
        com.google.android.libraries.navigation.internal.dm.o oVar8 = (com.google.android.libraries.navigation.internal.dm.o) nVar.b;
        str2.getClass();
        oVar8.b |= 2;
        oVar8.d = str2;
        if (!nVar.b.H()) {
            nVar.v();
        }
        com.google.android.libraries.navigation.internal.dm.o oVar9 = (com.google.android.libraries.navigation.internal.dm.o) nVar.b;
        str.getClass();
        oVar9.b |= 64;
        oVar9.h = str;
        return (com.google.android.libraries.navigation.internal.dm.o) nVar.t();
    }

    public static boolean b(com.google.android.libraries.navigation.internal.dm.s sVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        return (sVar.b & 32) != 0 && aVar.a() > sVar.h;
    }

    public static boolean c(int i) {
        return (i & 2) != 0;
    }

    public static boolean d(com.google.android.libraries.navigation.internal.dm.s sVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        return (sVar.b & 64) != 0 && aVar.a() > sVar.i;
    }

    public static boolean e(int i, boolean z) {
        if (z) {
            return ((i & 1) == 0 && c(i)) ? false : true;
        }
        return !c(i);
    }
}
