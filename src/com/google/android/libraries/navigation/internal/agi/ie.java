package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ie extends im implements gi {
    final /* synthetic */ iq a;
    private ik h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ie(iq iqVar) {
        super(iqVar);
        this.a = iqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.im
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        ik ikVar = new ik(this.a, i);
        this.h = ikVar;
        ((Consumer) obj).accept(ikVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        ik ikVar = new ik(this.a, c());
        this.h = ikVar;
        return ikVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.im, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
