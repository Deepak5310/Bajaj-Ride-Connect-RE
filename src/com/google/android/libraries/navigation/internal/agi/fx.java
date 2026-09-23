package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fx extends ho {
    final /* synthetic */ fy a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fx(fy fyVar) {
        super(fyVar.b);
        this.a = fyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final /* bridge */ /* synthetic */ hj a(int i, int i2) {
        return new fx(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk
    protected final Object c(int i) {
        return this.a.d.a[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agi.ho
    protected final int d() {
        return this.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk, java.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        int iE = e();
        while (true) {
            int i = this.b;
            if (i >= iE) {
                return;
            }
            Object[] objArr = this.a.d.a;
            this.b = i + 1;
            consumer.accept(objArr[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hk, java.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        if (this.b >= e()) {
            return false;
        }
        Object[] objArr = this.a.d.a;
        int i = this.b;
        this.b = i + 1;
        consumer.accept(objArr[i]);
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private fx(fy fyVar, int i, int i2) {
        super(i, i2);
        this.a = fyVar;
    }
}
