package com.google.android.libraries.navigation.internal.agi;

import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hl implements hj {
    final Object[] a;
    final int b;
    private final int c;
    private final int d;
    private int e;

    public hl(Object[] objArr, int i, int i2, int i3) {
        this.a = objArr;
        this.c = i;
        this.d = i2;
        this.b = i3 | 16464;
    }

    @Override // java.util.Spliterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final hj trySplit() {
        int i = this.d;
        int i2 = this.e;
        int i3 = (i - i2) >> 1;
        if (i3 <= 1) {
            return null;
        }
        int i4 = this.c + i2;
        this.e = i2 + i3;
        return new hl(this.a, i4, i3, this.b);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.b;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return this.d - this.e;
    }

    @Override // java.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        while (true) {
            int i = this.e;
            if (i >= this.d) {
                return;
            }
            consumer.accept(this.a[this.c + i]);
            this.e++;
        }
    }

    @Override // java.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        if (this.e >= this.d) {
            return false;
        }
        Objects.requireNonNull(consumer);
        Object[] objArr = this.a;
        int i = this.c;
        int i2 = this.e;
        this.e = i2 + 1;
        consumer.accept(objArr[i + i2]);
        return true;
    }
}
