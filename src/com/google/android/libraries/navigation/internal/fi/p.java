package com.google.android.libraries.navigation.internal.fi;

import android.location.Location;
import com.google.android.libraries.navigation.internal.dh.ai;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p implements c {
    private static final String a = "p";
    private final com.google.android.libraries.navigation.internal.ia.e b;
    private final com.google.android.libraries.navigation.internal.mj.a c;
    private final Location d;

    public p(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.mj.a aVar, Location location) {
        this.b = eVar;
        this.c = aVar;
        this.d = location;
    }

    @Override // com.google.android.libraries.navigation.internal.fi.c
    public final void a(t tVar) {
        while (tVar.e()) {
            this.d.setTime(this.c.f().toEpochMilli());
            this.d.setElapsedRealtimeNanos(TimeUnit.MILLISECONDS.toNanos(this.c.a()));
            this.b.b(new ai(6, 6, 30.0f, 30.0f, false));
            this.b.b(new com.google.android.libraries.navigation.internal.dh.a(this.d));
            tVar.f();
            tVar.g();
        }
    }
}
