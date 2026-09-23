package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class de extends com.google.android.libraries.navigation.internal.agi.hm implements com.google.android.libraries.navigation.internal.agi.hj {
    final /* synthetic */ df a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public de(df dfVar, int i, int i2) {
        super(i, i2);
        this.a = dfVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.agi.hj a(int i, int i2) {
        return new de(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final Object c(int i) {
        return this.a.a.b[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk, java.util.Spliterator
    public final int characteristics() {
        return 16464;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk, java.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        int i = this.a.a.c;
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
