package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cj extends cr implements com.google.android.libraries.navigation.internal.agi.gi {
    final /* synthetic */ cv a;
    private cp h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cj(cv cvVar) {
        super(cvVar);
        this.a = cvVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.cr
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        cp cpVar = new cp(this.a, i);
        this.h = cpVar;
        ((Consumer) obj).accept(cpVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        cp cpVar = new cp(this.a, b());
        this.h = cpVar;
        return cpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.cr, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
