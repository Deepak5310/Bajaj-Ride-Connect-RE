package com.google.android.libraries.navigation.internal.agh;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hn implements hl {
    final long[] a;
    final int b;
    private final int c;
    private final int d;
    private int e;

    public hn(long[] jArr, int i, int i2, int i3) {
        this.a = jArr;
        this.c = i;
        this.d = i2;
        this.b = i3 | 16720;
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aP */
    public final hl trySplit() {
        int i = this.d;
        int i2 = this.e;
        int i3 = (i - i2) >> 1;
        if (i3 <= 1) {
            return null;
        }
        int i4 = this.c + i2;
        this.e = i2 + i3;
        return new hn(this.a, i4, i3, this.b);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hl
    public final /* synthetic */ gk d() {
        return hk.d();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return this.d - this.e;
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        hk.b(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final void forEachRemaining(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        while (true) {
            int i = this.e;
            if (i >= this.d) {
                return;
            }
            longConsumer.accept(this.a[this.c + i]);
            this.e++;
        }
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return d();
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return hk.c(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final boolean tryAdvance(LongConsumer longConsumer) {
        if (this.e >= this.d) {
            return false;
        }
        Objects.requireNonNull(longConsumer);
        long[] jArr = this.a;
        int i = this.c;
        int i2 = this.e;
        this.e = i2 + 1;
        longConsumer.accept(jArr[i + i2]);
        return true;
    }
}
