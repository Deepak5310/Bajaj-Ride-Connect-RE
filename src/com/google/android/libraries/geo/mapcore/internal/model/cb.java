package com.google.android.libraries.geo.mapcore.internal.model;

import androidx.core.view.ViewCompat;
import com.google.android.libraries.navigation.internal.adg.eo;
import com.google.common.base.Ascii;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public abstract class cb {
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final cb m;

    public static cb i(int i2, int i3, int i4, float f, float f2, float f3, int i5, boolean z) {
        n nVar = new n();
        nVar.a = i2;
        int i6 = nVar.g | 1;
        nVar.b = i3;
        nVar.g = (byte) (((byte) i6) | 2);
        nVar.c(i4);
        nVar.c = f;
        int i7 = nVar.g | 8;
        nVar.d = f2;
        nVar.e = f3;
        nVar.g = (byte) (((byte) (((byte) i7) | Ascii.DLE)) | 32);
        nVar.b(i5);
        nVar.f = z;
        nVar.g = (byte) (nVar.g | (-128));
        return nVar.a();
    }

    public static cb j(eo eoVar) {
        float f;
        int i2 = eoVar.c;
        int i3 = eoVar.d;
        com.google.android.libraries.navigation.internal.adg.ch chVar = eoVar.g;
        if (chVar == null) {
            chVar = com.google.android.libraries.navigation.internal.adg.ch.a;
        }
        int i4 = chVar.c;
        com.google.android.libraries.navigation.internal.adg.ch chVar2 = eoVar.g;
        if (chVar2 == null) {
            chVar2 = com.google.android.libraries.navigation.internal.adg.ch.a;
        }
        float fA = ay.a(chVar2.g);
        com.google.android.libraries.navigation.internal.adg.ch chVar3 = eoVar.g;
        if (chVar3 == null) {
            chVar3 = com.google.android.libraries.navigation.internal.adg.ch.a;
        }
        if ((chVar3.b & 4) != 0) {
            com.google.android.libraries.navigation.internal.adg.ch chVar4 = eoVar.g;
            if (chVar4 == null) {
                chVar4 = com.google.android.libraries.navigation.internal.adg.ch.a;
            }
            f = chVar4.e / 100.0f;
        } else {
            f = 1.0f;
        }
        com.google.android.libraries.navigation.internal.adg.ch chVar5 = eoVar.g;
        if (chVar5 == null) {
            chVar5 = com.google.android.libraries.navigation.internal.adg.ch.a;
        }
        float f2 = chVar5.f;
        com.google.android.libraries.navigation.internal.adg.ch chVar6 = eoVar.g;
        if (chVar6 == null) {
            chVar6 = com.google.android.libraries.navigation.internal.adg.ch.a;
        }
        return i(i2, i3, i4, fA, f, f2 / 1000.0f, chVar6.d, eoVar.l);
    }

    public static boolean k(int i2) {
        return ay.f(i, i2);
    }

    public static boolean l(int i2) {
        return ay.f(j, i2);
    }

    public static boolean m(int i2) {
        return ay.f(k, i2);
    }

    public static boolean n(int i2) {
        return ay.f(l, i2);
    }

    public abstract float a();

    public abstract float b();

    public abstract float c();

    public abstract int d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract boolean h();

    public final String toString() {
        return "TextStyle{color=" + Integer.toHexString(e()) + ", outlineColor=" + Integer.toHexString(f()) + ", size=" + g() + ", outlineWidth=" + b() + ", leadingRatio=" + a() + ", trackingRatio=" + c() + ", attributes=" + d() + ", off=" + h() + '}';
    }

    static {
        int i2 = com.google.android.libraries.navigation.internal.adg.cg.a;
        if (i2 == 0) {
            throw null;
        }
        i = i2;
        int i3 = com.google.android.libraries.navigation.internal.adg.cg.b;
        if (i3 == 0) {
            throw null;
        }
        j = i3;
        int i4 = com.google.android.libraries.navigation.internal.adg.cg.e;
        if (i4 == 0) {
            throw null;
        }
        k = i4;
        int i5 = com.google.android.libraries.navigation.internal.adg.cg.d;
        if (i5 == 0) {
            throw null;
        }
        l = i5;
        m = i(ViewCompat.MEASURED_STATE_MASK, Integer.MAX_VALUE, 12, 2.8f, 1.0f, 0.0f, 0, false);
    }
}
