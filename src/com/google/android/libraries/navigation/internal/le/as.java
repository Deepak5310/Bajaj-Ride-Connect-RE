package com.google.android.libraries.navigation.internal.le;

import android.os.Handler;
import android.os.SystemClock;
import com.mappls.sdk.navigation.NavigationConstants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class as implements com.google.android.libraries.navigation.internal.me.o {
    private final ai a;
    private final int b;
    private final i c;
    private final long d;
    private final long e;

    public as(ai aiVar, int i, i iVar, long j, long j2) {
        this.a = aiVar;
        this.b = i;
        this.c = iVar;
        this.d = j;
        this.e = j2;
    }

    public static com.google.android.libraries.navigation.internal.lh.t b(ae aeVar, com.google.android.libraries.navigation.internal.lh.k kVar, int i) {
        int[] iArr;
        int[] iArr2;
        com.google.android.libraries.navigation.internal.lh.r rVar = kVar.o;
        com.google.android.libraries.navigation.internal.lh.t tVar = rVar == null ? null : rVar.d;
        if (tVar == null || !tVar.b || ((iArr = tVar.d) != null ? !com.google.android.libraries.navigation.internal.ll.b.a(iArr, i) : !((iArr2 = tVar.f) == null || !com.google.android.libraries.navigation.internal.ll.b.a(iArr2, i))) || aeVar.h >= tVar.e) {
            return null;
        }
        return tVar;
    }

    @Override // com.google.android.libraries.navigation.internal.me.o
    public final void a(com.google.android.libraries.navigation.internal.me.w wVar) {
        ae aeVarB;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int iElapsedRealtime;
        long j;
        long j2;
        if (this.a.f()) {
            com.google.android.libraries.navigation.internal.lh.bl blVar = com.google.android.libraries.navigation.internal.lh.bk.a().a;
            if ((blVar == null || blVar.b) && (aeVarB = this.a.b(this.c)) != null) {
                Object obj = aeVarB.b;
                if (obj instanceof com.google.android.libraries.navigation.internal.lh.k) {
                    boolean z = this.d > 0;
                    if (blVar != null) {
                        z &= blVar.c;
                        com.google.android.libraries.navigation.internal.lh.k kVar = (com.google.android.libraries.navigation.internal.lh.k) obj;
                        boolean zA = kVar.A();
                        i = blVar.d;
                        int i7 = blVar.e;
                        i2 = blVar.a;
                        if (zA && !kVar.m()) {
                            com.google.android.libraries.navigation.internal.lh.t tVarB = b(aeVarB, kVar, this.b);
                            if (tVarB == null) {
                                return;
                            }
                            boolean z2 = tVarB.c && this.d > 0;
                            i7 = tVarB.e;
                            z = z2;
                        }
                        i3 = i7;
                    } else {
                        i = NavigationConstants.UI_HANDLER_LOCATION_SERVICE;
                        i2 = 0;
                        i3 = 100;
                    }
                    ai aiVar = this.a;
                    if (wVar.e()) {
                        i6 = 0;
                        i5 = 0;
                    } else if (((com.google.android.libraries.navigation.internal.me.ae) wVar).d) {
                        i5 = -1;
                        i6 = 100;
                    } else {
                        Exception excC = wVar.c();
                        if (excC instanceof com.google.android.libraries.navigation.internal.ld.l) {
                            com.google.android.libraries.navigation.internal.ld.ab abVar = ((com.google.android.libraries.navigation.internal.ld.l) excC).a;
                            i4 = abVar.f;
                            com.google.android.libraries.navigation.internal.lc.a aVar = abVar.i;
                            if (aVar != null) {
                                i5 = aVar.c;
                            }
                            i6 = i4;
                        } else {
                            i4 = 101;
                        }
                        i5 = -1;
                        i6 = i4;
                    }
                    if (z) {
                        long j3 = this.d;
                        long j4 = this.e;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - j4);
                        j = j3;
                        j2 = jCurrentTimeMillis;
                    } else {
                        iElapsedRealtime = -1;
                        j = 0;
                        j2 = 0;
                    }
                    int i8 = ((com.google.android.libraries.navigation.internal.lh.k) obj).j;
                    Handler handler = aiVar.p;
                    handler.sendMessage(handler.obtainMessage(18, new at(new com.google.android.libraries.navigation.internal.lh.aw(this.b, i6, i5, j, j2, null, null, i8, iElapsedRealtime), i2, i, i3)));
                }
            }
        }
    }
}
