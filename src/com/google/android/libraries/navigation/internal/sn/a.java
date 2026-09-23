package com.google.android.libraries.navigation.internal.sn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends b {
    final /* synthetic */ e a;
    private final int c;
    private final Integer d;

    public a(e eVar, float f, int i, Integer num) {
        this(eVar, (int) f, i, num);
    }

    @Override // com.google.android.libraries.navigation.internal.sn.b
    protected final String a(int i) {
        Integer num = this.d;
        if (num != null) {
            return this.a.b.getResources().getQuantityString(this.c, num.intValue(), String.valueOf(num));
        }
        e eVar = this.a;
        return eVar.b.getString(this.c);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar, int i, int i2, Integer num) {
        super(i);
        this.a = eVar;
        this.c = i2;
        this.d = num;
    }
}
