package com.google.android.libraries.navigation.internal.ec;

import com.google.android.libraries.navigation.internal.db.r;
import com.google.android.libraries.navigation.internal.db.s;
import com.google.android.libraries.navigation.internal.nj.i;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    final /* synthetic */ c a;

    public b(c cVar) {
        this.a = cVar;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x014d  */
    /* JADX WARN: Code duplicated, block: B:57:0x017d  */
    public final void a(s sVar) {
        h hVar;
        r rVar;
        r rVarD = sVar.d();
        i.b();
        c cVar = this.a;
        if (rVarD == null) {
            cVar.g = false;
            cVar.f = false;
        } else {
            h hVar2 = cVar.d;
            long epochMilli = hVar2.d.f().toEpochMilli();
            int i = hVar2.f;
            if (i == 0 || Math.abs(epochMilli - hVar2.c) >= 120000 || (rVar = hVar2.e) == null || Math.abs(rVarD.b - rVar.b) >= 0.1d || Math.abs(rVarD.c - rVar.c) >= 0.1d) {
                hVar2.e = rVarD;
                hVar2.c = epochMilli;
                double d = (((float) rVarD.b) * 6.2831855f) / 360.0f;
                float f = ((float) rVarD.c) * 6.2831855f;
                if (d <= -3.141592653589793d || d >= 3.141592653589793d) {
                    hVar = hVar2;
                    i = 2;
                } else {
                    float f2 = f / 360.0f;
                    if (f2 < -6.2831855f || f2 > 6.2831855f || epochMilli < 946728000000L) {
                        hVar = hVar2;
                    } else {
                        float f3 = (epochMilli - 946728000000L) / 8.64E7f;
                        float f4 = ((f3 * 6.2831855f) / 365.25638f) + 6.24006f;
                        double d2 = f4;
                        float fSin = f4 + (((float) Math.sin(d2)) * 0.0334196f) + (((float) Math.sin(f4 + f4)) * 3.49066E-4f) + (((float) Math.sin(3.0f * f4)) * 5.236E-6f) + 1.7966f + 3.1415927f;
                        double dAsin = (float) Math.asin(Math.sin(fSin) * ((double) h.a));
                        float fSin2 = (hVar2.b - ((float) (Math.sin(d) * Math.sin(dAsin)))) / ((float) (Math.cos(d) * Math.cos(dAsin)));
                        if (fSin2 < 1.0f) {
                            if (fSin2 > -1.0f) {
                                float fAcos = (float) Math.acos(fSin2);
                                float fSin3 = f3 - (((((-f2) / 6.2831855f) + 9.0E-4f) + (((float) Math.sin(d2)) * 0.0053f)) + (((float) Math.sin(fSin + fSin)) * (-0.0069f)));
                                float f5 = (-fAcos) / 6.2831855f;
                                float fRound = fSin3 - Math.round(fSin3);
                                if (fRound < f5 || fRound > fAcos / 6.2831855f) {
                                }
                            }
                            hVar = hVar2;
                        }
                        hVar = hVar2;
                        i = 1;
                    }
                    i = 2;
                }
                hVar.f = i;
            }
            boolean z = true;
            boolean z2 = i == 1;
            if (rVarD.w()) {
                boolean z3 = cVar.f;
                if (z3 || !rVarD.l().d()) {
                    if (cVar.f && rVarD.l().c()) {
                        z = false;
                    } else {
                        z = z3;
                    }
                }
            } else {
                z = false;
            }
            cVar.g = z2;
            cVar.f = z;
        }
        cVar.b();
    }
}
