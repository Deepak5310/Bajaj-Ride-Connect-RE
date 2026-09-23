package com.google.android.libraries.navigation.internal.hf;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r {
    private static final int e = (int) TimeUnit.MINUTES.toSeconds(1);
    private static final int f = (int) TimeUnit.HOURS.toSeconds(1);
    private static final int g = (int) TimeUnit.DAYS.toSeconds(1);
    int a;
    int b;
    int c;
    final int d;

    static {
        TimeUnit.HOURS.toMinutes(1L);
        TimeUnit.DAYS.toMinutes(1L);
    }

    public r(int i, int i2) {
        int iRound = Math.round(i / 60.0f) * 60;
        iRound = i2 == 4 ? ((int) Math.ceil(iRound / 600.0f)) * 600 : iRound;
        iRound = i2 == 5 ? ((int) Math.floor(iRound / 600.0f)) * 600 : iRound;
        int i3 = g;
        int i4 = iRound / i3;
        this.a = i4;
        int i5 = iRound % i3;
        int i6 = f;
        int i7 = i5 / i6;
        this.b = i7;
        this.c = (i5 % i6) / e;
        this.d = 0;
        int i8 = i2 - 1;
        if (i8 == 3 || i8 == 4) {
            return;
        }
        if (i8 != 5) {
            if (i4 > 0) {
                a(true);
            }
        } else if (i4 <= 0) {
            if (i7 > 0) {
                a(true);
            }
        } else {
            if (i7 > 12) {
                this.a = i4 + 1;
            }
            this.b = 0;
            this.c = 0;
        }
    }

    private final void a(boolean z) {
        if (this.c > (true != z ? 29 : 30)) {
            int i = this.b + 1;
            this.b = i;
            if (i == 24) {
                this.b = 0;
                this.a++;
            }
        }
        this.c = 0;
    }
}
