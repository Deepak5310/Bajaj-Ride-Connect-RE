package com.google.android.libraries.navigation.internal.sk;

import android.os.Vibrator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class em implements c {
    private final Vibrator a;
    private final long[] b;

    public em(Vibrator vibrator, long[] jArr) {
        this.a = vibrator;
        this.b = jArr;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final long a() {
        return -1L;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final void b() {
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final void c(a aVar) {
        if (aVar != null) {
            aVar.b(this);
        }
        this.a.vibrate(this.b, -1);
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final boolean d() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final int e() {
        return b.d;
    }
}
