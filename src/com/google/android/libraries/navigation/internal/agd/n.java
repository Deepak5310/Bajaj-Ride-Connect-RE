package com.google.android.libraries.navigation.internal.agd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n extends bh {
    final /* synthetic */ o a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar) {
        super(oVar.b);
        this.a = oVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.bf
    protected final byte a(int i) {
        return this.a.d.a[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agd.bh
    protected final int b() {
        return this.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.bf
    protected final /* bridge */ /* synthetic */ be c(int i, int i2) {
        return new n(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.bf
    /* JADX INFO: renamed from: e */
    public final void forEachRemaining(ai aiVar) {
        int iG = g();
        while (true) {
            int i = this.b;
            if (i >= iG) {
                return;
            }
            byte[] bArr = this.a.d.a;
            this.b = i + 1;
            aiVar.c(bArr[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agd.bf
    /* JADX INFO: renamed from: f */
    public final boolean tryAdvance(ai aiVar) {
        if (this.b >= g()) {
            return false;
        }
        byte[] bArr = this.a.d.a;
        int i = this.b;
        this.b = i + 1;
        aiVar.c(bArr[i]);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.bf, java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        forEachRemaining((ai) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.bf, java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        return tryAdvance((ai) obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private n(o oVar, int i, int i2) {
        super(i, i2);
        this.a = oVar;
    }
}
