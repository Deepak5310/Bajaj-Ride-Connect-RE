package com.google.android.libraries.navigation.internal.ti;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class af {
    public int a;
    public int b;

    public af() {
        this.a = 0;
        this.b = -1;
    }

    private af(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final af clone() {
        return new af(this.a, this.b);
    }

    public final af b(boolean z) {
        return z ? new af(this.a + 1, 0) : new af(this.a, this.b + 1);
    }

    final void c(af afVar) {
        this.a = afVar.a;
        this.b = afVar.b;
    }

    public final String toString() {
        return "(" + this.a + ", " + this.b + ")";
    }
}
