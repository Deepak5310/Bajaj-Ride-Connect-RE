package com.google.android.libraries.navigation.internal.age;

import java.util.function.DoubleConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ab extends c {
    protected int a;

    protected ab(int i) {
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.age.c, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final aa trySplit() {
        int iD = d();
        int i = this.a;
        int iD2 = d();
        int i2 = this.a;
        int i3 = ((iD2 - i2) / 2) + i;
        if (i3 == i2 || i3 == iD) {
            return null;
        }
        if (i3 < i2 || i3 > iD) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.m(iD, i2, i3, "splitPoint ", " outside of range of current position ", " and range end "));
        }
        aa aaVarE = e(i2, i3);
        this.a = i3;
        return aaVarE;
    }

    protected abstract double c(int i);

    @Override // java.util.Spliterator
    public int characteristics() {
        return 16720;
    }

    protected abstract int d();

    protected abstract aa e(int i, int i2);

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return ((long) d()) - ((long) this.a);
    }

    @Override // java.util.Spliterator.OfPrimitive
    public void forEachRemaining(DoubleConsumer doubleConsumer) {
        int iD = d();
        while (true) {
            int i = this.a;
            if (i >= iD) {
                return;
            }
            doubleConsumer.accept(c(i));
            this.a++;
        }
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        if (this.a >= d()) {
            return false;
        }
        int i = this.a;
        this.a = i + 1;
        doubleConsumer.accept(c(i));
        return true;
    }
}
