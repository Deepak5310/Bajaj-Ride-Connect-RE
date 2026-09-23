package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class cr {
    public static final cr a = new cr(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22});
    public static final cr b = new cr(new int[0]);
    public final byte[] c;

    public cr(int[] iArr) {
        byte[] bArr;
        com.google.android.libraries.navigation.internal.agd.at atVar = new com.google.android.libraries.navigation.internal.agd.at();
        int i = 0;
        for (int i2 : iArr) {
            if (i2 >= 0 && i2 <= 127) {
                atVar.c((byte) i2);
            }
        }
        int size = atVar.size();
        if (size == 0) {
            bArr = com.google.android.libraries.navigation.internal.agd.q.a;
        } else {
            byte[] bArr2 = new byte[size];
            com.google.android.libraries.navigation.internal.agd.al it2 = atVar.iterator();
            while (size != 0 && it2.hasNext()) {
                bArr2[i] = it2.c();
                size--;
                i++;
            }
            bArr = bArr2;
        }
        this.c = bArr;
        Arrays.sort(bArr);
    }

    public final int a(float f) {
        if (f > 127.0f) {
            return -1;
        }
        int iBinarySearch = Arrays.binarySearch(this.c, (byte) Math.floor(f));
        if (iBinarySearch >= 0) {
            return this.c[iBinarySearch];
        }
        int i = -iBinarySearch;
        if (i - 1 != 0) {
            return this.c[i - 2];
        }
        return -1;
    }
}
