package com.google.android.libraries.navigation.internal.afx;

import androidx.core.app.NotificationCompat;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class as {
    public static final as a = new as(null, cl.b, false);
    public final aw b;
    public final cl c;
    public final boolean d;
    private final i e = null;

    private as(aw awVar, cl clVar, boolean z) {
        this.b = awVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(clVar, NotificationCompat.CATEGORY_STATUS);
        this.c = clVar;
        this.d = z;
    }

    public static as a(cl clVar) {
        com.google.android.libraries.navigation.internal.yx.ar.b(!clVar.c(), "drop status shouldn't be OK");
        return new as(null, clVar, true);
    }

    public static as b(cl clVar) {
        com.google.android.libraries.navigation.internal.yx.ar.b(!clVar.c(), "error status shouldn't be OK");
        return new as(null, clVar, false);
    }

    public static as c(aw awVar) {
        return new as(awVar, cl.b, false);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof as)) {
            return false;
        }
        as asVar = (as) obj;
        if (com.google.android.libraries.navigation.internal.yx.am.a(this.b, asVar.b) && com.google.android.libraries.navigation.internal.yx.am.a(this.c, asVar.c)) {
            i iVar = asVar.e;
            if (com.google.android.libraries.navigation.internal.yx.am.a(null, null) && this.d == asVar.d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, null, Boolean.valueOf(this.d)});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("subchannel", this.b);
        akVarB.g("streamTracerFactory", null);
        akVarB.g(NotificationCompat.CATEGORY_STATUS, this.c);
        com.google.android.libraries.navigation.internal.yx.ak akVarE = akVarB.e("drop", this.d);
        akVarE.g("authority-override", null);
        return akVarE.toString();
    }
}
