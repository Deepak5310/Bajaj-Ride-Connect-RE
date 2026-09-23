package com.google.android.libraries.navigation.environment;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class av {
    public final /* synthetic */ am a;

    public final void a() {
        final am amVar = this.a;
        amVar.S().execute(new Runnable() { // from class: com.google.android.libraries.navigation.environment.ao
            @Override // java.lang.Runnable
            public final void run() {
                am amVar2 = amVar;
                com.google.android.libraries.navigation.internal.ny.e eVarBs = amVar2.bs();
                com.google.android.libraries.navigation.internal.zt.q qVar = (com.google.android.libraries.navigation.internal.zt.q) ay.a(amVar2, false).t();
                eVarBs.a.c("ApplicationProcessCrashed").a(0L, 1L, com.google.android.libraries.navigation.internal.ky.ah.a(qVar));
                eVarBs.a();
                com.google.android.libraries.navigation.internal.ny.e.e(qVar);
            }
        });
    }
}
