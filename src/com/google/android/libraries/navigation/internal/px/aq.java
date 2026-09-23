package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.adg.jb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class aq {
    static final aq a = d(ar.b, ar.c, am.BLANK);

    static aq d(jb jbVar, com.google.android.libraries.navigation.internal.qc.i iVar, am amVar) {
        if (iVar == null) {
            iVar = ar.c;
        }
        return new l(jbVar, iVar, amVar);
    }

    public abstract am a();

    public abstract com.google.android.libraries.navigation.internal.qc.i b();

    public abstract jb c();

    public final boolean e() {
        if (a() != am.ICON || (c().b & 1) == 0) {
            return a() == am.TEXT && (c().b & 2) != 0;
        }
        return true;
    }
}
