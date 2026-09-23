package com.google.android.libraries.navigation.internal.yz;

import java.lang.ref.ReferenceQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class je extends ic implements jg {
    public volatile jh b;

    public je(ReferenceQueue referenceQueue, Object obj, int i) {
        super(referenceQueue, obj, i);
        this.b = jk.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ih
    public final Object d() {
        return this.b.get();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.jg
    public final jh e() {
        return this.b;
    }
}
