package com.google.android.libraries.navigation.internal.agd;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bi implements be {
    private final al a;
    private long b;
    private int c = 1024;
    private be d = null;

    public bi(al alVar, long j) {
        this.a = alVar;
        this.b = j;
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aL */
    public final be trySplit() {
        if (!this.a.hasNext()) {
            return null;
        }
        long j = this.b;
        int iMin = j > 0 ? (int) Math.min(this.c, j) : this.c;
        byte[] bArrCopyOf = new byte[iMin];
        int i = 0;
        while (i < iMin && this.a.hasNext()) {
            bArrCopyOf[i] = this.a.c();
            this.b--;
            i++;
        }
        if (iMin < this.c && this.a.hasNext()) {
            bArrCopyOf = Arrays.copyOf(bArrCopyOf, this.c);
            while (this.a.hasNext() && i < this.c) {
                bArrCopyOf[i] = this.a.c();
                this.b--;
                i++;
            }
        }
        this.c = Math.min(33554432, this.c + 1024);
        q.a(bArrCopyOf, 0, i);
        bg bgVar = new bg(bArrCopyOf, 0, i);
        if (this.a.hasNext()) {
            return bgVar;
        }
        this.d = bgVar;
        return bgVar.trySplit();
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
        be beVar = this.d;
        if (beVar != null) {
            return beVar.estimateSize();
        }
        if (!this.a.hasNext()) {
            return 0L;
        }
        long j = this.b;
        if (j >= 0) {
            return j;
        }
        return Long.MAX_VALUE;
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        ai aiVar = (ai) obj;
        be beVar = this.d;
        if (beVar != null) {
            beVar.forEachRemaining(aiVar);
            this.d = null;
        }
        this.a.forEachRemaining(aiVar);
        this.b = 0L;
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
        be beVar = this.d;
        if (beVar != null) {
            boolean zTryAdvance = beVar.tryAdvance(aiVar);
            if (zTryAdvance) {
                return zTryAdvance;
            }
            this.d = null;
            return zTryAdvance;
        }
        if (!this.a.hasNext()) {
            return false;
        }
        this.b--;
        aiVar.c(this.a.c());
        return true;
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return bd.c(this, consumer);
    }
}
