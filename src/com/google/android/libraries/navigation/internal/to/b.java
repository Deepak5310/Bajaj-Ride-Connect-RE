package com.google.android.libraries.navigation.internal.to;

import android.app.PendingIntent;
import com.google.android.libraries.navigation.internal.tp.f;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements f {
    public final com.google.android.libraries.navigation.internal.ws.c a;
    public final com.google.android.libraries.navigation.internal.agl.a b;
    public a c;

    public b(com.google.android.libraries.navigation.internal.ws.c cVar, com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = cVar;
        this.b = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tp.f
    public final void a() {
        this.a.f();
        a aVar = this.c;
        if (aVar != null) {
            aVar.a.b();
            this.c = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.tp.f
    public final void b() {
        this.c = null;
    }

    @Override // com.google.android.libraries.navigation.internal.tp.f
    public final void c(boolean z, long j, boolean z2, PendingIntent pendingIntent) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(pendingIntent);
        }
    }
}
