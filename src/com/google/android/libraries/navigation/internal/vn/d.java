package com.google.android.libraries.navigation.internal.vn;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.bp.ac;
import com.google.android.libraries.navigation.internal.bp.bw;
import com.google.android.libraries.navigation.internal.dw.g;
import com.google.android.libraries.navigation.internal.tu.t;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private static final fd g;
    public final t a;
    public final ac b;
    public final c c;
    public final bw d;
    public final int e;
    public a f;

    static {
        ez ezVar = new ez();
        ezVar.f(b.DEFAULT_NONE, -1);
        ezVar.f(b.PAH_DEE, Integer.valueOf(g.d));
        ezVar.f(b.PAH_DUM, Integer.valueOf(g.e));
        ezVar.f(b.DRING_DRING, Integer.valueOf(g.j));
        ezVar.f(b.TAH_LAH_LAH, Integer.valueOf(g.k));
        ezVar.f(b.DING_DEE, Integer.valueOf(g.h));
        g = ezVar.d();
    }

    public d(c cVar, bw bwVar, String str, ac acVar, x xVar, int i) {
        this.c = cVar;
        this.d = bwVar;
        this.e = i;
        this.a = new com.google.android.libraries.navigation.internal.tu.g(str, xVar);
        this.b = acVar;
    }

    public static int a(b bVar) {
        Integer num = (Integer) g.get(bVar);
        return num != null ? num.intValue() : g.i;
    }

    public static d b(bw bwVar, String str, ac acVar, x xVar) {
        c cVar = c.UNKNOWN;
        int iOrdinal = bwVar.a.ordinal();
        if (iOrdinal == 0) {
            cVar = c.PREPARE;
        } else if (iOrdinal == 1) {
            cVar = c.ACT;
        } else if (iOrdinal == 2) {
            cVar = c.SUCCESS;
        } else if (iOrdinal == 3) {
            cVar = c.OTHER_WITH_LOCALIZED_NAME;
        }
        return new d(cVar, bwVar, str, acVar, xVar, -1);
    }

    public final String c() {
        return ((com.google.android.libraries.navigation.internal.tu.g) this.a).a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return ((d) obj).a.equals(this.a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.h();
        akVarB.g("type", this.c);
        akVarB.g(ReactNativeBlobUtilConst.DATA_ENCODE_URI, null);
        akVarB.g("structuredSpokenText", this.a);
        akVarB.g("cannedMessage", this.b);
        return akVarB.toString();
    }
}
