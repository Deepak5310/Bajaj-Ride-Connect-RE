package com.google.android.libraries.navigation.internal.jy;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.cc;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.afl.hv;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.zp.bi;
import com.google.android.libraries.navigation.internal.zp.bj;
import com.google.android.libraries.navigation.internal.zp.bk;
import com.google.android.libraries.navigation.internal.zp.bv;
import com.google.android.libraries.navigation.internal.zp.ca;
import com.google.android.libraries.navigation.internal.zt.ag;
import com.google.android.libraries.navigation.internal.zt.ap;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class aa implements Serializable {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.jy.aa");
    public static final aa b = new aa();
    public static final aa c = new aa();
    public final String d;
    public final boolean e;

    @Deprecated
    public final String f;
    public final hv g;
    public final com.google.android.libraries.navigation.internal.zy.n h;
    public final boolean i;
    public final z j;
    public final com.google.android.libraries.navigation.internal.afd.a k;
    private final com.google.android.libraries.navigation.internal.hc.a l;
    private final String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.hc.a f459n;
    private final com.google.android.libraries.navigation.internal.hc.a o;
    private final k p;
    private final String q;

    private aa() {
        this(null, null, false, null, null, bk.a, null, null, false, z.g().a(), null);
    }

    private aa(ap apVar, String str, boolean z, String str2, com.google.android.libraries.navigation.internal.afd.a aVar, bk bkVar, hv hvVar, com.google.android.libraries.navigation.internal.zy.n nVar, boolean z2, z zVar, com.google.android.libraries.navigation.internal.aeb.b bVar) {
        this.l = com.google.android.libraries.navigation.internal.hc.a.a(apVar);
        this.d = str;
        this.e = z;
        this.f = str2;
        this.m = null;
        this.k = aVar;
        this.f459n = new com.google.android.libraries.navigation.internal.hc.a(bkVar);
        this.g = hvVar;
        this.h = null;
        this.i = false;
        this.p = null;
        this.j = zVar;
        this.q = null;
        this.o = com.google.android.libraries.navigation.internal.hc.a.a(bVar);
    }

    public /* synthetic */ aa(ap apVar, String str, boolean z, String str2, com.google.android.libraries.navigation.internal.afd.a aVar, bk bkVar, hv hvVar, com.google.android.libraries.navigation.internal.zy.n nVar, boolean z2, z zVar, com.google.android.libraries.navigation.internal.aeb.b bVar, byte[] bArr) {
        this(apVar, str, z, str2, aVar, bkVar, hvVar, null, false, zVar, bVar);
    }

    public static x b(aa aaVar) {
        if (aaVar == null) {
            return new x();
        }
        x xVar = new x();
        xVar.a = aaVar.i();
        xVar.e(aaVar.d, aaVar.e);
        xVar.b = aaVar.f;
        bk bkVarE = aaVar.e();
        if (bkVarE != null) {
            bb bbVar = (bb) bkVarE.aH(5, null);
            bbVar.x(bkVarE);
            xVar.c = (bj) bbVar;
        }
        xVar.d = aaVar.g;
        xVar.k(aaVar.g());
        xVar.g.b(aaVar.a());
        xVar.g(aaVar.c());
        xVar.i(aaVar.h());
        ((e) xVar.g).c = com.google.android.libraries.navigation.internal.hc.a.a(aaVar.f());
        xVar.j(aaVar.d());
        xVar.e = null;
        xVar.h = (com.google.android.libraries.navigation.internal.aeb.b) com.google.android.libraries.navigation.internal.hc.a.e(aaVar.o, (dg) com.google.android.libraries.navigation.internal.aeb.b.a.aH(7, null), com.google.android.libraries.navigation.internal.aeb.b.a);
        xVar.f = false;
        com.google.android.libraries.navigation.internal.afd.a aVar = aaVar.k;
        if (aVar != null) {
            xVar.i = aVar;
        }
        return xVar;
    }

    public static aa k(com.google.android.libraries.navigation.internal.afd.a aVar) {
        x xVar = new x();
        xVar.i = aVar;
        return xVar.b();
    }

    public final int a() {
        return ((f) this.j).b;
    }

    public final com.google.android.libraries.navigation.internal.zp.r c() {
        dg dgVar = (dg) com.google.android.libraries.navigation.internal.zp.r.a.aH(7, null);
        z zVar = this.j;
        return (com.google.android.libraries.navigation.internal.zp.r) com.google.android.libraries.navigation.internal.hc.a.e(((f) zVar).c, dgVar, com.google.android.libraries.navigation.internal.zp.r.a);
    }

    public final bi d() {
        dg dgVar = (dg) bi.a.aH(7, null);
        z zVar = this.j;
        return (bi) com.google.android.libraries.navigation.internal.hc.a.e(((f) zVar).f, dgVar, bi.a);
    }

    public final bk e() {
        return (bk) this.f459n.d((dg) bk.a.aH(7, null), bk.a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof aa) {
            aa aaVar = (aa) obj;
            if (am.a(this.l, aaVar.l) && am.a(this.d, aaVar.d) && this.e == aaVar.e && am.a(this.f, aaVar.f)) {
                String str = aaVar.m;
                if (am.a(null, null) && am.a(this.k, aaVar.k) && am.a(e(), aaVar.e()) && this.g == aaVar.g) {
                    com.google.android.libraries.navigation.internal.zy.n nVar = aaVar.h;
                    if (am.a(null, null)) {
                        boolean z = aaVar.i;
                        k kVar = aaVar.p;
                        if (am.a(null, null) && am.a(this.j, aaVar.j)) {
                            String str2 = aaVar.q;
                            if (am.a(null, null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final bv f() {
        dg dgVar = (dg) bv.a.aH(7, null);
        z zVar = this.j;
        return (bv) com.google.android.libraries.navigation.internal.hc.a.e(((f) zVar).e, dgVar, bv.a);
    }

    public final ca g() {
        return ((f) this.j).a;
    }

    public final ag h() {
        dg dgVar = (dg) ag.a.aH(7, null);
        z zVar = this.j;
        return (ag) com.google.android.libraries.navigation.internal.hc.a.e(((f) zVar).d, dgVar, ag.a);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{i(), this.d, Boolean.valueOf(this.e), this.f, null, this.k, e(), this.g, null, false, null, this.j, null});
    }

    public final ap i() {
        return (ap) com.google.android.libraries.navigation.internal.hc.a.e(this.l, (dg) ap.a.aH(7, null), ap.a);
    }

    public final boolean j() {
        return (aq.c(this.d) && aq.c(this.f) && this.k == null) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x001c  */
    public final String toString() throws cc {
        com.google.android.libraries.navigation.internal.zt.b bVar;
        bk bkVarE = e();
        ak akVar = new ak("UserEvent3Params");
        akVar.h();
        akVar.g("uiState", i());
        String string = this.d;
        com.google.android.libraries.navigation.internal.zr.aq aqVar = null;
        if (string == null) {
            bVar = null;
        } else if (string.startsWith("0") || string.startsWith(ExifInterface.GPS_MEASUREMENT_2D)) {
            String strSubstring = string.substring(1);
            try {
                byte[] bArrJ = com.google.android.libraries.navigation.internal.zn.g.e.j(strSubstring);
                com.google.android.libraries.navigation.internal.ael.bi biVarV = com.google.android.libraries.navigation.internal.ael.bi.v(com.google.android.libraries.navigation.internal.zt.b.a, bArrJ, 0, bArrJ.length, ar.b());
                com.google.android.libraries.navigation.internal.ael.bi.I(biVarV);
                bVar = (com.google.android.libraries.navigation.internal.zt.b) biVarV;
            } catch (IllegalArgumentException e) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.jw.a.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F(745)).s("Bad Base64 string: %s, see http://go/gmm-logging-errors#invalid-base64-ved.", strSubstring);
                bVar = null;
            }
        } else if (string.startsWith("1")) {
            String strSubstring2 = string.substring(1);
            com.google.android.libraries.navigation.internal.zt.a aVar = (com.google.android.libraries.navigation.internal.zt.a) com.google.android.libraries.navigation.internal.zt.b.a.q();
            String[] strArrSplit = strSubstring2.split(",");
            int length = strArrSplit.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    String str = strArrSplit[i];
                    if (str.length() >= 3 && str.charAt(1) == ':') {
                        char cCharAt = str.charAt(0);
                        String strSubstring3 = str.substring(2);
                        if (cCharAt == 'e') {
                            int i2 = Integer.parseInt(strSubstring3);
                            if (!aVar.b.H()) {
                                aVar.v();
                            }
                            com.google.android.libraries.navigation.internal.zt.b bVar2 = (com.google.android.libraries.navigation.internal.zt.b) aVar.b;
                            bVar2.b |= 32;
                            bVar2.g = i2;
                        } else if (cCharAt == 'i') {
                            int i3 = Integer.parseInt(strSubstring3);
                            if (!aVar.b.H()) {
                                aVar.v();
                            }
                            com.google.android.libraries.navigation.internal.zt.b bVar3 = (com.google.android.libraries.navigation.internal.zt.b) aVar.b;
                            bVar3.b |= 1;
                            bVar3.c = i3;
                        } else if (cCharAt == 'p') {
                            com.google.android.libraries.navigation.internal.zt.d dVarA = com.google.android.libraries.navigation.internal.kb.a.a(strSubstring3);
                            if (dVarA != null) {
                                if (!aVar.b.H()) {
                                    aVar.v();
                                }
                                com.google.android.libraries.navigation.internal.zt.b bVar4 = (com.google.android.libraries.navigation.internal.zt.b) aVar.b;
                                bVar4.j = dVarA;
                                bVar4.b |= 2048;
                            }
                        } else if (cCharAt != 'y') {
                            switch (cCharAt) {
                                case 'r':
                                    int i4 = Integer.parseInt(strSubstring3);
                                    if (!aVar.b.H()) {
                                        aVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.zt.b bVar5 = (com.google.android.libraries.navigation.internal.zt.b) aVar.b;
                                    bVar5.b |= 64;
                                    bVar5.h = i4;
                                    continue;
                                case 's':
                                    int i5 = Integer.parseInt(strSubstring3);
                                    if (!aVar.b.H()) {
                                        aVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.zt.b bVar6 = (com.google.android.libraries.navigation.internal.zt.b) aVar.b;
                                    bVar6.b |= 128;
                                    bVar6.i = i5;
                                    continue;
                                case 't':
                                    try {
                                        int i6 = Integer.parseInt(strSubstring3);
                                        if (!aVar.b.H()) {
                                            aVar.v();
                                        }
                                        com.google.android.libraries.navigation.internal.zt.b bVar7 = (com.google.android.libraries.navigation.internal.zt.b) aVar.b;
                                        bVar7.b |= 8;
                                        bVar7.e = i6;
                                        continue;
                                    } catch (cc | NumberFormatException unused) {
                                    }
                                    break;
                            }
                        } else {
                            int i7 = Integer.parseInt(strSubstring3);
                            if (!aVar.b.H()) {
                                aVar.v();
                            }
                            com.google.android.libraries.navigation.internal.zt.b bVar8 = (com.google.android.libraries.navigation.internal.zt.b) aVar.b;
                            bVar8.b |= 16;
                            bVar8.f = i7;
                        }
                        i++;
                    }
                    bVar = null;
                } else {
                    bVar = (com.google.android.libraries.navigation.internal.zt.b) aVar.t();
                }
            }
        } else {
            bVar = null;
        }
        if (bVar != null) {
            string = Integer.toString(bVar.e);
        }
        akVar.g("dataElement", string);
        ak akVarE = akVar.e("vedHasEi", this.e);
        akVarE.g("serverEi", this.f);
        akVarE.g("splitEventDataReference", null);
        com.google.android.libraries.navigation.internal.afd.a aVar2 = this.k;
        akVarE.g("visualElement", aVar2 == null ? null : Integer.toString(aVar2.a()));
        akVarE.g("prefetchUpgradeType", this.g);
        akVarE.g("clickFeatureFingerprint", null);
        akVarE.g("clickFeatureFingerprintScrubbed", null);
        akVarE.g("forcedExternalContext", null);
        akVarE.g("impressionParams", this.j);
        akVarE.g("notificationMetadata", null);
        if ((bkVarE.b & 128) != 0 && (aqVar = bkVarE.d) == null) {
            aqVar = com.google.android.libraries.navigation.internal.zr.aq.a;
        }
        akVarE.g("bottomSheetParams", aqVar);
        return akVarE.toString();
    }
}
