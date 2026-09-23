package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ig extends im implements gi {
    final /* synthetic */ iq a;
    private final ik h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ig(iq iqVar) {
        super(iqVar);
        this.a = iqVar;
        this.h = new ik(iqVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.im
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        ik ikVar = this.h;
        ikVar.a = i;
        ((Consumer) obj).accept(ikVar);
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final ik next() {
        ik ikVar = this.h;
        ikVar.a = c();
        return ikVar;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }
}
