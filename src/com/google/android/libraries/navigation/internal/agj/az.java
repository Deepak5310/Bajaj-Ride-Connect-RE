package com.google.android.libraries.navigation.internal.agj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class az extends i {
    protected int b;

    protected az(int i) {
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.i, java.util.Spliterator.OfPrimitive, java.util.Spliterator
    /* JADX INFO: renamed from: aV, reason: merged with bridge method [inline-methods] */
    public ay trySplit() {
        throw null;
    }

    protected abstract ay b(int i, int i2);

    protected abstract short c(int i);

    @Override // java.util.Spliterator
    public final int characteristics() {
        return 16720;
    }

    @Override // java.util.Spliterator.OfPrimitive
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void forEachRemaining(ag agVar) {
        int iG = g();
        while (true) {
            int i = this.b;
            if (i >= iG) {
                return;
            }
            agVar.d(c(i));
            this.b++;
        }
    }

    @Override // java.util.Spliterator
    public final long estimateSize() {
        return ((long) g()) - ((long) this.b);
    }

    @Override // java.util.Spliterator.OfPrimitive
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean tryAdvance(ag agVar) {
        if (this.b >= g()) {
            return false;
        }
        int i = this.b;
        this.b = i + 1;
        agVar.d(c(i));
        return true;
    }

    protected abstract int g();
}
