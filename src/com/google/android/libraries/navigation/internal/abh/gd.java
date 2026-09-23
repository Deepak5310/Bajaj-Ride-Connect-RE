package com.google.android.libraries.navigation.internal.abh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gd implements ge {
    private static final String a = "gd";
    private final com.google.android.libraries.navigation.internal.yx.br b;

    public gd(com.google.android.libraries.navigation.internal.yx.br brVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(brVar, "drd");
        this.b = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ge
    public final void c(boolean z, boolean z2, String str, String str2) {
        com.google.android.libraries.navigation.internal.abf.p.f(a, 4);
        if (z || z2) {
            if (str2 != null) {
                com.google.android.libraries.navigation.internal.abf.p.c(str2);
            } else if (z2) {
                com.google.android.libraries.navigation.internal.abf.p.c("This application has been blocked by the Google Maps SDK for Android. This might be because of an incorrectly registered key.");
            } else {
                com.google.android.libraries.navigation.internal.abf.p.c("This application has exceeded its quota for the Google Maps SDK for Android.");
            }
            ((com.google.android.libraries.navigation.internal.abg.q) this.b.a()).v();
        }
    }
}
