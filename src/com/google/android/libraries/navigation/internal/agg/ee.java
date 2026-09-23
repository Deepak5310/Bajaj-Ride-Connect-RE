package com.google.android.libraries.navigation.internal.agg;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ee implements fh {
    int a;
    int b;
    final /* synthetic */ ef c;

    public ee(ef efVar) {
        this(efVar, 0, efVar.b.length);
    }

    private ee(ef efVar, int i, int i2) {
        this.c = efVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aM */
    public final fh trySplit() {
        int i = this.b;
        int i2 = this.a;
        int i3 = (i - i2) >> 1;
        if (i3 <= 1) {
            return null;
        }
        int i4 = i3 + i2;
        this.a = i4;
        return new ee(this.c, i2, i4);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 17744;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fh
    public final /* synthetic */ void d() {
        fg.c();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return this.b - this.a;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        fg.a(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final void forEachRemaining(IntConsumer intConsumer) {
        while (true) {
            int i = this.a;
            if (i >= this.b) {
                return;
            }
            intConsumer.accept(this.c.b[i]);
            this.a++;
        }
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        d();
        return null;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return fg.b(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final boolean tryAdvance(IntConsumer intConsumer) {
        int i = this.a;
        if (i >= this.b) {
            return false;
        }
        ef efVar = this.c;
        this.a = i + 1;
        intConsumer.accept(efVar.b[i]);
        return true;
    }
}
