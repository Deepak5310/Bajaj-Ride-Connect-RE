package com.google.android.libraries.navigation.internal.agd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class bf extends j {
    protected int b;

    protected bf(int i) {
        this.b = i;
    }

    protected abstract byte a(int i);

    @Override // com.google.android.libraries.navigation.internal.agd.j, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aL, reason: merged with bridge method [inline-methods] */
    public be trySplit() {
        throw null;
    }

    protected abstract be c(int i, int i2);

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16720;
    }

    @Override // java.util.Spliterator.OfPrimitive
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void forEachRemaining(ai aiVar) {
        int iG = g();
        while (true) {
            int i = this.b;
            if (i >= iG) {
                return;
            }
            aiVar.c(a(i));
            this.b++;
        }
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return ((long) g()) - ((long) this.b);
    }

    @Override // java.util.Spliterator.OfPrimitive
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean tryAdvance(ai aiVar) {
        if (this.b >= g()) {
            return false;
        }
        int i = this.b;
        this.b = i + 1;
        aiVar.c(a(i));
        return true;
    }

    protected abstract int g();
}
