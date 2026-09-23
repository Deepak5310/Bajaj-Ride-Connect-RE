package com.google.android.libraries.navigation.internal.oa;

import com.google.android.libraries.navigation.internal.ob.u;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class l {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.oa.l");

    public final int a(u uVar, int i) {
        int iOrdinal = uVar.ordinal();
        if (iOrdinal == 0) {
            if (i != 0) {
                return i != 1 ? com.google.android.libraries.navigation.internal.f.d.o : com.google.android.libraries.navigation.internal.qr.c.X;
            }
            return com.google.android.libraries.navigation.internal.qr.c.V;
        }
        if (iOrdinal == 1) {
            return com.google.android.libraries.navigation.internal.qr.c.Z;
        }
        if (iOrdinal == 2) {
            return com.google.android.libraries.navigation.internal.qr.c.Y;
        }
        if (iOrdinal == 3) {
            return com.google.android.libraries.navigation.internal.qr.c.W;
        }
        if (iOrdinal == 5) {
            return com.google.android.libraries.navigation.internal.f.d.o;
        }
        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(812)).s("Got an unexpected PinType: %s", uVar);
        return com.google.android.libraries.navigation.internal.f.d.o;
    }

    public int b(int i, boolean z) {
        if (i == 0) {
            return com.google.android.libraries.navigation.internal.qr.c.aa;
        }
        if (!z) {
            return com.google.android.libraries.navigation.internal.qr.c.ab;
        }
        switch (i) {
            case 1:
                return com.google.android.libraries.navigation.internal.qr.c.v;
            case 2:
                return com.google.android.libraries.navigation.internal.qr.c.w;
            case 3:
                return com.google.android.libraries.navigation.internal.qr.c.x;
            case 4:
                return com.google.android.libraries.navigation.internal.qr.c.y;
            case 5:
                return com.google.android.libraries.navigation.internal.qr.c.z;
            case 6:
                return com.google.android.libraries.navigation.internal.qr.c.A;
            case 7:
                return com.google.android.libraries.navigation.internal.qr.c.B;
            case 8:
                return com.google.android.libraries.navigation.internal.qr.c.C;
            case 9:
                return com.google.android.libraries.navigation.internal.qr.c.D;
            case 10:
                return com.google.android.libraries.navigation.internal.qr.c.E;
            case 11:
                return com.google.android.libraries.navigation.internal.qr.c.F;
            case 12:
                return com.google.android.libraries.navigation.internal.qr.c.G;
            case 13:
                return com.google.android.libraries.navigation.internal.qr.c.H;
            case 14:
                return com.google.android.libraries.navigation.internal.qr.c.I;
            case 15:
                return com.google.android.libraries.navigation.internal.qr.c.J;
            case 16:
                return com.google.android.libraries.navigation.internal.qr.c.K;
            case 17:
                return com.google.android.libraries.navigation.internal.qr.c.L;
            case 18:
                return com.google.android.libraries.navigation.internal.qr.c.M;
            case 19:
                return com.google.android.libraries.navigation.internal.qr.c.N;
            case 20:
                return com.google.android.libraries.navigation.internal.qr.c.O;
            case 21:
                return com.google.android.libraries.navigation.internal.qr.c.P;
            case 22:
                return com.google.android.libraries.navigation.internal.qr.c.Q;
            case 23:
                return com.google.android.libraries.navigation.internal.qr.c.R;
            case 24:
                return com.google.android.libraries.navigation.internal.qr.c.S;
            case 25:
                return com.google.android.libraries.navigation.internal.qr.c.T;
            case 26:
                return com.google.android.libraries.navigation.internal.qr.c.U;
            default:
                return com.google.android.libraries.navigation.internal.qr.c.u;
        }
    }
}
