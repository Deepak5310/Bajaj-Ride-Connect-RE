package com.google.android.libraries.navigation.internal.wb;

import com.google.android.libraries.navigation.NightModeChangedEvent;
import com.google.android.libraries.navigation.internal.xe.y;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s {
    public com.google.android.libraries.navigation.internal.ec.c a;
    public final Executor b;
    public com.google.android.libraries.navigation.internal.ed.a c;
    public final com.google.android.libraries.navigation.internal.nt.t d = new r(this);
    private y e;

    public s(Executor executor) {
        this.b = executor;
    }

    public final void a(boolean z) {
        y yVar = this.e;
        if (yVar != null) {
            yVar.a.onNightModeChanged(new NightModeChangedEvent(z));
        }
    }

    public final void b(com.google.android.libraries.navigation.internal.ed.a aVar) {
        this.c = aVar;
        com.google.android.libraries.navigation.internal.ec.c cVar = this.a;
        if (cVar == null) {
            return;
        }
        cVar.i = aVar;
        cVar.b();
    }

    public final void c(y yVar) {
        this.e = yVar;
        com.google.android.libraries.navigation.internal.ec.c cVar = this.a;
        if (cVar == null || yVar == null) {
            return;
        }
        a(cVar.c());
    }
}
