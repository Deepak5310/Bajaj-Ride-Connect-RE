package com.google.android.libraries.navigation.internal.gp;

import com.google.android.libraries.navigation.internal.aac.as;
import java.util.concurrent.CancellationException;
import org.chromium.net.UrlRequest;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j implements as {
    final /* synthetic */ UrlRequest a;

    public j(UrlRequest urlRequest) {
        this.a = urlRequest;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
        if (th instanceof CancellationException) {
            this.a.cancel();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
    }
}
