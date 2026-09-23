package com.google.android.libraries.navigation.internal.sk;

import android.os.Handler;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class by implements c {
    private final long a;

    public by(long j) {
        this.a = j;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final long a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final void b() {
    }

    @Override // com.google.android.libraries.navigation.internal.sk.c
    public final void c(final a aVar) {
        if (aVar != null) {
            aVar.b(this);
            new Handler().postDelayed(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.bx
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a(this.a);
                }
            }, this.a);
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
