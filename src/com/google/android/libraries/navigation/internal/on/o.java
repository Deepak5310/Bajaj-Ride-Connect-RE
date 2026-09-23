package com.google.android.libraries.navigation.internal.on;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o extends p {
    final /* synthetic */ q a;
    private final Bitmap c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(q qVar, Bitmap bitmap) {
        super(qVar, qVar.a.c(bitmap));
        this.a = qVar;
        this.c = bitmap;
    }

    @Override // com.google.android.libraries.navigation.internal.on.p
    protected final void c() {
        if (this.c.isMutable()) {
            return;
        }
        synchronized (this.a) {
            this.a.b.remove(this.c);
        }
    }
}
