package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class jd extends jj implements gi {
    final /* synthetic */ jn a;
    private final jh h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jd(jn jnVar) {
        super(jnVar);
        this.a = jnVar;
        this.h = new jh(jnVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.agi.jj
    public final /* bridge */ /* synthetic */ void a(Object obj, int i) {
        jh jhVar = this.h;
        jhVar.a = i;
        obj.accept(jhVar);
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final jh next() {
        jh jhVar = this.h;
        jhVar.a = c();
        return jhVar;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
        super.d(consumer);
    }
}
