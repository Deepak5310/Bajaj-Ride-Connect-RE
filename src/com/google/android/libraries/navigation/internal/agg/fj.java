package com.google.android.libraries.navigation.internal.agg;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fj implements fh {
    final int[] a;
    final int b;
    private final int c;
    private final int d;
    private int e;

    public fj(int[] iArr, int i, int i2, int i3) {
        this.a = iArr;
        this.c = i;
        this.d = i2;
        this.b = i3 | 16720;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aM */
    public final fh trySplit() {
        int i = this.d;
        int i2 = this.e;
        int i3 = (i - i2) >> 1;
        if (i3 <= 1) {
            return null;
        }
        int i4 = this.c + i2;
        this.e = i2 + i3;
        return new fj(this.a, i4, i3, this.b);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fh
    public final /* synthetic */ void d() {
        fg.c();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return this.d - this.e;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        fg.a(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final void forEachRemaining(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        while (true) {
            int i = this.e;
            if (i >= this.d) {
                return;
            }
            intConsumer.accept(this.a[this.c + i]);
            this.e++;
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
        if (this.e >= this.d) {
            return false;
        }
        Objects.requireNonNull(intConsumer);
        int[] iArr = this.a;
        int i = this.c;
        int i2 = this.e;
        this.e = i2 + 1;
        intConsumer.accept(iArr[i + i2]);
        return true;
    }
}
