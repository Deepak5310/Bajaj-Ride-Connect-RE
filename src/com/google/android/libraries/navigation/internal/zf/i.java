package com.google.android.libraries.navigation.internal.zf;

import com.google.android.libraries.navigation.internal.zd.ah;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends a {
    public i(Logger logger) {
        super(logger);
    }

    @Override // com.google.android.libraries.navigation.internal.zd.j
    public final void b(RuntimeException runtimeException, com.google.android.libraries.navigation.internal.zd.f fVar) {
        e(new h(runtimeException, fVar, ah.f()), fVar.C());
    }

    @Override // com.google.android.libraries.navigation.internal.zd.j
    public final void c(com.google.android.libraries.navigation.internal.zd.f fVar) {
        e(new h(fVar, ah.f()), fVar.C());
    }
}
