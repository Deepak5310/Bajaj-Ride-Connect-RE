package com.google.android.libraries.navigation.internal.adh;

import com.google.android.libraries.navigation.internal.ael.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends k {
    public final ar a;
    public final d b = new d(2);
    public final f c = new f();

    public a(ar arVar) {
        this.a = arVar;
    }

    public final int a() {
        return this.c.b;
    }

    @Override // com.google.android.libraries.navigation.internal.adh.k
    public final void b() {
        super.b();
        this.b.c();
        this.c.c();
    }

    @Override // com.google.android.libraries.navigation.internal.adh.k
    protected final void c(int i, int i2, int i3) {
        if (i == 1) {
            this.c.f(i2, i3);
        } else if (i == 2) {
            this.b.d(0, i2, i3);
        } else {
            if (i != 3) {
                return;
            }
            this.b.d(1, i2, i3);
        }
    }
}
