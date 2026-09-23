package com.google.android.libraries.navigation.internal.zf;

import com.google.android.libraries.navigation.internal.zb.o;
import com.google.android.libraries.navigation.internal.zd.n;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends c {
    public h(com.google.android.libraries.navigation.internal.zd.f fVar, n nVar) {
        super(fVar, nVar);
        setThrown((Throwable) this.a.b(o.a));
        getMessage();
    }

    public h(RuntimeException runtimeException, com.google.android.libraries.navigation.internal.zd.f fVar, n nVar) {
        super(fVar, nVar);
        setLevel(fVar.m().intValue() < Level.WARNING.intValue() ? Level.WARNING : fVar.m());
        setThrown(runtimeException);
        StringBuilder sb = new StringBuilder("LOGGING ERROR: ");
        sb.append(runtimeException.getMessage());
        sb.append('\n');
        c.a(fVar, sb);
        setMessage(sb.toString());
    }
}
