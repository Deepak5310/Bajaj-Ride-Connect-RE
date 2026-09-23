package com.google.android.libraries.navigation.internal.age;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements aa {
    boolean a;
    int b;
    int c;
    final /* synthetic */ f d;

    public e(f fVar) {
        this(fVar, 0, fVar.b, false);
    }

    private e(f fVar, int i, int i2, boolean z) {
        this.d = fVar;
        this.b = i;
        this.c = i2;
        this.a = z;
    }

    private final int c() {
        return this.a ? this.c : this.d.b;
    }

    @Override // com.google.android.libraries.navigation.internal.age.aa
    public final /* synthetic */ n a() {
        return z.d();
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: b */
    public final aa trySplit() {
        int iC = c();
        int i = this.b;
        int i2 = (iC - i) >> 1;
        if (i2 <= 1) {
            return null;
        }
        this.c = iC;
        int i3 = i2 + i;
        this.b = i3;
        this.a = true;
        return new e(this.d, i, i3, true);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16721;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return c() - this.b;
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        z.b(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        int iC = c();
        while (true) {
            int i = this.b;
            if (i >= iC) {
                return;
            }
            doubleConsumer.accept(this.d.a[i]);
            this.b++;
        }
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return a();
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return z.c(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        int i = this.b;
        if (i >= c()) {
            return false;
        }
        double[] dArr = this.d.a;
        this.b = i + 1;
        doubleConsumer.accept(dArr[i]);
        return true;
    }
}
