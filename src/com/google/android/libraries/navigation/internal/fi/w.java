package com.google.android.libraries.navigation.internal.fi;

import android.location.Location;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.dh.ai;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w implements c {
    private final com.google.android.libraries.navigation.internal.ia.e a;
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private final bg c;
    private final float d;
    private final double e;

    public w(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.mj.a aVar, bg bgVar, float f, double d) {
        this.a = eVar;
        this.b = aVar;
        this.c = bgVar;
        ar.a(f > 0.0f);
        this.d = f;
        ar.a(d >= 0.0d);
        this.e = d;
    }

    @Override // com.google.android.libraries.navigation.internal.fi.c
    public final void a(t tVar) {
        n nVar = new n(this.c, this.d, this.b);
        double d = this.e;
        boolean z = false;
        if (d > 0.0d) {
            ar.a(d >= 0.0d);
            nVar.b = d;
            nVar.a(0L);
        }
        long jA = this.b.a();
        int i = 5;
        while (tVar.e()) {
            this.a.b(new ai(6, 6, 30.0f, 30.0f, false));
            Location location = nVar.a;
            if (z) {
                location.setTime(this.b.f().toEpochMilli());
                location.setElapsedRealtimeNanos(TimeUnit.MILLISECONDS.toNanos(this.b.a()));
            }
            this.a.b(new com.google.android.libraries.navigation.internal.dh.a(location));
            tVar.f();
            tVar.g();
            long jA2 = this.b.a();
            if (!z) {
                z = !nVar.a(jA2 - jA);
            }
            if (z) {
                if (i <= 0) {
                    return;
                } else {
                    i--;
                }
            }
            jA = jA2;
        }
    }
}
