package com.google.android.libraries.navigation.internal.agh;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hc implements hl {
    int a;
    final int b;
    int c;
    boolean d;
    boolean e;
    final /* synthetic */ hd f;

    public hc(hd hdVar) {
        this.f = hdVar;
        this.a = 0;
        this.b = hdVar.d;
        this.c = 0;
        this.d = hdVar.c;
        this.e = false;
    }

    public hc(hd hdVar, int i, int i2, boolean z) {
        this.f = hdVar;
        this.c = 0;
        this.a = i;
        this.b = i2;
        this.d = z;
        this.e = true;
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final hc trySplit() {
        int i;
        int i2 = this.b;
        int i3 = this.a;
        if (i3 >= i2 - 1 || (i = (i2 - i3) >> 1) <= 1) {
            return null;
        }
        int i4 = i + i3;
        hc hcVar = new hc(this.f, i3, i4, this.d);
        this.a = i4;
        this.d = false;
        this.e = true;
        return hcVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hl
    /* JADX INFO: renamed from: aP */
    public final /* bridge */ /* synthetic */ hl trySplit() {
        throw null;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.e ? 257 : 321;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.hl
    public final /* synthetic */ gk d() {
        return hk.d();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        if (!this.e) {
            return this.f.g - this.c;
        }
        hd hdVar = this.f;
        return Math.min(hdVar.g - this.c, ((long) ((((double) hdVar.m()) / ((double) this.f.d)) * ((double) (this.b - this.a)))) + (this.d ? 1L : 0L));
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        hk.b(this, consumer);
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
        if (this.d) {
            this.d = false;
            this.c++;
            hd hdVar = this.f;
            longConsumer.accept(hdVar.a[hdVar.d]);
            return true;
        }
        long[] jArr = this.f.a;
        while (true) {
            int i = this.a;
            if (i >= this.b) {
                return false;
            }
            int i2 = i + 1;
            long j = jArr[i];
            if (j != 0) {
                this.c++;
                this.a = i2;
                longConsumer.accept(j);
                return true;
            }
            this.a = i2;
        }
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final void forEachRemaining(LongConsumer longConsumer) {
        hd hdVar = this.f;
        long[] jArr = hdVar.a;
        if (this.d) {
            this.d = false;
            longConsumer.accept(jArr[hdVar.d]);
            this.c++;
        }
        while (true) {
            int i = this.a;
            if (i >= this.b) {
                return;
            }
            long j = jArr[i];
            if (j != 0) {
                longConsumer.accept(j);
                this.c++;
            }
            this.a++;
        }
    }
}
