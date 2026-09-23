package com.google.android.libraries.navigation.internal.agj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m extends bb {
    final /* synthetic */ n a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar) {
        super(nVar.b);
        this.a = nVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.bb
    protected final int a() {
        return this.a.c;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.az
    protected final /* bridge */ /* synthetic */ ay b(int i, int i2) {
        return new m(this.a, i, i2);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.az
    protected final short c(int i) {
        return this.a.d.a[i];
    }

    @Override // com.google.android.libraries.navigation.internal.agj.az
    /* JADX INFO: renamed from: e */
    public final void forEachRemaining(ag agVar) {
        int iG = g();
        while (true) {
            int i = this.b;
            if (i >= iG) {
                return;
            }
            short[] sArr = this.a.d.a;
            this.b = i + 1;
            agVar.d(sArr[i]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agj.az
    /* JADX INFO: renamed from: f */
    public final boolean tryAdvance(ag agVar) {
        if (this.b >= g()) {
            return false;
        }
        short[] sArr = this.a.d.a;
        int i = this.b;
        this.b = i + 1;
        agVar.d(sArr[i]);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.az, java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        forEachRemaining((ag) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.az, java.util.Spliterator.OfPrimitive
    public final /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        return tryAdvance((ag) obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private m(n nVar, int i, int i2) {
        super(i, i2);
        this.a = nVar;
    }
}
