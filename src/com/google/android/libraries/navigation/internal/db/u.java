package com.google.android.libraries.navigation.internal.db;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    public boolean a;
    public int b;
    public boolean c;

    public u() {
        this.a = false;
        this.b = -1;
        this.c = false;
    }

    public u(boolean z, int i, boolean z2) {
        this.a = z;
        this.b = i;
        this.c = z2;
    }

    public final v a() {
        return new v(this.a, this.b, this.c);
    }
}
