package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class jb extends jj implements gi {
    final /* synthetic */ jn a;
    private jh h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jb(jn jnVar) {
        super(jnVar);
        this.a = jnVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agi.jj
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        jh jhVar = new jh(this.a, i);
        this.h = jhVar;
        obj.accept(jhVar);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.d(consumer);
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        jh jhVar = new jh(this.a, c());
        this.h = jhVar;
        return jhVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.jj, java.util.Iterator
    public final void remove() {
        super.remove();
        this.h.a = -1;
    }
}
