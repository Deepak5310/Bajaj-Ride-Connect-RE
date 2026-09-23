package com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.google.android.libraries.geo.mapcore.internal.model.ai;
import com.google.android.libraries.geo.mapcore.internal.model.bs;
import com.google.android.libraries.geo.mapcore.internal.model.bt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends p {
    public static final int a = i.d;
    private final byte[] i;
    private final byte[] j;

    public a(float f, int i, boolean z) {
        super(f, i, z);
        this.i = new byte[64];
        this.j = new byte[64];
        for (int i2 = 0; i2 < 64; i2++) {
            this.i[i2] = -1;
        }
    }

    public final byte[] a(int i) {
        byte[] bArr;
        byte[] bArr2 = new byte[2048];
        for (int i2 = 0; i2 < this.c.size() && i2 < 8; i2++) {
            ai aiVarG = ((bt) this.c.get(i2)).g(i);
            for (int i3 = 0; i3 < d(aiVarG) && i3 < 4; i3++) {
                bs bsVarF = f(aiVarG, i3);
                int[] iArr = bsVarF.e;
                if (iArr.length == 0) {
                    bArr = this.i;
                } else {
                    byte[] bArr3 = new byte[64];
                    int i4 = bsVarF.f;
                    int i5 = bsVarF.g;
                    while (i4 / i5 > 64) {
                        i5 += i5;
                    }
                    int i6 = 0;
                    for (int i7 = 0; i7 < iArr.length; i7++) {
                        byte[] bArr4 = (i7 & 1) == 0 ? this.i : this.j;
                        int i8 = iArr[i7] / i5;
                        System.arraycopy(bArr4, 0, bArr3, i6, i8);
                        i6 += i8;
                    }
                    if (i6 != 64) {
                        bArr3[i6] = bArr3[0];
                        bArr3[63] = bArr3[i6 - 1];
                    }
                    bArr = bArr3;
                }
                System.arraycopy(bArr, 0, bArr2, ((i2 * 4) + i3) * 64, 64);
            }
        }
        return bArr2;
    }

    public final byte[] b() {
        byte[] bArr = new byte[a * BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT];
        int i = 0;
        while (i < this.c.size() && i < 8) {
            for (int i2 = 0; i2 < 22; i2++) {
                ai aiVarG = ((bt) this.c.get(i)).g(i2);
                ai aiVarG2 = i < this.d.size() ? ((bt) this.d.get(i)).g(i2) : ai.c;
                for (int i3 = 0; i3 < d(aiVarG) && i3 < 4; i3++) {
                    bs bsVarF = f(aiVarG, i3);
                    int i4 = bsVarF.b;
                    int i5 = bsVarF.c;
                    int i6 = f(aiVarG2, i3).b;
                    int i7 = ((i * 4) + i3) * 3;
                    int i8 = a;
                    int i9 = ((i7 * i8) + i2) * 4;
                    int i10 = (((i7 + 1) * i8) + i2) * 4;
                    int i11 = (((i7 + 2) * i8) + i2) * 4;
                    bArr[i9] = (byte) ((i4 >> 16) & 255);
                    bArr[i9 + 1] = (byte) ((i4 >> 8) & 255);
                    bArr[i9 + 2] = (byte) (i4 & 255);
                    bArr[i9 + 3] = (byte) ((i4 >> 24) & 255);
                    bArr[i10] = (byte) ((i5 >> 16) & 255);
                    bArr[i10 + 1] = (byte) ((i5 >> 8) & 255);
                    bArr[i10 + 2] = (byte) (i5 & 255);
                    bArr[i10 + 3] = (byte) ((i5 >> 24) & 255);
                    bArr[i11] = (byte) ((i6 >> 16) & 255);
                    bArr[i11 + 1] = (byte) ((i6 >> 8) & 255);
                    bArr[i11 + 2] = (byte) (i6 & 255);
                    bArr[i11 + 3] = (byte) ((i6 >> 24) & 255);
                }
            }
            i++;
        }
        return bArr;
    }
}
