package com.google.android.libraries.navigation.internal.fq;

import com.google.android.libraries.navigation.internal.km.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    protected Boolean a = false;
    protected final com.google.android.libraries.navigation.internal.kl.a b;
    private final int c;
    private final int d;
    private final x e;
    private final x f;

    public a(com.google.android.libraries.navigation.internal.kl.a aVar, int i, int i2, x xVar, x xVar2) {
        this.b = aVar;
        this.c = i;
        this.d = i2;
        this.e = xVar;
        this.f = xVar2;
    }

    public final synchronized void a() {
        if (!this.a.booleanValue()) {
            this.a = true;
        }
        this.b.e(this.e, this.c);
        this.b.e(this.e, this.d);
    }

    public final synchronized void b() {
        if (this.a.booleanValue()) {
            this.b.e(this.f, this.c);
            this.b.e(this.f, this.d);
        }
    }
}
