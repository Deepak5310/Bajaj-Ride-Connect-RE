package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bg extends be implements com.google.android.libraries.navigation.internal.agf.v {
    final /* synthetic */ bi a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bi biVar) {
        super(biVar);
        this.a = biVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.v
    public final float a() {
        return this.a.b[d()];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.be
    public final /* bridge */ /* synthetic */ void aS(Object obj, int i) {
        ((com.google.android.libraries.navigation.internal.agf.s) obj).c(this.a.b[i]);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.v
    public final /* synthetic */ Float b() {
        return com.google.android.libraries.navigation.internal.agf.u.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.v
    /* JADX INFO: renamed from: c */
    public final /* bridge */ /* synthetic */ void forEachRemaining(com.google.android.libraries.navigation.internal.agf.s sVar) {
        super.forEachRemaining((Object) sVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.v, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        com.google.android.libraries.navigation.internal.agf.u.e(this, consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return b();
    }
}
