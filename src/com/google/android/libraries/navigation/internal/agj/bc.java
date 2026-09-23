package com.google.android.libraries.navigation.internal.agj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bc implements ay {
    private final aj a;
    private long b;
    private int c = 1024;
    private ay d = null;

    public bc(aj ajVar, long j) {
        this.a = ajVar;
        this.b = j;
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aV */
    public final ay trySplit() {
        if (!this.a.hasNext()) {
            return null;
        }
        long j = this.b;
        int iMin = j > 0 ? (int) Math.min(this.c, j) : this.c;
        short[] sArrCopyOf = new short[iMin];
        int i = 0;
        while (i < iMin && this.a.hasNext()) {
            sArrCopyOf[i] = this.a.d();
            this.b--;
            i++;
        }
        if (iMin < this.c && this.a.hasNext()) {
            sArrCopyOf = Arrays.copyOf(sArrCopyOf, this.c);
            while (this.a.hasNext() && i < this.c) {
                sArrCopyOf[i] = this.a.d();
                this.b--;
                i++;
            }
        }
        this.c = Math.min(33554432, this.c + 1024);
        p.a(sArrCopyOf, 0, i);
        ba baVar = new ba(sArrCopyOf, 0, i);
        if (this.a.hasNext()) {
            return baVar;
        }
        this.d = baVar;
        return baVar.trySplit();
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16720;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ay
    public final /* synthetic */ x d() {
        return ax.d();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        ay ayVar = this.d;
        if (ayVar != null) {
            return ayVar.estimateSize();
        }
        if (!this.a.hasNext()) {
            return 0L;
        }
        long j = this.b;
        if (j >= 0) {
            return j;
        }
        return Long.MAX_VALUE;
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        ag agVar = (ag) obj;
        ay ayVar = this.d;
        if (ayVar != null) {
            ayVar.forEachRemaining(agVar);
            this.d = null;
        }
        this.a.b(agVar);
        this.b = 0L;
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        ax.b(this, consumer);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return d();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        ag agVar = (ag) obj;
        ay ayVar = this.d;
        if (ayVar != null) {
            boolean zTryAdvance = ayVar.tryAdvance(agVar);
            if (zTryAdvance) {
                return zTryAdvance;
            }
            this.d = null;
            return zTryAdvance;
        }
        if (!this.a.hasNext()) {
            return false;
        }
        this.b--;
        agVar.d(this.a.d());
        return true;
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return ax.c(this, consumer);
    }
}
