package com.google.android.libraries.navigation.internal.aga;

import java.text.MessageFormat;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class o extends com.google.android.libraries.navigation.internal.afx.g {
    private final p a;
    private final et b;

    public o(p pVar, et etVar) {
        com.google.android.libraries.navigation.internal.yx.ar.r(pVar, "tracer");
        this.a = pVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(etVar, "time");
        this.b = etVar;
    }

    public static Level c(int i) {
        int i2 = i - 1;
        if (i2 != 1) {
            return (i2 == 2 || i2 == 3) ? Level.FINE : Level.FINEST;
        }
        return Level.FINER;
    }

    static void d(com.google.android.libraries.navigation.internal.afx.aj ajVar, int i, String str) {
        Level levelC = c(i);
        if (p.a.isLoggable(levelC)) {
            p.a(ajVar, levelC, str);
        }
    }

    private final boolean e(int i) {
        if (i == 1) {
            return false;
        }
        synchronized (this.a.b) {
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.afx.g
    public final void a(int i, String str) {
        com.google.android.libraries.navigation.internal.afx.ae aeVar;
        d(this.a.c, i, str);
        if (!e(i) || i == 1) {
            return;
        }
        p pVar = this.a;
        com.google.android.libraries.navigation.internal.afx.ad adVar = new com.google.android.libraries.navigation.internal.afx.ad();
        adVar.a = str;
        int i2 = i - 1;
        if (i2 != 2) {
            aeVar = i2 != 3 ? com.google.android.libraries.navigation.internal.afx.ae.CT_INFO : com.google.android.libraries.navigation.internal.afx.ae.CT_ERROR;
        } else {
            aeVar = com.google.android.libraries.navigation.internal.afx.ae.CT_WARNING;
        }
        adVar.b = aeVar;
        adVar.b(this.b.a());
        pVar.c(adVar.a());
    }

    @Override // com.google.android.libraries.navigation.internal.afx.g
    public final void b(int i, String str, Object... objArr) {
        a(i, (e(i) || p.a.isLoggable(c(i))) ? MessageFormat.format(str, objArr) : null);
    }
}
