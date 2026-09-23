package com.google.android.libraries.navigation.internal.afx;

import androidx.core.app.NotificationCompat;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cm {
    private final cl a;
    private final Object b;

    public cm(cl clVar, Object obj) {
        this.a = clVar;
        this.b = obj;
    }

    public static cm b(cl clVar) {
        com.google.android.libraries.navigation.internal.yx.ar.r(clVar, NotificationCompat.CATEGORY_STATUS);
        cm cmVar = new cm(clVar, null);
        com.google.android.libraries.navigation.internal.yx.ar.f(!clVar.c(), "cannot use OK status: %s", clVar);
        return cmVar;
    }

    public final cl a() {
        cl clVar = this.a;
        return clVar == null ? cl.b : clVar;
    }

    public final Object c() {
        if (this.a == null) {
            return this.b;
        }
        throw new IllegalStateException("No value present.");
    }

    public final boolean d() {
        return this.a == null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof cm)) {
            return false;
        }
        cm cmVar = (cm) obj;
        if (d() == cmVar.d()) {
            return d() ? com.google.android.libraries.navigation.internal.yx.am.a(this.b, cmVar.b) : com.google.android.libraries.navigation.internal.yx.am.a(this.a, cmVar.a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        cl clVar = this.a;
        if (clVar == null) {
            akVarB.g("value", this.b);
        } else {
            akVarB.g("error", clVar);
        }
        return akVarB.toString();
    }
}
