package com.google.android.libraries.navigation.internal.ub;

import com.google.android.libraries.navigation.internal.afl.fd;
import com.google.android.libraries.navigation.internal.jy.t;
import java.util.HashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public final HashMap a;

    public i(com.google.android.libraries.navigation.internal.fz.d dVar, t tVar, com.google.android.libraries.navigation.internal.si.e eVar, com.google.android.libraries.navigation.internal.oq.h hVar, com.google.android.libraries.navigation.internal.uc.t tVar2, float f) {
        i iVar = this;
        iVar.a = new HashMap();
        int i = 2;
        boolean[] zArr = {true, false};
        int i2 = 0;
        while (i2 < i) {
            boolean z = zArr[i2];
            int i3 = 0;
            while (i3 < i) {
                boolean z2 = zArr[i3];
                com.google.android.libraries.navigation.internal.uc.a aVar = new com.google.android.libraries.navigation.internal.uc.a();
                aVar.b(fd.CAMERA_2D_NORTH_UP);
                aVar.c(z2);
                aVar.d(z);
                com.google.android.libraries.navigation.internal.uc.i iVarA = aVar.a();
                iVar.a.put(iVarA, new n(dVar, iVarA, eVar, com.google.android.libraries.navigation.internal.pd.h.LOCATION_ONLY));
                com.google.android.libraries.navigation.internal.uc.a aVar2 = new com.google.android.libraries.navigation.internal.uc.a();
                aVar2.b(fd.CAMERA_2D_HEADING_UP);
                aVar2.c(z2);
                aVar2.d(z);
                com.google.android.libraries.navigation.internal.uc.i iVarA2 = aVar2.a();
                iVar.a.put(iVarA2, new n(dVar, iVarA2, eVar, com.google.android.libraries.navigation.internal.pd.h.LOCATION_AND_BEARING));
                com.google.android.libraries.navigation.internal.uc.a aVar3 = new com.google.android.libraries.navigation.internal.uc.a();
                aVar3.b(fd.CAMERA_3D);
                aVar3.c(z2);
                aVar3.d(z);
                com.google.android.libraries.navigation.internal.uc.i iVarA3 = aVar3.a();
                iVar.a.put(iVarA3, new m(dVar, tVar, iVarA3, com.google.android.libraries.navigation.internal.pd.h.LOCATION_AND_BEARING, new j(dVar, iVarA3, hVar, f), tVar2));
                i3++;
                i = 2;
                iVar = this;
            }
            i2++;
            i = 2;
            iVar = this;
        }
    }
}
