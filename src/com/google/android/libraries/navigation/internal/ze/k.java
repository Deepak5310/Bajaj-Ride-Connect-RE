package com.google.android.libraries.navigation.internal.ze;

import com.google.android.libraries.navigation.internal.zd.u;
import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements c {
    public final String a;
    public final com.google.android.libraries.navigation.internal.zd.h b;
    public final Set c;
    public final u d;
    private final Level e;

    private k() {
        this(com.google.android.libraries.navigation.internal.zd.i.NO_OP, Level.ALL, m.a, m.b);
    }

    public k(com.google.android.libraries.navigation.internal.zd.h hVar, Level level, Set set, u uVar) {
        this.a = "";
        this.b = hVar;
        this.e = level;
        this.c = set;
        this.d = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ze.c
    public final com.google.android.libraries.navigation.internal.zd.j a(String str) {
        return new m(str, this.b, this.e, this.c, this.d);
    }
}
