package com.google.android.libraries.navigation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class TimeAndDistance {
    public static final int DELAY_HEAVY = 1;
    public static final int DELAY_LIGHT = 3;
    public static final int DELAY_MEDIUM = 2;
    public static final int DELAY_NODATA = 0;
    private final int a;
    private final int b;
    private final int c;

    /* JADX INFO: compiled from: PG */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DelaySeverity {
    }

    public TimeAndDistance(int i, int i2) {
        this(i, i2, 0);
    }

    public int getDelaySeverity() {
        try {
            return this.c;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int getMeters() {
        try {
            return this.b;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public int getSeconds() {
        try {
            return this.a;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public TimeAndDistance(int i, int i2, int i3) {
        try {
            this.a = i;
            this.b = i2;
            this.c = i3;
        } catch (Error | RuntimeException e) {
            com.google.android.libraries.navigation.environment.b.c(e);
            throw e;
        }
    }

    public TimeAndDistance(com.google.android.libraries.navigation.internal.vv.c cVar) {
        this(cVar.a, cVar.b, cVar.c);
    }
}
