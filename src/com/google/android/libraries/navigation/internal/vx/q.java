package com.google.android.libraries.navigation.internal.vx;

import com.google.android.libraries.navigation.internal.aac.as;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q implements as {
    final /* synthetic */ com.google.android.libraries.navigation.internal.vp.f a;

    public q(com.google.android.libraries.navigation.internal.vp.f fVar) {
        this.a = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        if (th instanceof TimeoutException) {
            this.a.a(com.google.android.libraries.navigation.internal.vp.c.LOCATION_UNKNOWN);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
    }
}
