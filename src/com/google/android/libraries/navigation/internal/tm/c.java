package com.google.android.libraries.navigation.internal.tm;

import android.app.PendingIntent;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.tp.f {
    public final e a;
    public final com.google.android.libraries.navigation.internal.ws.c b;
    public b c = null;

    public c(e eVar, com.google.android.libraries.navigation.internal.ws.c cVar) {
        this.a = eVar;
        this.b = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tp.f
    public final void a() {
        this.b.f();
        b bVar = this.c;
        if (bVar != null) {
            bVar.c.b();
            this.c = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.tp.f
    public final void b() {
        this.c = null;
    }

    @Override // com.google.android.libraries.navigation.internal.tp.f
    public final void c(boolean z, long j, boolean z2, PendingIntent pendingIntent) {
        b bVar = this.c;
        if (bVar != null) {
            bVar.a(pendingIntent);
        }
    }
}
