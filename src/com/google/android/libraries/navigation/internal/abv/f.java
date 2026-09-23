package com.google.android.libraries.navigation.internal.abv;

import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.di;
import com.google.android.libraries.navigation.internal.afm.bd;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public static final long a = TimeUnit.HOURS.toMillis(2);
    public static final FileFilter b = new c();
    public static final FileFilter c = new d();
    public static final FileFilter d = new e();
    private static final String e = "f";
    private final com.google.android.libraries.navigation.internal.abw.f f;
    private final com.google.android.libraries.navigation.internal.abw.f g;
    private final com.google.android.libraries.navigation.internal.abw.f h;

    public f(com.google.android.libraries.navigation.internal.abw.f fVar, com.google.android.libraries.navigation.internal.abw.f fVar2, com.google.android.libraries.navigation.internal.abw.f fVar3) {
        synchronized (this) {
            this.f = fVar;
            this.g = fVar2;
            this.h = fVar3;
        }
    }

    private static String e(String str) {
        s.k(str, "panoId");
        return String.format("%s_%s", "config", str);
    }

    private static String f(com.google.android.libraries.navigation.internal.abt.d dVar) {
        s.k(dVar, "StreetViewPanoramaTileKey");
        return String.format("%s_%s_%s_%s_%s", "tile", dVar.a, Integer.valueOf(dVar.d), Integer.valueOf(dVar.b), Integer.valueOf(dVar.c));
    }

    public final synchronized bd a(String str) {
        bd bdVar = null;
        if (this.f == null) {
            return null;
        }
        String strE = e(str);
        byte[] bArrE = this.f.e(strE);
        if (bArrE != null) {
            try {
                bd bdVar2 = bd.a;
                int length = bArrE.length;
                ar arVar = ar.a;
                di diVar = di.a;
                bi biVarV = bi.v(bdVar2, bArrE, 0, length, ar.a);
                bi.I(biVarV);
                bdVar = (bd) biVarV;
            } catch (cc unused) {
                p.f(e, 6);
                this.f.d(strE);
                return null;
            }
        }
        return bdVar;
    }

    public final synchronized void b(com.google.android.libraries.navigation.internal.abt.d dVar, byte[] bArr) {
        s.k(dVar, "key");
        s.k(bArr, "tileBytes");
        com.google.android.libraries.navigation.internal.abw.f fVar = dVar.a() ? this.g : this.h;
        if (fVar == null) {
            return;
        }
        fVar.c(f(dVar), bArr);
    }

    public final synchronized void c(String str, bd bdVar) {
        s.k(str, "panoId");
        com.google.android.libraries.navigation.internal.abw.f fVar = this.f;
        if (fVar == null) {
            return;
        }
        fVar.c(e(str), bdVar.m());
    }

    public final synchronized byte[] d(com.google.android.libraries.navigation.internal.abt.d dVar) {
        s.k(dVar, "key");
        com.google.android.libraries.navigation.internal.abw.f fVar = dVar.a() ? this.g : this.h;
        if (fVar == null) {
            return null;
        }
        return fVar.e(f(dVar));
    }
}
