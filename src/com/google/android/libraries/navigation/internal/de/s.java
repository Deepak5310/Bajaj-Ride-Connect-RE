package com.google.android.libraries.navigation.internal.de;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class s {
    private long a = Long.MIN_VALUE;
    private float b;
    private float c;

    public final boolean a(long j, float f, float f2, com.google.android.libraries.navigation.internal.cw.n nVar) {
        boolean z = true;
        if (this.a != Long.MIN_VALUE) {
            if ((f2 == -1000.0f) == (this.c == -1000.0f)) {
                if ((f == -1.0f) == (this.b == -1.0f)) {
                    com.google.android.libraries.navigation.internal.cw.n nVar2 = com.google.android.libraries.navigation.internal.cw.n.UPDATE_FREQUENCY_NONE;
                    float f3 = nVar.ordinal() != 2 ? 2.0f : 0.2f;
                    float fAbs = Math.abs(com.google.android.libraries.navigation.internal.nq.a.e(f - this.b));
                    float fAbs2 = Math.abs(f2 - this.c);
                    if (fAbs <= f3 && fAbs2 <= f3) {
                        z = false;
                    }
                }
            }
        }
        if (z) {
            this.a = j;
            this.b = f;
            this.c = f2;
        }
        return z;
    }
}
