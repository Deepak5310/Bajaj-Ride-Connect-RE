package com.google.android.libraries.navigation.internal.hx;

import com.google.android.libraries.navigation.internal.aac.as;
import com.google.android.libraries.navigation.internal.yx.bx;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o implements as {
    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        if (th instanceof CancellationException) {
            return;
        }
        bx.c(th);
        throw new p(th);
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void b(Object obj) {
    }
}
