package com.google.android.libraries.navigation.internal.agg;

import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class fi extends r {
    protected int b;

    protected fi(int i) {
        this.b = i;
    }

    protected abstract int a(int i);

    @Override // com.google.android.libraries.navigation.internal.agg.r, java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aM, reason: merged with bridge method [inline-methods] */
    public fh trySplit() {
        int iE = e();
        int i = this.b;
        int iE2 = e();
        int i2 = this.b;
        int i3 = ((iE2 - i2) / 2) + i;
        if (i3 == i2 || i3 == iE) {
            return null;
        }
        if (i3 < i2 || i3 > iE) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.m(iE, i2, i3, "splitPoint ", " outside of range of current position ", " and range end "));
        }
        fh fhVarC = c(i2, i3);
        this.b = i3;
        return fhVarC;
    }

    protected abstract fh c(int i, int i2);

    @Override // java.util.Spliterator
    public int characteristics() {
        return 16720;
    }

    protected abstract int e();

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return ((long) e()) - ((long) this.b);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Spliterator.OfPrimitive
    public void forEachRemaining(IntConsumer intConsumer) {
        int iE = e();
        while (true) {
            int i = this.b;
            if (i >= iE) {
                return;
            }
            intConsumer.accept(a(i));
            this.b++;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Spliterator.OfPrimitive
    public boolean tryAdvance(IntConsumer intConsumer) {
        if (this.b >= e()) {
            return false;
        }
        int i = this.b;
        this.b = i + 1;
        intConsumer.accept(a(i));
        return true;
    }
}
