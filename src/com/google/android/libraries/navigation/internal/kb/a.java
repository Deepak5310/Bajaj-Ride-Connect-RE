package com.google.android.libraries.navigation.internal.kb;

import com.google.android.libraries.navigation.internal.ael.ac;
import com.google.android.libraries.navigation.internal.ael.ah;
import com.google.android.libraries.navigation.internal.ael.ai;
import com.google.android.libraries.navigation.internal.ael.y;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.zb.h;
import com.google.android.libraries.navigation.internal.zb.j;
import com.google.android.libraries.navigation.internal.zn.g;
import com.google.android.libraries.navigation.internal.zt.d;
import com.google.android.libraries.navigation.internal.zt.e;
import com.google.android.libraries.navigation.internal.zt.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private static final j a = j.e("com.google.android.libraries.navigation.internal.kb.a");

    public static d a(String str) {
        String[] strArrSplit;
        int length;
        if (aq.c(str) || (length = (strArrSplit = str.split(":")).length) > 2) {
            return null;
        }
        com.google.android.libraries.navigation.internal.zt.c cVar = (com.google.android.libraries.navigation.internal.zt.c) d.a.q();
        String str2 = strArrSplit[0];
        if (!aq.c(str2)) {
            f fVarB = b(str2);
            if (fVarB == null) {
                return null;
            }
            if (!cVar.b.H()) {
                cVar.v();
            }
            d dVar = (d) cVar.b;
            dVar.c = fVarB;
            dVar.b |= 1;
        }
        if (length == 2) {
            String str3 = strArrSplit[1];
            if (!str3.isEmpty()) {
                try {
                    long j = Integer.parseInt(str3);
                    if (!cVar.b.H()) {
                        cVar.v();
                    }
                    d dVar2 = (d) cVar.b;
                    dVar2.b |= 2;
                    dVar2.d = j;
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
        }
        return (d) cVar.t();
    }

    public static f b(String str) {
        if (aq.c(str)) {
            return null;
        }
        e eVar = (e) f.a.q();
        try {
            ac acVarK = ac.K(g.e.j(str));
            long jI = ((long) ((y) acVarK).i()) & 4294967295L;
            long j = ((y) acVarK).j();
            int iJ = ((y) acVarK).j();
            int i = iJ >> 24;
            int i2 = iJ & 16777215;
            int i3 = (i + 10) & 255;
            int iJ2 = ((y) acVarK).j();
            if (!eVar.b.H()) {
                eVar.v();
            }
            f fVar = (f) eVar.b;
            fVar.b |= 1;
            fVar.c = (jI * 1000000) + j;
            if (!eVar.b.H()) {
                eVar.v();
            }
            f fVar2 = (f) eVar.b;
            fVar2.b |= 2;
            fVar2.d = (i3 << 24) | i2;
            if (!eVar.b.H()) {
                eVar.v();
            }
            f fVar3 = (f) eVar.b;
            fVar3.b |= 4;
            fVar3.e = iJ2;
            return (f) eVar.t();
        } catch (IOException | IllegalArgumentException unused) {
            return null;
        }
    }

    public static String c(String str, int i) {
        return str + ":" + String.valueOf(i);
    }

    public static String d(f fVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = ai.e;
        ah ahVar = new ah(byteArrayOutputStream, 4096);
        try {
            long j = fVar.c;
            ahVar.j((int) (j / 1000000));
            ahVar.n((int) (j % 1000000));
            ahVar.w(fVar.d - 167772160);
            ahVar.w(fVar.e);
            ahVar.aw();
        } catch (IOException e) {
            ((h) ((h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 758)).p("EventIdMessage couldn't be encoded");
        }
        return g.e.f().i(byteArrayOutputStream.toByteArray());
    }
}
