package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cc extends com.google.android.libraries.navigation.internal.fq.o {
    private final com.google.android.libraries.geo.mapcore.renderer.af c;
    private final boolean d;

    public cc(com.google.android.libraries.geo.mapcore.renderer.af afVar, boolean z) {
        super(256, "SingleLabelPickEntityPool");
        this.c = afVar;
        this.d = z;
    }

    @Override // com.google.android.libraries.navigation.internal.fq.o
    protected final /* bridge */ /* synthetic */ Object d() {
        com.google.android.libraries.navigation.internal.qq.ap apVar = new com.google.android.libraries.navigation.internal.qq.ap(this.c, this.d);
        apVar.f74n = new com.google.android.libraries.navigation.internal.qq.u(true, true, apVar);
        return apVar;
    }
}
