package com.google.android.libraries.navigation.internal.qh;

import com.google.android.libraries.geo.mapcore.internal.model.ai;
import com.google.android.libraries.geo.mapcore.internal.model.bs;
import com.google.android.libraries.geo.mapcore.internal.model.bt;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public final int[] a = new int[29];
    private final int b;

    public static int a(int i, int i2, int i3) {
        return ((char) i) | ((i2 & 255) << 16) | ((i3 & 255) << 24);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return Arrays.equals(this.a, ((a) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.b;
    }

    public a(bt btVar, boolean z) {
        int i = 16;
        if (z) {
            for (int i2 = 0; i2 <= 22; i2++) {
                ai aiVarG = btVar.g(i2);
                int[] iArr = this.a;
                iArr[i2] = aiVarG.j;
                int i3 = (i2 / 4) + 23;
                iArr[i3] = ((true != aiVarG.d ? 255 : 0) << i) | iArr[i3];
                i -= 8;
                if (i < 0) {
                    i = 24;
                }
            }
        } else {
            for (int i4 = 0; i4 <= 22; i4++) {
                ai aiVarG2 = btVar.g(i4);
                bs[] bsVarArr = aiVarG2.f58n;
                if (bsVarArr.length > 0) {
                    this.a[i4] = bsVarArr[0].b;
                } else {
                    this.a[i4] = 0;
                }
                int[] iArr2 = this.a;
                int i5 = (i4 / 4) + 23;
                iArr2[i5] = ((true != aiVarG2.e ? 255 : 0) << i) | iArr2[i5];
                i -= 8;
                if (i < 0) {
                    i = 24;
                }
            }
        }
        this.b = Arrays.hashCode(this.a);
    }
}
