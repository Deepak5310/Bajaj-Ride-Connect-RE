package com.google.android.libraries.navigation.internal.agh;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fr implements hl {
    boolean a;
    int b;
    int c;
    final /* synthetic */ fv d;

    public fr(fv fvVar) {
        this(fvVar, 0, fvVar.b, false);
    }

    private fr(fv fvVar, int i, int i2, boolean z) {
        this.d = fvVar;
        this.b = i;
        this.c = i2;
        this.a = z;
    }

    private final int a() {
        return this.a ? this.c : this.d.b;
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aP */
    public final hl trySplit() {
        int iA = a();
        int i = this.b;
        int i2 = (iA - i) >> 1;
        if (i2 <= 1) {
            return null;
        }
        this.c = iA;
        int i3 = i2 + i;
        this.b = i3;
        this.a = true;
        return new fr(this.d, i, i3, true);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16720;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hl
    public final /* synthetic */ gk d() {
        return hk.d();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return a() - this.b;
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        hk.b(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final void forEachRemaining(LongConsumer longConsumer) {
        int iA = a();
        while (true) {
            int i = this.b;
            if (i >= iA) {
                return;
            }
            longConsumer.accept(this.d.a[i]);
            this.b++;
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
        int i = this.b;
        if (i >= a()) {
            return false;
        }
        long[] jArr = this.d.a;
        this.b = i + 1;
        longConsumer.accept(jArr[i]);
        return true;
    }
}
