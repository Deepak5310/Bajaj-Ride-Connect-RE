package com.google.android.libraries.navigation.internal.abm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements com.google.android.libraries.navigation.internal.fw.b {
    private final com.google.android.libraries.navigation.internal.abg.f a;

    public b(com.google.android.libraries.navigation.internal.abg.f fVar) {
        com.google.android.libraries.navigation.internal.abf.s.j(fVar);
        this.a = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.fw.b
    public final String a() {
        return this.a.a();
    }

    @Override // com.google.android.libraries.navigation.internal.fw.b
    public final void b(final com.google.android.libraries.navigation.internal.fw.a aVar) {
        this.a.b(new com.google.android.libraries.navigation.internal.abg.e() { // from class: com.google.android.libraries.navigation.internal.abm.a
            @Override // com.google.android.libraries.navigation.internal.abg.e
            public final void a(com.google.android.libraries.navigation.internal.abg.f fVar) {
                aVar.a();
            }
        });
    }
}
