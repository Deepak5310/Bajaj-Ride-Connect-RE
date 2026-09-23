package com.google.android.libraries.navigation.internal.agg;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fo implements fh {
    final int a;
    private final ei b;
    private long c;
    private int d = 1024;
    private fh e = null;

    public fo(ei eiVar, long j, int i) {
        this.b = eiVar;
        this.c = j;
        this.a = ((i & 4096) != 0 ? 256 : 16704) | i;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aM */
    public final fh trySplit() {
        if (!this.b.hasNext()) {
            return null;
        }
        long j = this.c;
        int iMin = j > 0 ? (int) Math.min(this.d, j) : this.d;
        int[] iArrCopyOf = new int[iMin];
        int i = 0;
        while (i < iMin && this.b.hasNext()) {
            iArrCopyOf[i] = this.b.nextInt();
            this.c--;
            i++;
        }
        if (iMin < this.d && this.b.hasNext()) {
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, this.d);
            while (this.b.hasNext() && i < this.d) {
                iArrCopyOf[i] = this.b.nextInt();
                this.c--;
                i++;
            }
        }
        this.d = Math.min(33554432, this.d + 1024);
        int i2 = this.a;
        di.a(iArrCopyOf, 0, i);
        fj fjVar = new fj(iArrCopyOf, 0, i, i2);
        if (this.b.hasNext()) {
            return fjVar;
        }
        this.e = fjVar;
        return fjVar.trySplit();
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fh
    public final /* synthetic */ void d() {
        fg.c();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        fh fhVar = this.e;
        if (fhVar != null) {
            return fhVar.estimateSize();
        }
        if (!this.b.hasNext()) {
            return 0L;
        }
        long j = this.c;
        if (j >= 0) {
            return j;
        }
        return Long.MAX_VALUE;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        fg.a(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final void forEachRemaining(IntConsumer intConsumer) {
        fh fhVar = this.e;
        if (fhVar != null) {
            fhVar.forEachRemaining(intConsumer);
            this.e = null;
        }
        this.b.forEachRemaining(intConsumer);
        this.c = 0L;
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
        fh fhVar = this.e;
        if (fhVar != null) {
            boolean zTryAdvance = fhVar.tryAdvance(intConsumer);
            if (!zTryAdvance) {
                this.e = null;
            }
            return zTryAdvance;
        }
        if (!this.b.hasNext()) {
            return false;
        }
        this.c--;
        intConsumer.accept(this.b.nextInt());
        return true;
    }
}
