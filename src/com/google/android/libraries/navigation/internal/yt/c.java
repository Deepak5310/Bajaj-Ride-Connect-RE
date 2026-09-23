package com.google.android.libraries.navigation.internal.yt;

import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.yr.ag;
import com.google.android.libraries.navigation.internal.yr.w;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements a {
    private final w a;

    public c(w wVar) {
        this.a = wVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yt.a
    public final bj a(bj bjVar) {
        this.a.a(bjVar);
        return bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ai, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.a.close();
    }

    public final String toString() {
        String strConcat;
        w wVar = this.a;
        ag agVar = wVar.a;
        if (agVar != null) {
            strConcat = ((com.google.android.libraries.navigation.internal.yr.a) agVar).a;
        } else {
            ag agVar2 = wVar.b;
            strConcat = agVar2 != null ? ((com.google.android.libraries.navigation.internal.yr.a) agVar2).a : "Already closed: ".concat(wVar.toString());
        }
        return "GMM SpanEndSignal: ".concat(String.valueOf(strConcat));
    }
}
