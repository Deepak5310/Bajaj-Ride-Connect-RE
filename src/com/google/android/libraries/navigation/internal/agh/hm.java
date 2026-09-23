package com.google.android.libraries.navigation.internal.agh;

import java.util.function.LongConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class hm extends x {
    protected int b;

    protected hm(int i) {
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.x, java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aP, reason: merged with bridge method [inline-methods] */
    public hl trySplit() {
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
        hl hlVarC = c(i2, i3);
        this.b = i3;
        return hlVarC;
    }

    protected abstract long b(int i);

    protected abstract hl c(int i, int i2);

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
    public void forEachRemaining(LongConsumer longConsumer) {
        int iE = e();
        while (true) {
            int i = this.b;
            if (i >= iE) {
                return;
            }
            longConsumer.accept(b(i));
            this.b++;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Spliterator.OfPrimitive
    public boolean tryAdvance(LongConsumer longConsumer) {
        if (this.b >= e()) {
            return false;
        }
        int i = this.b;
        this.b = i + 1;
        longConsumer.accept(b(i));
        return true;
    }
}
