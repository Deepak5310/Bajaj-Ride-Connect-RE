package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.internal.adr.ii;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gl {
    public ii a;
    public int b;
    public int c;
    public int d;

    public final int a() {
        return this.b - this.c;
    }

    public final String toString() {
        return com.google.android.libraries.navigation.internal.yx.al.b(this).c("Total Distance", this.b).c("Traveled Distance", a()).c("Remaining Distance", this.c).c("Distance to next Destination", this.d).toString();
    }
}
