package com.google.android.libraries.navigation.internal.abl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements com.google.android.libraries.navigation.internal.b.x {
    @Override // com.google.android.libraries.navigation.internal.b.x
    public final void a(com.google.android.libraries.navigation.internal.b.ad adVar) {
        if (adVar.getCause() instanceof OutOfMemoryError) {
            throw new OutOfMemoryError("Rethrowing Volley OOM error: ".concat(String.valueOf(String.valueOf(adVar.getCause()))));
        }
        if (com.google.android.libraries.navigation.internal.abf.x.a(adVar.getMessage()) || !com.google.android.libraries.navigation.internal.abf.p.f(i.a, 6)) {
            return;
        }
        adVar.getMessage();
    }
}
