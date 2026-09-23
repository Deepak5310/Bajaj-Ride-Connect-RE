package com.google.android.libraries.navigation.internal.bp;

import j$.time.Duration;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am {
    public final int a;
    public final Duration b;
    public final boolean c;

    public am(int i, Duration duration, boolean z) {
        this.a = i;
        this.b = duration;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof am) {
            am amVar = (am) obj;
            if (this.a == amVar.a && com.google.android.libraries.navigation.internal.yx.am.a(this.b, amVar.b) && this.c == amVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), this.b, Boolean.valueOf(this.c)});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarC = com.google.android.libraries.navigation.internal.yx.al.b(this).c("distanceFromStartMeters", this.a);
        akVarC.g("eta", this.b);
        return akVarC.e("generatedFromTrafficData", this.c).toString();
    }
}
