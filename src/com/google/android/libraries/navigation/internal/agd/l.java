package com.google.android.libraries.navigation.internal.agd;

import java.util.Comparator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements be {
    boolean a;
    int b;
    int c;
    final /* synthetic */ p d;

    public l(p pVar) {
        this(pVar, 0, pVar.b, false);
    }

    private l(p pVar, int i, int i2, boolean z) {
        this.d = pVar;
        this.b = i;
        this.c = i2;
        this.a = z;
    }

    private final int b() {
        return this.a ? this.c : this.d.b;
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aL */
    public final be trySplit() {
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
        return new l(this.d, i, i3, true);
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
        return b() - this.b;
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        ai aiVar = (ai) obj;
        int iB = b();
        while (true) {
            int i = this.b;
            if (i >= iB) {
                return;
            }
            aiVar.c(this.d.a[i]);
            this.b++;
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
        int i = this.b;
        if (i >= b()) {
            return false;
        }
        byte[] bArr = this.d.a;
        this.b = i + 1;
        aiVar.c(bArr[i]);
        return true;
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return bd.c(this, consumer);
    }
}
