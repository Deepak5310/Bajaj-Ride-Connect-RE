package com.google.android.libraries.navigation.internal.vq;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.d;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends d implements Future {
    private final Executor a;

    public b(Executor executor) {
        this.a = executor;
    }

    public static b a() {
        return new b(c.a);
    }

    public final void c(com.google.android.libraries.navigation.internal.vp.a aVar) {
        az.o(this, new a(aVar), this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    public final boolean d(Object obj) {
        return super.d(obj);
    }
}
