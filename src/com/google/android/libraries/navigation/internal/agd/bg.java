package com.google.android.libraries.navigation.internal.agd;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bg implements be {
    final byte[] a;
    private final int b;
    private final int c;
    private int d;

    public bg(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aL */
    public final be trySplit() {
        int i = this.c;
        int i2 = this.d;
        int i3 = (i - i2) >> 1;
        if (i3 <= 1) {
            return null;
        }
        int i4 = this.b + i2;
        this.d = i2 + i3;
        return new bg(this.a, i4, i3);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16720;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.be
    public final /* synthetic */ z d() {
        return bd.d();
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return this.c - this.d;
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        ai aiVar = (ai) obj;
        Objects.requireNonNull(aiVar);
        while (true) {
            int i = this.d;
            if (i >= this.c) {
                return;
            }
            aiVar.c(this.a[this.b + i]);
            this.d++;
        }
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        bd.b(this, consumer);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return d();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        ai aiVar = (ai) obj;
        if (this.d >= this.c) {
            return false;
        }
        Objects.requireNonNull(aiVar);
        byte[] bArr = this.a;
        int i = this.b;
        int i2 = this.d;
        this.d = i2 + 1;
        aiVar.c(bArr[i + i2]);
        return true;
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return bd.c(this, consumer);
    }
}
