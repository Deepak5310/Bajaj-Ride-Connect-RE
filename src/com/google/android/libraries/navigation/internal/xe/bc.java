package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.NavigationRoadStretchRenderingData;
import com.google.android.libraries.navigation.NavigationTrafficData;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.adr.im;
import com.google.android.libraries.navigation.internal.adr.in;
import com.google.android.libraries.navigation.internal.adr.io;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bc {
    public static NavigationTrafficData a(ii iiVar, int i, int i2) {
        int i3;
        int i4;
        ArrayList arrayList = new ArrayList();
        io ioVar = iiVar.j;
        if (ioVar == null) {
            ioVar = io.a;
        }
        for (in inVar : ioVar.b) {
            int i5 = inVar.d;
            if (i5 >= 0 && (i3 = inVar.e) >= 0 && (i4 = i3 + i5) > i2 && i5 < i) {
                if (i5 < i2) {
                    if (i < i4) {
                        i4 = i;
                    }
                    try {
                        NavigationRoadStretchRenderingData.Builder builder = new NavigationRoadStretchRenderingData.Builder();
                        im imVarB = im.b(inVar.c);
                        if (imVarB == null) {
                            imVarB = im.UNKNOWN_STYLE;
                        }
                        builder.setStyle(imVarB);
                        builder.setOffsetMeters(0);
                        builder.setLengthMeters(i4 - i2);
                        arrayList.add(builder.build());
                    } catch (IllegalArgumentException e) {
                        e.getMessage();
                    }
                } else {
                    NavigationRoadStretchRenderingData.Builder builder2 = new NavigationRoadStretchRenderingData.Builder();
                    im imVarB2 = im.b(inVar.c);
                    if (imVarB2 == null) {
                        imVarB2 = im.UNKNOWN_STYLE;
                    }
                    builder2.setStyle(imVarB2);
                    builder2.setOffsetMeters(i5 - i2);
                    builder2.setLengthMeters(i < i4 ? i - i5 : inVar.e);
                    arrayList.add(builder2.build());
                }
            }
        }
        return new NavigationTrafficData(com.google.android.libraries.navigation.internal.yz.ev.o(arrayList));
    }
}
