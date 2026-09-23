package com.google.android.libraries.navigation.internal.agi;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class hq implements hj {
    final int a;
    private final gi b;
    private long c;
    private int d = 1024;
    private hj e = null;

    public hq(gi giVar, long j, int i) {
        this.b = giVar;
        this.c = j;
        if ((i & 4096) != 0) {
            this.a = i;
        } else {
            this.a = i | 16448;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hj
    /* JADX INFO: renamed from: b */
    public final hj trySplit() {
        throw null;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.a;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        hj hjVar = this.e;
        if (hjVar != null) {
            return hjVar.estimateSize();
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

    @Override // java.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        hj hjVar = this.e;
        if (hjVar != null) {
            hjVar.forEachRemaining(consumer);
            this.e = null;
        }
        this.b.forEachRemaining(consumer);
        this.c = 0L;
    }

    @Override // java.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        hj hjVar = this.e;
        if (hjVar != null) {
            boolean zTryAdvance = hjVar.tryAdvance(consumer);
            if (!zTryAdvance) {
                this.e = null;
            }
            return zTryAdvance;
        }
        if (!this.b.hasNext()) {
            return false;
        }
        this.c--;
        consumer.accept(this.b.next());
        return true;
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        if (!this.b.hasNext()) {
            return null;
        }
        long j = this.c;
        int iMin = j > 0 ? (int) Math.min(this.d, j) : this.d;
        Object[] objArrCopyOf = new Object[iMin];
        int i = 0;
        while (i < iMin && this.b.hasNext()) {
            objArrCopyOf[i] = this.b.next();
            this.c--;
            i++;
        }
        if (iMin < this.d && this.b.hasNext()) {
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, this.d);
            while (this.b.hasNext() && i < this.d) {
                objArrCopyOf[i] = this.b.next();
                this.c--;
                i++;
            }
        }
        this.d = Math.min(33554432, this.d + 1024);
        int i2 = this.a;
        gd.a(objArrCopyOf, 0, i);
        hl hlVar = new hl(objArrCopyOf, 0, i, i2);
        if (this.b.hasNext()) {
            return hlVar;
        }
        this.e = hlVar;
        return hlVar.trySplit();
    }
}
