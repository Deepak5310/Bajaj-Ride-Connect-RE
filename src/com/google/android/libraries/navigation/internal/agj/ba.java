package com.google.android.libraries.navigation.internal.agj;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ba implements ay {
    final short[] a;
    private final int b;
    private final int c;
    private int d;

    public ba(short[] sArr, int i, int i2) {
        this.a = sArr;
        this.b = i;
        this.c = i2;
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aV */
    public final ay trySplit() {
        int i = this.c;
        int i2 = this.d;
        int i3 = (i - i2) >> 1;
        if (i3 <= 1) {
            return null;
        }
        int i4 = this.b + i2;
        this.d = i2 + i3;
        return new ba(this.a, i4, i3);
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
        return this.c - this.d;
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        ag agVar = (ag) obj;
        Objects.requireNonNull(agVar);
        while (true) {
            int i = this.d;
            if (i >= this.c) {
                return;
            }
            agVar.d(this.a[this.b + i]);
            this.d++;
        }
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
        if (this.d >= this.c) {
            return false;
        }
        Objects.requireNonNull(agVar);
        short[] sArr = this.a;
        int i = this.b;
        int i2 = this.d;
        this.d = i2 + 1;
        agVar.d(sArr[i + i2]);
        return true;
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return ax.c(this, consumer);
    }
}
