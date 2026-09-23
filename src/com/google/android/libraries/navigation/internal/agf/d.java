package com.google.android.libraries.navigation.internal.agf;

import java.util.Comparator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements ao {
    boolean a;
    int b;
    int c;
    final /* synthetic */ e d;

    public d(e eVar) {
        this(eVar, 0, eVar.b, false);
    }

    private d(e eVar, int i, int i2, boolean z) {
        this.d = eVar;
        this.b = i;
        this.c = i2;
        this.a = z;
    }

    private final int c() {
        return this.a ? this.c : this.d.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.ao
    public final /* synthetic */ o a() {
        return an.d();
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final ao trySplit() {
        int iC = c();
        int i = this.b;
        int i2 = (iC - i) >> 1;
        if (i2 <= 1) {
            return null;
        }
        this.c = iC;
        int i3 = i2 + i;
        this.b = i3;
        this.a = true;
        return new d(this.d, i, i3, true);
    }

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16721;
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return c() - this.b;
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        s sVar = (s) obj;
        int iC = c();
        while (true) {
            int i = this.b;
            if (i >= iC) {
                return;
            }
            sVar.c(this.d.a[i]);
            this.b++;
        }
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        an.b(this, consumer);
    }

    @Override // java.util.Spliterator
    public final /* bridge */ /* synthetic */ Comparator getComparator() {
        return a();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        s sVar = (s) obj;
        int i = this.b;
        if (i >= c()) {
            return false;
        }
        float[] fArr = this.d.a;
        this.b = i + 1;
        sVar.c(fArr[i]);
        return true;
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return an.c(this, consumer);
    }
}
