package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cp extends hm implements hj {
    final /* synthetic */ cq a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp(cq cqVar, int i, int i2) {
        super(i, i2);
        this.a = cqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final /* bridge */ /* synthetic */ hj a(int i, int i2) {
        return new cp(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final Object c(int i) {
        return this.a.a.b[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk, java.util.Spliterator
    public final int characteristics() {
        return 16465;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk, java.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        int i = this.a.a.d;
        while (true) {
            int i2 = this.b;
            if (i2 >= i) {
                return;
            }
            Object[] objArr = this.a.a.b;
            this.b = i2 + 1;
            consumer.accept(objArr[i2]);
        }
    }
}
