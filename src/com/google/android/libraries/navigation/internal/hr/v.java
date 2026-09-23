package com.google.android.libraries.navigation.internal.hr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public v(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Runnable a() {
        final com.google.android.libraries.navigation.internal.afo.a aVarC = com.google.android.libraries.navigation.internal.afr.e.c(this.a);
        return new Runnable() { // from class: com.google.android.libraries.navigation.internal.hr.s
            @Override // java.lang.Runnable
            public final void run() {
                ((com.google.android.libraries.navigation.internal.hs.d) aVarC.a()).a();
            }
        };
    }
}
