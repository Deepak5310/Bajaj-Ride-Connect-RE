package com.google.android.libraries.navigation.internal.oe;

import com.google.android.libraries.navigation.internal.adg.jj;
import com.google.maps.android.BuildConfig;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ax {
    final int a;
    final int b;
    final int c;
    public final int d;
    private final int e;

    public ax(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    final int a() throws IOException {
        int i = this.e;
        if (i == 0) {
            throw null;
        }
        switch (i - 1) {
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 1;
            case 4:
                return -1;
            case 5:
                return -2;
            case 6:
                return -3;
            case 7:
                return -4;
            case 8:
                return -5;
            case 9:
                return -6;
            case 10:
                return -7;
            case 11:
                return -8;
            case 12:
                return -9;
            case 13:
                return -10;
            case 14:
                return -11;
            case 15:
                return -12;
            case 16:
                return -13;
            case 17:
                return -14;
            case 18:
                return -15;
            case 19:
                return -16;
            case 20:
                return -17;
            case 21:
                return -18;
            default:
                throw new IOException("Unknown vertex resolution: ".concat(String.valueOf(String.valueOf(i != 0 ? jj.toString$ar$edu$c91d9840_0(i) : BuildConfig.TRAVIS))));
        }
    }
}
