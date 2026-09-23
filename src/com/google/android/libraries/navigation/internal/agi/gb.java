package com.google.android.libraries.navigation.internal.agi;

import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gb implements hj {
    boolean a;
    int b;
    int c;
    final /* synthetic */ gc d;

    public gb(gc gcVar) {
        this(gcVar, 0, gcVar.b, false);
    }

    private gb(gc gcVar, int i, int i2, boolean z) {
        this.d = gcVar;
        this.b = i;
        this.c = i2;
        this.a = z;
    }

    private final int a() {
        return this.a ? this.c : this.d.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.hj
    /* JADX INFO: renamed from: b */
    public final hj trySplit() {
        throw null;
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16465;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return a() - this.b;
    }

    @Override // java.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        int iA = a();
        while (true) {
            int i = this.b;
            if (i >= iA) {
                return;
            }
            consumer.accept(this.d.a[i]);
            this.b++;
        }
    }

    @Override // java.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        int i = this.b;
        if (i >= a()) {
            return false;
        }
        Object[] objArr = this.d.a;
        this.b = i + 1;
        consumer.accept(objArr[i]);
        return true;
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Spliterator trySplit() {
        int iA = a();
        int i = this.b;
        int i2 = (iA - i) >> 1;
        if (i2 <= 1) {
            return null;
        }
        this.c = iA;
        int i3 = i2 + i;
        this.b = i3;
        this.a = true;
        return new gb(this.d, i, i3, true);
    }
}
