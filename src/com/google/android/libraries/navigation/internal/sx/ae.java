package com.google.android.libraries.navigation.internal.sx;

import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bn;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae {
    private final aj a;
    private final bn b;

    public ae(aj ajVar, bn bnVar) {
        this.a = ajVar;
        this.b = bnVar;
    }

    public final bj a(ap apVar) {
        if (apVar.o() == null) {
            return this.a.a().a(apVar);
        }
        return com.google.android.libraries.navigation.internal.aac.az.m(this.a.a().a(apVar), ((Long) Objects.requireNonNull(apVar.o())).longValue(), TimeUnit.MILLISECONDS, this.b);
    }
}
