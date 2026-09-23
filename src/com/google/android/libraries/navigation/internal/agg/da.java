package com.google.android.libraries.navigation.internal.agg;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class da implements fh {
    boolean a;
    int b;
    int c;
    final /* synthetic */ de d;

    public da(de deVar) {
        this(deVar, 0, deVar.b, false);
    }

    private da(de deVar, int i, int i2, boolean z) {
        this.d = deVar;
        this.b = i;
        this.c = i2;
        this.a = z;
    }

    private final int a() {
        return this.a ? this.c : this.d.b;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aM */
    public final fh trySplit() {
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
        return new da(this.d, i, i3, true);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16720;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fh
    public final /* synthetic */ void d() {
        fg.c();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return a() - this.b;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        fg.a(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final void forEachRemaining(IntConsumer intConsumer) {
        int iA = a();
        while (true) {
            int i = this.b;
            if (i >= iA) {
                return;
            }
            intConsumer.accept(this.d.a[i]);
            this.b++;
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
        int i = this.b;
        if (i >= a()) {
            return false;
        }
        int[] iArr = this.d.a;
        this.b = i + 1;
        intConsumer.accept(iArr[i]);
        return true;
    }
}
