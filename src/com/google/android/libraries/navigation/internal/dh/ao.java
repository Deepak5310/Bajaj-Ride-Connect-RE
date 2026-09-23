package com.google.android.libraries.navigation.internal.dh;

import android.location.GnssStatus;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ao extends GnssStatus.Callback {
    final /* synthetic */ ap a;
    private int b = 0;

    public ao(ap apVar) {
        this.a = apVar;
    }

    @Override // android.location.GnssStatus.Callback
    public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
        int satelliteCount = gnssStatus.getSatelliteCount();
        float[] fArrCopyOf = new float[satelliteCount];
        float[] fArrCopyOf2 = new float[satelliteCount];
        float f = -1.0f;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < satelliteCount; i3++) {
            float cn0DbHz = gnssStatus.getCn0DbHz(i3);
            if (gnssStatus.usedInFix(i3)) {
                fArrCopyOf[i] = cn0DbHz;
                i++;
            }
            if (cn0DbHz > 22.0f) {
                fArrCopyOf2[i3] = cn0DbHz;
                i2++;
            }
            if (f < cn0DbHz) {
                f = cn0DbHz;
            }
        }
        if (i < satelliteCount) {
            fArrCopyOf = Arrays.copyOf(fArrCopyOf, i);
        }
        Arrays.sort(fArrCopyOf);
        if (i2 < satelliteCount) {
            fArrCopyOf2 = Arrays.copyOf(fArrCopyOf2, i2);
        }
        Arrays.sort(fArrCopyOf2);
        if (i2 < 5 || i != 0) {
            this.b = 0;
        } else {
            int i4 = this.b + 1;
            this.b = i4;
            if (i4 > 100) {
                int i5 = ap.f;
                com.google.android.libraries.navigation.internal.kl.a aVar = this.a.c;
                if (aVar != null) {
                    ((com.google.android.libraries.navigation.internal.kk.k) aVar.a(com.google.android.libraries.navigation.internal.km.af.o)).a(20);
                }
                this.b = 0;
            }
        }
        if (i == 0) {
            fArrCopyOf = fArrCopyOf2;
        }
        int i6 = i != 0 ? i : i2;
        ap apVar = this.a;
        float fA = ap.a(fArrCopyOf);
        if (!apVar.d.a(fArrCopyOf)) {
            ap apVar2 = this.a;
            apVar2.e.a(i6, satelliteCount, f, fA, apVar2.a.a() + 2000 < 2000);
        } else {
            com.google.android.libraries.navigation.internal.kl.a aVar2 = this.a.c;
            if (aVar2 != null) {
                ((com.google.android.libraries.navigation.internal.kk.k) aVar2.a(com.google.android.libraries.navigation.internal.km.af.o)).a(19);
            }
        }
    }
}
