package com.google.android.libraries.navigation.internal.yz;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class jf extends il {
    public final ReferenceQueue g;
    public final ReferenceQueue h;

    public jf(jk jkVar, int i) {
        super(jkVar, i);
        this.g = new ReferenceQueue();
        this.h = new ReferenceQueue();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.il
    public final /* bridge */ /* synthetic */ il d() {
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.il
    public final void h() {
        o(this.g);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.il
    public final void i() {
        f(this.g);
        g(this.h);
    }
}
