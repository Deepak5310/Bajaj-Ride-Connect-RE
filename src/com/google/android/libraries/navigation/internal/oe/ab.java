package com.google.android.libraries.navigation.internal.oe;

import com.google.android.libraries.navigation.internal.yx.ca;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab {
    public int a;
    public float b;
    private int[] c;
    private boolean d;
    private final int e;
    private final int f;
    private final int g;

    public ab() {
        this(16, 0, 0, 0);
    }

    public final void b() {
        this.a = 0;
    }

    public final boolean c(x xVar) {
        int i = xVar.a;
        int i2 = xVar.b;
        int i3 = this.a;
        int i4 = i3 + i3;
        int[] iArr = this.c;
        int length = iArr.length;
        if (i4 == length) {
            int[] iArr2 = new int[length + length];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.c = iArr2;
        }
        int i5 = this.a;
        int i6 = i5 + i5;
        if (i5 > 0) {
            int[] iArr3 = this.c;
            if (i == iArr3[i6 - 2] && i2 == iArr3[i6 - 1]) {
                this.d = true;
                return false;
            }
        }
        int[] iArr4 = this.c;
        iArr4[i6] = i;
        iArr4[i6 + 1] = i2;
        this.a = i5 + 1;
        return true;
    }

    public ab(int i) {
        this(i, 0, 0, 0);
    }

    public ab(int i, int i2, int i3) {
        this(16, i, i2, i3);
    }

    public final ad a() {
        int[] iArr;
        int i = this.a;
        if (i == 1 && this.d) {
            int[] iArr2 = new int[4];
            System.arraycopy(this.c, 0, iArr2, 0, 2);
            System.arraycopy(this.c, 0, iArr2, 2, 2);
            iArr = iArr2;
        } else {
            int i2 = i + i;
            int[] iArr3 = new int[i2];
            System.arraycopy(this.c, 0, iArr3, 0, i2);
            iArr = iArr3;
        }
        return new ad(iArr, this.e, this.f, this.g, this.b);
    }

    public ab(int i, int i2, int i3, int i4) {
        this.d = false;
        this.b = 0.0f;
        ca.a(i > 0);
        this.c = new int[i + i];
        this.a = 0;
        this.e = i2;
        this.f = i3;
        this.g = i4;
    }
}
