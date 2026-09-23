package com.google.android.libraries.navigation.internal.sn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends b {
    final /* synthetic */ e a;
    private final float c;
    private final int d;

    public d(e eVar, int i) {
        this(eVar, 2092, i, 1609.344f);
    }

    @Override // com.google.android.libraries.navigation.internal.sn.b
    protected final String a(int i) {
        int iRound = Math.round(i / this.c);
        return this.a.b.getResources().getQuantityString(this.d, iRound, Integer.valueOf(iRound));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, int i, int i2, float f) {
        super(i);
        this.a = eVar;
        this.c = f;
        this.d = i2;
    }
}
