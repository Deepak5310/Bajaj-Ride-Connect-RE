package com.google.android.libraries.navigation.internal.afx;

import androidx.core.app.NotificationCompat;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bs {
    public final cl a;
    public final Object b;

    public bs(cl clVar) {
        this.b = null;
        com.google.android.libraries.navigation.internal.yx.ar.r(clVar, NotificationCompat.CATEGORY_STATUS);
        this.a = clVar;
        com.google.android.libraries.navigation.internal.yx.ar.f(!clVar.c(), "cannot use OK status: %s", clVar);
    }

    public bs(Object obj) {
        this.b = obj;
        this.a = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            bs bsVar = (bs) obj;
            if (com.google.android.libraries.navigation.internal.yx.am.a(this.a, bsVar.a) && com.google.android.libraries.navigation.internal.yx.am.a(this.b, bsVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        if (this.b != null) {
            com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
            akVarB.g("config", this.b);
            return akVarB.toString();
        }
        com.google.android.libraries.navigation.internal.yx.ak akVarB2 = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB2.g("error", this.a);
        return akVarB2.toString();
    }
}
