package com.google.android.libraries.navigation.internal.agj;

import java.util.Comparator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k implements ay {
    boolean a;
    int b;
    int c;
    final /* synthetic */ o d;

    public k(o oVar) {
        this(oVar, 0, oVar.b, false);
    }

    private k(o oVar, int i, int i2, boolean z) {
        this.d = oVar;
        this.b = i;
        this.c = i2;
        this.a = z;
    }

    private final int b() {
        return this.a ? this.c : this.d.b;
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aV */
    public final ay trySplit() {
        int iB = b();
        int i = this.b;
        int i2 = (iB - i) >> 1;
        if (i2 <= 1) {
            return null;
        }
        this.c = iB;
        int i3 = i2 + i;
        this.b = i3;
        this.a = true;
        return new k(this.d, i, i3, true);
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
        return b() - this.b;
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        ag agVar = (ag) obj;
        int iB = b();
        while (true) {
            int i = this.b;
            if (i >= iB) {
                return;
            }
            agVar.d(this.d.a[i]);
            this.b++;
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
        int i = this.b;
        if (i >= b()) {
            return false;
        }
        short[] sArr = this.d.a;
        this.b = i + 1;
        agVar.d(sArr[i]);
        return true;
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return ax.c(this, consumer);
    }
}
