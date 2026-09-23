package com.google.android.libraries.navigation.internal.ze;

import com.google.android.libraries.navigation.internal.zd.u;
import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l extends a {
    private final String a;
    private final com.google.android.libraries.navigation.internal.zd.h b;
    private final Level c;
    private final boolean d;
    private final Set e;
    private final u f;

    public l(String str, com.google.android.libraries.navigation.internal.zd.h hVar, Level level, boolean z, Set set, u uVar) {
        super(str);
        this.a = "";
        this.b = hVar;
        this.c = level;
        this.d = true;
        this.e = set;
        this.f = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.j
    public final void c(com.google.android.libraries.navigation.internal.zd.f fVar) {
        String strA = (String) fVar.i().d(com.google.android.libraries.navigation.internal.zc.a.a);
        if (strA == null) {
            strA = a();
        }
        if (strA == null) {
            fVar.f().b();
        }
        m.e(fVar, this.b, this.c, this.e, this.f);
    }

    @Override // com.google.android.libraries.navigation.internal.zd.j
    public final boolean d(Level level) {
        return true;
    }
}
