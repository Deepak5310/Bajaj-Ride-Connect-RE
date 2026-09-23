package com.google.android.libraries.navigation.internal.agg;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ex implements fh {
    int a;
    final int b;
    int c;
    boolean d;
    boolean e;
    final /* synthetic */ ey f;

    public ex(ey eyVar) {
        this.f = eyVar;
        this.a = 0;
        this.b = eyVar.d;
        this.c = 0;
        this.d = eyVar.c;
        this.e = false;
    }

    public ex(ey eyVar, int i, int i2, boolean z) {
        this.f = eyVar;
        this.c = 0;
        this.a = i;
        this.b = i2;
        this.d = z;
        this.e = true;
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final ex trySplit() {
        int i;
        int i2 = this.b;
        int i3 = this.a;
        if (i3 >= i2 - 1 || (i = (i2 - i3) >> 1) <= 1) {
            return null;
        }
        int i4 = i + i3;
        ex exVar = new ex(this.f, i3, i4, this.d);
        this.a = i4;
        this.d = false;
        this.e = true;
        return exVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fh
    /* JADX INFO: renamed from: aM */
    public final /* bridge */ /* synthetic */ fh trySplit() {
        throw null;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return this.e ? 257 : 321;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fh
    public final /* synthetic */ void d() {
        fg.c();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        if (!this.e) {
            return this.f.g - this.c;
        }
        ey eyVar = this.f;
        return Math.min(eyVar.g - this.c, ((long) ((((double) eyVar.n()) / ((double) this.f.d)) * ((double) (this.b - this.a)))) + (this.d ? 1L : 0L));
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        fg.a(this, consumer);
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
        if (this.d) {
            this.d = false;
            this.c++;
            ey eyVar = this.f;
            intConsumer.accept(eyVar.a[eyVar.d]);
            return true;
        }
        int[] iArr = this.f.a;
        while (true) {
            int i = this.a;
            if (i >= this.b) {
                return false;
            }
            int i2 = i + 1;
            int i3 = iArr[i];
            if (i3 != 0) {
                this.c++;
                this.a = i2;
                intConsumer.accept(i3);
                return true;
            }
            this.a = i2;
        }
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final void forEachRemaining(IntConsumer intConsumer) {
        ey eyVar = this.f;
        int[] iArr = eyVar.a;
        if (this.d) {
            this.d = false;
            intConsumer.accept(iArr[eyVar.d]);
            this.c++;
        }
        while (true) {
            int i = this.a;
            if (i >= this.b) {
                return;
            }
            int i2 = iArr[i];
            if (i2 != 0) {
                intConsumer.accept(i2);
                this.c++;
            }
            this.a++;
        }
    }
}
