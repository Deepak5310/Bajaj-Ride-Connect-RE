package com.google.android.libraries.navigation.internal.ze;

import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements c {
    private final String a;
    private final com.google.android.libraries.navigation.internal.zd.h b;

    public b() {
        com.google.android.libraries.navigation.internal.zd.i iVar = com.google.android.libraries.navigation.internal.zd.i.NO_OP;
        this.a = "";
        this.b = iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ze.c
    public final com.google.android.libraries.navigation.internal.zd.j a(String str) {
        return new l(str, this.b, Level.ALL, true, m.a, m.b);
    }
}
