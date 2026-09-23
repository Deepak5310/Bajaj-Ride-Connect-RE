package com.google.android.libraries.navigation.internal.agh;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hr implements hl {
    final int a;
    private final gs b;
    private long c;
    private int d = 1024;
    private hl e = null;

    public hr(gs gsVar, long j, int i) {
        this.b = gsVar;
        this.c = j;
        this.a = ((i & 4096) != 0 ? 256 : 16704) | i;
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aP */
    public final hl trySplit() {
        if (!this.b.hasNext()) {
            return null;
        }
        long j = this.c;
        int iMin = j > 0 ? (int) Math.min(this.d, j) : this.d;
        long[] jArrCopyOf = new long[iMin];
        int i = 0;
        while (i < iMin && this.b.hasNext()) {
            jArrCopyOf[i] = this.b.nextLong();
            this.c--;
            i++;
        }
        if (iMin < this.d && this.b.hasNext()) {
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, this.d);
            while (this.b.hasNext() && i < this.d) {
                jArrCopyOf[i] = this.b.nextLong();
                this.c--;
                i++;
            }
        }
        this.d = Math.min(33554432, this.d + 1024);
        int i2 = this.a;
        fz.a(jArrCopyOf, 0, i);
        hn hnVar = new hn(jArrCopyOf, 0, i, i2);
        if (this.b.hasNext()) {
            return hnVar;
        }
        this.e = hnVar;
        return hnVar.trySplit();
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hl
    public final /* synthetic */ gk d() {
        return hk.d();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        hl hlVar = this.e;
        if (hlVar != null) {
            return hlVar.estimateSize();
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

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        hk.b(this, consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final void forEachRemaining(LongConsumer longConsumer) {
        hl hlVar = this.e;
        if (hlVar != null) {
            hlVar.forEachRemaining(longConsumer);
            this.e = null;
        }
        this.b.forEachRemaining(longConsumer);
        this.c = 0L;
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
        hl hlVar = this.e;
        if (hlVar != null) {
            boolean zTryAdvance = hlVar.tryAdvance(longConsumer);
            if (!zTryAdvance) {
                this.e = null;
            }
            return zTryAdvance;
        }
        if (!this.b.hasNext()) {
            return false;
        }
        this.c--;
        longConsumer.accept(this.b.nextLong());
        return true;
    }
}
