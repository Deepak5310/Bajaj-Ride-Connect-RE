package com.google.android.libraries.navigation.internal.vd;

import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.in;
import com.google.android.libraries.navigation.internal.adr.io;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.afl.fp;
import com.google.android.libraries.navigation.internal.bp.bg;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements com.google.android.libraries.navigation.internal.rw.d {
    final /* synthetic */ m a;

    public l(m mVar) {
        this.a = mVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.d
    public final void a(com.google.android.libraries.navigation.internal.rw.b bVar) {
        com.google.android.libraries.navigation.internal.se.b bVarC;
        com.google.android.libraries.navigation.internal.db.r rVar;
        com.google.android.libraries.navigation.internal.tj.j jVar = ((com.google.android.libraries.navigation.internal.rw.i) bVar).d;
        if (jVar == null || (bVarC = jVar.c()) == null || bVarC.c == null || (rVar = jVar.a) == null) {
            return;
        }
        m mVar = this.a;
        fp fpVar = mVar.f;
        int i = fpVar.b;
        if ((i & 4) == 0 || (i & 8) == 0) {
            return;
        }
        if (!mVar.b) {
            int i2 = bVarC.f;
            int i3 = bVarC.k;
            int i4 = fpVar.f;
            int i5 = fpVar.g;
            if (i2 <= i4 || i3 <= i5) {
                if (mVar.a) {
                    mVar.c();
                }
                if (i2 == 0 || i3 == 0) {
                    mVar.d(mVar.f.k);
                    return;
                }
                return;
            }
            bg bgVar = bVarC.b;
            ii iiVar = bgVar.u;
            if (bgVar.U() && iiVar != null && (iiVar.b & 1) != 0) {
                Instant instantOfEpochMilli = Instant.ofEpochMilli(iiVar.d);
                if (!instantOfEpochMilli.equals(mVar.d)) {
                    mVar.d = instantOfEpochMilli;
                    mVar.e = 0;
                }
                io ioVar = iiVar.j;
                if (ioVar == null) {
                    ioVar = io.a;
                }
                bz bzVar = ioVar.b;
                int i6 = bgVar.J - bVarC.j;
                while (mVar.e < bzVar.size()) {
                    int i7 = ((in) bzVar.get(mVar.e)).d - i6;
                    if (i7 > 0) {
                        if (i7 > mVar.f.l) {
                            break;
                        }
                        if (mVar.a) {
                            mVar.c();
                        }
                        if (i7 <= 20) {
                            mVar.d(mVar.f.m);
                            return;
                        }
                        return;
                    }
                    mVar.e++;
                }
            }
        }
        m mVar2 = this.a;
        int i8 = mVar2.f.d;
        if (i8 == -1 || rVar.h() > 4.0f) {
            return;
        }
        if (Math.abs(rVar.f) * 3.6f <= i8) {
            if (mVar2.a) {
                return;
            }
            mVar2.l = mVar2.a();
        } else if (mVar2.a && mVar2.l == null) {
            mVar2.c();
        }
    }
}
