package com.google.android.libraries.navigation.internal.rz;

import com.google.android.libraries.navigation.internal.adr.hs;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class an {
    public static al g(am amVar) {
        q qVar = new q();
        Objects.requireNonNull(amVar);
        qVar.a = amVar;
        qVar.f("");
        qVar.c("");
        qVar.b(hs.SIDE_UNSPECIFIED);
        qVar.e(ae.b().a());
        qVar.d(true);
        return qVar;
    }

    public abstract ae a();

    public abstract am b();

    public abstract hs c();

    public abstract String d();

    public abstract String e();

    public abstract boolean f();
}
