package com.google.android.libraries.navigation.internal.abn;

import com.google.android.gms.maps.model.CameraPosition;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class ag {
    public final CameraPosition a;
    public final CameraPosition b;
    public final long c;

    public ag(CameraPosition cameraPosition, CameraPosition cameraPosition2, long j) {
        this.a = cameraPosition;
        com.google.android.libraries.navigation.internal.abf.s.k(cameraPosition2, "dest");
        this.b = cameraPosition2;
        com.google.android.libraries.navigation.internal.abf.s.b(j >= 0, "invalid durationMs: %s", Long.valueOf(j));
        this.c = j;
    }

    protected abstract double a(double d);

    protected abstract double b(double d, double d2, double d3);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ag)) {
            return false;
        }
        ag agVar = (ag) obj;
        return com.google.android.libraries.navigation.internal.abf.r.a(this.a, agVar.a) && com.google.android.libraries.navigation.internal.abf.r.a(this.b, agVar.b) && this.c == agVar.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, Long.valueOf(this.c)});
    }
}
