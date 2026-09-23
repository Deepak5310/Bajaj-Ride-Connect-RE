package com.google.android.libraries.navigation.internal.agi;

import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class hk extends w {
    protected int b;

    protected hk(int i) {
        this.b = i;
    }

    protected abstract hj a(int i, int i2);

    @Override // com.google.android.libraries.navigation.internal.agi.w, java.util.Spliterator
    /* JADX INFO: renamed from: b */
    public hj trySplit() {
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
        hj hjVarA = a(i2, i3);
        this.b = i3;
        return hjVarA;
    }

    protected abstract Object c(int i);

    @Override // java.util.Spliterator
    public int characteristics() {
        return 16464;
    }

    protected abstract int e();

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return ((long) e()) - ((long) this.b);
    }

    @Override // java.util.Spliterator
    public void forEachRemaining(Consumer consumer) {
        int iE = e();
        while (true) {
            int i = this.b;
            if (i >= iE) {
                return;
            }
            consumer.accept(c(i));
            this.b++;
        }
    }

    @Override // java.util.Spliterator
    public boolean tryAdvance(Consumer consumer) {
        if (this.b >= e()) {
            return false;
        }
        int i = this.b;
        this.b = i + 1;
        consumer.accept(c(i));
        return true;
    }
}
