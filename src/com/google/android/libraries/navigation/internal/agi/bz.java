package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bz extends cf implements gi {
    final /* synthetic */ cj a;
    private final cd h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(cj cjVar) {
        super(cjVar);
        this.a = cjVar;
        this.h = new cd(cjVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.cf
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        cd cdVar = this.h;
        cdVar.a = i;
        ((Consumer) obj).accept(cdVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        cd cdVar = this.h;
        cdVar.a = b();
        return cdVar;
    }
}
