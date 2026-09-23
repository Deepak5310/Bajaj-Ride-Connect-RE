package com.google.android.libraries.navigation.internal.ti;

import com.google.android.libraries.navigation.internal.bp.bf;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.bt;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zs.fe;
import com.google.android.libraries.navigation.internal.zs.fg;
import com.google.android.libraries.navigation.internal.zs.fh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ae {
    public fh a;
    private final ad b;
    private final e c;
    private final af d;

    public ae(ad adVar, e eVar, af afVar) {
        this.b = adVar;
        this.c = eVar;
        this.d = afVar;
    }

    private static int b(bf bfVar) {
        int iOrdinal = bfVar.ordinal();
        if (iOrdinal == 0) {
            return fg.b;
        }
        if (iOrdinal != 1) {
            return iOrdinal != 2 ? fg.a : fg.d;
        }
        return fg.c;
    }

    /* JADX WARN: Code duplicated, block: B:152:0x03fc  */
    /* JADX WARN: Code duplicated, block: B:83:0x026c  */
    /* JADX WARN: Code duplicated, block: B:85:0x0278  */
    /* JADX WARN: Code duplicated, block: B:88:0x0282  */
    /* JADX WARN: Code duplicated, block: B:91:0x028d  */
    final fh a(bg bgVar, bq bqVar) {
        int iA;
        fh fhVar;
        int i;
        if (!this.c.c()) {
            return null;
        }
        fe feVar = (fe) fh.a.q();
        int i2 = this.d.a;
        if (!feVar.b.H()) {
            feVar.v();
        }
        fh fhVar2 = (fh) feVar.b;
        fhVar2.b |= 2;
        fhVar2.d = i2;
        int i3 = this.d.b;
        if (!feVar.b.H()) {
            feVar.v();
        }
        fh fhVar3 = (fh) feVar.b;
        fhVar3.b |= 4;
        fhVar3.e = i3;
        if (bgVar == null) {
            e eVar = this.c;
            ar.k(eVar.c());
            bf bfVar = eVar.g;
            ar.q(bfVar);
            int iB = b(bfVar);
            if (!feVar.b.H()) {
                feVar.v();
            }
            fh fhVar4 = (fh) feVar.b;
            int i4 = iB - 1;
            if (iB == 0) {
                throw null;
            }
            fhVar4.c = i4;
            fhVar4.b |= 1;
            int iA2 = this.c.a();
            if (!feVar.b.H()) {
                feVar.v();
            }
            fh fhVar5 = (fh) feVar.b;
            fhVar5.b |= 16;
            fhVar5.g = iA2;
            e eVar2 = this.c;
            ar.k(eVar2.c());
            String str = eVar2.c;
            if (!feVar.b.H()) {
                feVar.v();
            }
            fh fhVar6 = (fh) feVar.b;
            str.getClass();
            fhVar6.b |= 256;
            fhVar6.k = str;
            e eVar3 = this.c;
            ar.k(eVar3.c());
            int i5 = eVar3.b;
            if (!feVar.b.H()) {
                feVar.v();
            }
            fh fhVar7 = (fh) feVar.b;
            fhVar7.b |= 8;
            fhVar7.f = i5;
        } else {
            int iB2 = b(bgVar.Q);
            if (!feVar.b.H()) {
                feVar.v();
            }
            fh fhVar8 = (fh) feVar.b;
            int i6 = iB2 - 1;
            if (iB2 == 0) {
                throw null;
            }
            fhVar8.c = i6;
            fhVar8.b |= 1;
            int i7 = bgVar.A;
            if (!feVar.b.H()) {
                feVar.v();
            }
            fh fhVar9 = (fh) feVar.b;
            fhVar9.b |= 16;
            fhVar9.g = i7;
            String str2 = bgVar.B;
            if (!feVar.b.H()) {
                feVar.v();
            }
            fh fhVar10 = (fh) feVar.b;
            str2.getClass();
            fhVar10.b |= 256;
            fhVar10.k = str2;
            int iA3 = com.google.android.libraries.navigation.internal.vm.a.a(this.b.b, bgVar.z);
            if (!feVar.b.H()) {
                feVar.v();
            }
            fh fhVar11 = (fh) feVar.b;
            fhVar11.b |= 8;
            fhVar11.f = iA3;
        }
        if (bqVar == null) {
            e eVar4 = this.c;
            ar.k(eVar4.c());
            int i8 = eVar4.d;
            if (!feVar.b.H()) {
                feVar.v();
            }
            fh fhVar12 = (fh) feVar.b;
            fhVar12.b |= 32;
            fhVar12.h = i8;
            e eVar5 = this.c;
            ar.k(eVar5.c());
            int i9 = eVar5.e;
            if (!feVar.b.H()) {
                feVar.v();
            }
            fh fhVar13 = (fh) feVar.b;
            fhVar13.b |= 64;
            fhVar13.i = i9;
            e eVar6 = this.c;
            ar.k(eVar6.c());
            int i10 = eVar6.f;
            if (!feVar.b.H()) {
                feVar.v();
            }
            fh fhVar14 = (fh) feVar.b;
            fhVar14.b |= 128;
            fhVar14.j = i10;
        } else {
            int iC = com.google.android.libraries.navigation.internal.vm.a.c(this.b.b, bqVar.L);
            if (!feVar.b.H()) {
                feVar.v();
            }
            fh fhVar15 = (fh) feVar.b;
            fhVar15.b |= 32;
            fhVar15.h = iC;
            bt btVar = bqVar.b;
            if (btVar != null) {
                if (!feVar.b.H()) {
                    feVar.v();
                }
                fh fhVar16 = (fh) feVar.b;
                fhVar16.b |= 64;
                fhVar16.i = btVar.b;
                int i11 = bqVar.i;
                if (!feVar.b.H()) {
                    feVar.v();
                }
                fh fhVar17 = (fh) feVar.b;
                fhVar17.b |= 128;
                fhVar17.j = i11;
            } else {
                if (!feVar.b.H()) {
                    feVar.v();
                }
                fh fhVar18 = (fh) feVar.b;
                fhVar18.b |= 64;
                fhVar18.i = -1;
                if (!feVar.b.H()) {
                    feVar.v();
                }
                fh fhVar19 = (fh) feVar.b;
                fhVar19.b |= 128;
                fhVar19.j = -1;
            }
        }
        fe feVar2 = (fe) fh.a.q();
        fh fhVar20 = this.a;
        if (fhVar20 == null) {
            iA = fg.a(((fh) feVar.b).c);
            if (iA == 0) {
                iA = fg.a;
            }
            if (!feVar2.b.H()) {
                feVar2.v();
            }
            fhVar = (fh) feVar2.b;
            i = iA - 1;
            if (iA != 0) {
                throw null;
            }
            fhVar.c = i;
            fhVar.b |= 1;
        } else {
            int iA4 = fg.a(((fh) feVar.b).c);
            if (iA4 == 0) {
                iA4 = fg.a;
            }
            int iA5 = fg.a(fhVar20.c);
            if (iA5 == 0) {
                iA5 = fg.a;
            }
            if (iA4 != iA5) {
                iA = fg.a(((fh) feVar.b).c);
                if (iA == 0) {
                    iA = fg.a;
                }
                if (!feVar2.b.H()) {
                    feVar2.v();
                }
                fhVar = (fh) feVar2.b;
                i = iA - 1;
                if (iA != 0) {
                    throw null;
                }
                fhVar.c = i;
                fhVar.b |= 1;
            }
        }
        if (fhVar20 == null || ((fh) feVar.b).d != fhVar20.d) {
            int i12 = ((fh) feVar.b).d;
            if (!feVar2.b.H()) {
                feVar2.v();
            }
            fh fhVar21 = (fh) feVar2.b;
            fhVar21.b |= 2;
            fhVar21.d = i12;
        }
        if (fhVar20 == null || ((fh) feVar.b).e != fhVar20.e) {
            int i13 = ((fh) feVar.b).e;
            if (!feVar2.b.H()) {
                feVar2.v();
            }
            fh fhVar22 = (fh) feVar2.b;
            fhVar22.b |= 4;
            fhVar22.e = i13;
        }
        if (fhVar20 == null || ((fh) feVar.b).f != fhVar20.f) {
            int i14 = ((fh) feVar.b).f;
            if (!feVar2.b.H()) {
                feVar2.v();
            }
            fh fhVar23 = (fh) feVar2.b;
            fhVar23.b |= 8;
            fhVar23.f = i14;
        }
        if (fhVar20 == null || ((fh) feVar.b).g != fhVar20.g) {
            int i15 = ((fh) feVar.b).g;
            if (!feVar2.b.H()) {
                feVar2.v();
            }
            fh fhVar24 = (fh) feVar2.b;
            fhVar24.b |= 16;
            fhVar24.g = i15;
        }
        if (fhVar20 == null || !((fh) feVar.b).k.equals(fhVar20.k)) {
            String str3 = ((fh) feVar.b).k;
            if (!feVar2.b.H()) {
                feVar2.v();
            }
            fh fhVar25 = (fh) feVar2.b;
            str3.getClass();
            fhVar25.b |= 256;
            fhVar25.k = str3;
        }
        if (fhVar20 == null || ((fh) feVar.b).h != fhVar20.h) {
            int i16 = ((fh) feVar.b).h;
            if (!feVar2.b.H()) {
                feVar2.v();
            }
            fh fhVar26 = (fh) feVar2.b;
            fhVar26.b |= 32;
            fhVar26.h = i16;
        }
        if (fhVar20 == null || ((fh) feVar.b).i != fhVar20.i) {
            int i17 = ((fh) feVar.b).i;
            if (!feVar2.b.H()) {
                feVar2.v();
            }
            fh fhVar27 = (fh) feVar2.b;
            fhVar27.b |= 64;
            fhVar27.i = i17;
        }
        if (fhVar20 == null || ((fh) feVar.b).j != fhVar20.j) {
            int i18 = ((fh) feVar.b).j;
            if (!feVar2.b.H()) {
                feVar2.v();
            }
            fh fhVar28 = (fh) feVar2.b;
            fhVar28.b |= 128;
            fhVar28.j = i18;
        }
        this.a = (fh) feVar.t();
        fh fhVar29 = (fh) feVar2.t();
        if (fhVar29.equals(fh.a)) {
            return null;
        }
        return fhVar29;
    }
}
