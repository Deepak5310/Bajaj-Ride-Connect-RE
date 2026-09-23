package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bx extends cf implements gi {
    final /* synthetic */ cj a;
    private cd h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bx(cj cjVar) {
        super(cjVar);
        this.a = cjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.cf
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        cd cdVar = new cd(this.a, i);
        this.h = cdVar;
        ((Consumer) obj).accept(cdVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.forEachRemaining((Object) consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        cd cdVar = new cd(this.a, b());
        this.h = cdVar;
        return cdVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.cf, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
