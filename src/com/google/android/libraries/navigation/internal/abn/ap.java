package com.google.android.libraries.navigation.internal.abn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ap implements bf {
    public ar a = null;
    public float b;
    final /* synthetic */ float c;
    final /* synthetic */ as d;

    public ap(as asVar, float f) {
        this.c = f;
        this.d = asVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        float height = (this.c / awVar.g().getHeight()) * 6.0f;
        this.b = height;
        this.a = this.d.B(awVar, height, null, 0);
    }
}
